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
            int k = in.nextInt();
            int[] a = in.nextIntArray(n);

            Arrays.sort(a);
            int high = n;
            int low = -1;
            while (high - low > 1) {
                int mid = (high + low) / 2;
                if (isNeed(a, k, mid)) {
                    high = mid;
                } else {
                    low = mid;
                }
            }

            out.println(high);
        }

        boolean isNeed(int[] a, int k, int idx) {
            int n = a.length;
            boolean[] can = new boolean[k];
            can[0] = true;
            for (int i = 0; i < n; i++) {
                if (i == idx) continue;
                for (int j = k - 1; j >= 0; j--) {
                    if (j - a[i] >= 0 && j - a[i] < k && can[j - a[i]]) {
                        can[j] = true;
                    }
                }
            }

            for (int i = Math.max(0, k - a[idx]); i < k; i++) {
                if (can[i]) return true;
            }
            return false;
        }

    }

    static class InputReader {
        private BufferedReader in;
        private StringTokenizer tok;

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

        public int[] nextIntArray(int n) {
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextInt();
            }
            return res;
        }

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
            tok = new StringTokenizer("");
        }

    }
}

