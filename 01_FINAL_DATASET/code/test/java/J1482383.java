import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
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
            long[] a = in.nextLongArray(3 * n);

            long[] pre = new long[n + 1];
            PriorityQueue<Long> q1 = new PriorityQueue<>();
            long sum1 = 0;
            for (int i = 0; i < n; i++) {
                q1.add(a[i]);
                sum1 += a[i];
            }
            pre[0] = sum1;
            for (int i = n; i < 2 * n; i++) {
                long x = q1.poll();
                long max = Math.max(x, a[i]);
                sum1 += max - x;
                pre[i - n + 1] = sum1;
                q1.add(max);
            }

            long[] post = new long[n + 1];
            PriorityQueue<Long> q2 = new PriorityQueue<>(Comparator.reverseOrder());
            long sum2 = 0;
            for (int i = 3 * n - 1; i >= 2 * n; i--) {
                q2.add(a[i]);
                sum2 += a[i];
            }
            post[0] = sum2;
            for (int i = 2 * n - 1; i >= n; i--) {
                long x = q2.poll();
                long min = Math.min(x, a[i]);
                sum2 -= x - min;
                post[2 * n - i] = sum2;
                q2.add(min);
            }

            long ans = Long.MIN_VALUE;
            for (int i = 0; i < n + 1; i++) {
                ans = Math.max(ans, pre[i] - post[n - i]);
            }

            out.println(ans);
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

        public long nextLong() {
            return Long.parseLong(nextString());
        }

        public long[] nextLongArray(int n) {
            long[] res = new long[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
            tok = new StringTokenizer("");
        }

    }
}

