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
 * @author vikas.k
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int N = in.nextInt();
            long[] a = new long[N + 1];
            for (int i = 1; i <= N; i++) {
                a[i] = in.nextLong();
            }
            long ans = 0;
            while (true) {
                boolean cont = false;
                for (int i = 1; i <= N; i++) {
                    if (a[i] >= N) {
                        long u = a[i] / N;
                        a[i] = a[i] % N;

                        if (u > 0) {
                            cont = true;
                            for (int j = 1; j <= N; j++) {
                                if (i != j) a[j] += u;
                            }
                            ans += u;
                        }
                    }
                }
                if (!cont) break;
            }
            out.println(ans);
        }

    }

    static class FastScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            if (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

