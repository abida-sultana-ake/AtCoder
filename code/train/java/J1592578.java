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
            int r = in.nextInt();
            int[] ri = in.nextIntArray0indexed(r);

            WarshallFloyd wf = new WarshallFloyd(n);
            for (int i = 0; i < m; i++) {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;
                int cost = in.nextInt();

                wf.addUndirectedEdge(from, to, cost);
            }
            int[][] dist = wf.getDist();

            int[] a = new int[r];
            for (int i = 0; i < r; i++) {
                a[i] = i;
            }
            long ans = Long.MAX_VALUE;
            do {
                long tmp = 0;
                for (int i = 0; i < r - 1; i++) {
                    tmp += dist[ri[a[i]]][ri[a[i + 1]]];
                }

                ans = Math.min(ans, tmp);
            } while (Permutation.next(a));

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

        public int[] nextIntArray0indexed(int n) {
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextInt() - 1;
            }
            return res;
        }

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
            tok = new StringTokenizer("");
        }

    }

    static class Permutation {
        public static boolean next(int[] a) {
            int n = a.length;

            int i = n - 1;
            while (i > 0 && a[i - 1] >= a[i]) i--;
            if (i <= 0) return false;

            int j = n - 1;
            while (a[j] <= a[i - 1]) j--;
            swap(a, i - 1, j);

            int k = n - 1;
            while (i < k) swap(a, i++, k--);

            return true;
        }

        private static void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

    }

    static class WarshallFloyd {
        int n;
        int[][] dist;
        int INF = Integer.MAX_VALUE / 3;

        public WarshallFloyd(int[][] a) {
            n = a.length;
            for (int i = 0; i < n; i++) {
                dist[i] = a[i].clone();
            }
        }

        public WarshallFloyd(int n) {
            this.n = n;
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }
        }

        public void addUndirectedEdge(int from, int to, int cost) {
            dist[from][to] = cost;
            dist[to][from] = cost;
        }

        public int[][] getDist() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                    }
                }
            }
            return dist;
        }

    }
}

