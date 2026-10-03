import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int test_cases = 1;
        Solver s = new Solver();
        for (int i = test_cases; i >= 1; i--) {
            s.solve(1, in, out);
        }
        out.close();
    }

    static class Solver {
        public void solve(int test_number, InputReader in, PrintWriter out) throws IOException {
            long n = in.nextLong();
            int k = in.nextInt();
            int[] a = new int[k];
            for (int i = 0; i < k; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            while (true) {
                if (check(a, n)) {
                    out.println(n);
                    return;
                }
                n++;
            }
        }

        private boolean check(int[] a, long n) {
            while (n > 0) {
                if (Arrays.binarySearch(a, (int) (n % 10)) > -1) return false;
                n /= 10;
            }
            return true;
        }
    }
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}