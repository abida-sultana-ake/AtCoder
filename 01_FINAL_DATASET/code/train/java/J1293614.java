import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[m];
            int[] b = new int[m];
            int[] c = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = in.nextInt() - 1;
                b[i] = in.nextInt() - 1;
                c[i] = -in.nextInt();
            }

            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE / 3);
            dist[0] = 0;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m; j++) {
                    if (dist[a[j]] == Long.MAX_VALUE / 3) continue;

                    if (dist[b[j]] > dist[a[j]] + c[j]) {
                        dist[b[j]] = dist[a[j]] + c[j];
                    }
                }
            }

            boolean[] canFromLoop = new boolean[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dist[a[j]] == Long.MAX_VALUE / 3) continue;

                    if (dist[b[j]] > dist[a[j]] + c[j]) {
                        canFromLoop[a[j]] = true;
                    }

                    if (canFromLoop[a[j]]) {
                        canFromLoop[b[j]] = true;
                    }
                }
            }

            out.println(canFromLoop[n - 1] ? "inf" : -dist[n - 1]);
        }

    }

    static class InputReader {
        BufferedReader in;
        StringTokenizer tok;

        public String nextString() {
            while (!tok.hasMoreTokens()) {
                try {
                    tok = new StringTokenizer(in.readLine(), " ");
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
            }
            return tok.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
            tok = new StringTokenizer("");
        }

    }
}

