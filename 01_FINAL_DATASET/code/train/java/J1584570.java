import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;
import java.io.BufferedReader;
import java.util.LinkedList;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        int[] R;
        int n;
        int m;
        int r;
        int[][] cost;
        boolean[] marked;

        public void solve(int testNumber, InputReader in, PrintWriter out) {

            n = in.nextInt();
            m = in.nextInt();
            r = in.nextInt();

            R = new int[r];
            for (int i = 0; i < r; ++i) {
                R[i] = in.nextInt();
            }

            List<Pair> g[] = new ArrayList[n + 1];
            for (int i = 1; i <= n; ++i)
                g[i] = new ArrayList<>();

            for (int i = 0; i < m; ++i) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                g[a].add(new Pair(b, c));
                g[b].add(new Pair(a, c));
            }

            cost = new int[n + 1][n + 1];
            for (int i = 1; i <= n; ++i)
                Arrays.fill(cost[i], Integer.MAX_VALUE);

            for (int node : R) {

                Queue<Integer> q = new LinkedList<>();
                q.add(node);

                cost[node][node] = 0;

                while (!q.isEmpty()) {

                    int t = q.poll();

                    for (Pair p : g[t]) {

                        int tt = p.x;
                        int cc = p.y;

                        if (cost[node][t] + cc < cost[node][tt]) {
                            cost[node][tt] = cost[node][t] + cc;
                            q.add(tt);
                        }
                    }
                }
            }

            marked = new boolean[r];

            int ans = permute(-1, r, 0);

            out.println(ans);

        }

        private int permute(int prev, int sz, int cc) {

            if (sz == 0)
                return cc;

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < r; ++i) {
                if (marked[i]) continue;
                marked[i] = true;
                ans = Math.min(ans, permute(i, sz - 1, cc + (sz == r ? 0 : cost[R[prev]][R[i]])));
                marked[i] = false;
            }

            return ans;
        }

    }

    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
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

