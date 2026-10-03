import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author HossamDoma
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {


            int n = in.nextInt();
            int m = in.nextInt();

            long ans = 0;
            int mod = ((int) 1e9) + 7;

            if (Math.abs(n - m) > 1) {
                ans = 0;
                out.println(ans);
                return;
            }


            ans = n;

            int tmp = n - 1;
            int tmp2 = m;

            for (int i = 1; i < (n + m); ++i) {

                if (i % 2 == 1)
                    ans = (ans * tmp2--) % mod;

                else
                    ans = (ans * tmp--) % mod;
            }

            tmp = n;
            tmp2 = m - 1;

            long ans2 = m;

            for (int i = 1; i < (n + m); ++i) {

                if (i % 2 == 1)
                    ans2 = (ans2 * tmp--) % mod;

                else
                    ans2 = (ans2 * tmp2--) % mod;
            }


            out.println((ans + ans2) % mod);


        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

