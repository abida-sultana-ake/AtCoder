import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractCollection;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
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
            int n = in.nextInt();
            int[] a = new int[n];
            int[] where = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt() - 1;
                where[a[i]] = i;
            }
            int[] res = new int[n];
            int ptr = 0;
            IntervalTree tree = new IntervalTree(n);
            tree.build(a);

            PriorityQueue<Segment> pq = new PriorityQueue<>();
            pq.offer(new Segment(0, n - 1, tree.min(0, n - 1)));
            while (!pq.isEmpty()) {
                Segment seg = pq.poll();
                int l = seg.l;
                int r = seg.r;
                if (l > r) {
                    continue;
                }
                int xi = tree.min(l, r);
                int i = where[xi];
                int xj = tree.min(i + 1, r);
                int j = where[xj];
                res[ptr++] = xi;
                res[ptr++] = xj;
                pq.offer(new Segment(l, i - 1, tree.min(l, i - 1)));
                pq.offer(new Segment(j + 1, r, tree.min(j + 1, r)));
                pq.offer(new Segment(i + 1, j - 1, tree.min(i + 1, j - 1)));
            }

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    out.print(" ");
                }
                out.print(res[i] + 1);
            }
            out.println();
        }

        class IntervalTree {
            int[][] min;
            int n;
            final int infinity = (int) 1e9;

            IntervalTree(int n) {
                this.n = n;
                min = new int[2][4 * n];
                Arrays.fill(min[0], infinity);
                Arrays.fill(min[1], infinity);
            }

            public void build(int[] a) {
                buildRec(0, 0, n - 1, a);
            }

            private void buildRec(int root, int L, int R, int[] leaves) {
                if (L == R) {
                    min[L % 2][root] = leaves[L];
                    min[(L + 1) % 2][root] = infinity;
                    return;
                }
                int M = (L + R) / 2;
                buildRec(2 * root + 1, L, M, leaves);
                buildRec(2 * root + 2, M + 1, R, leaves);
                pull(root);
            }

            int min(int l, int r) {
                if (l > r) {
                    return infinity;
                }
                return get(0, l, r, 0, n - 1, l % 2);
            }

            private int get(int root, int l, int r, int L, int R, int parity) {
                if (l > r || l > R || L > r || L > R) {
                    return infinity;
                }
                if (l == L && r == R) {
                    return min[parity][root];
                }
                int M = (L + R) / 2;
                int res = infinity;
                res = Math.min(res, get(2 * root + 1, l, Math.min(r, M), L, M, parity));
                res = Math.min(res, get(2 * root + 2, Math.max(l, M + 1), r, M + 1, R, parity));
                return res;
            }

            private void pull(int root) {
                for (int i = 0; i < 2; i++) {
                    min[i][root] = Math.min(min[i][2 * root + 1], min[i][2 * root + 2]);
                }
            }

        }

        class Segment implements Comparable<Segment> {
            int l;
            int r;
            int val;

            Segment(int l, int r, int val) {
                this.l = l;
                this.r = r;
                this.val = val;
            }

            public int compareTo(Segment o) {
                if (val != o.val) {
                    return val < o.val ? -1 : 1;
                }
                return 0;
            }

        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

