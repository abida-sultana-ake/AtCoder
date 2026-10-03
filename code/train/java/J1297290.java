import java.io.*;
import java.util.*;

public class Main {
    private FastScanner in;
    private PrintWriter out;

    private void solve() {
        int h = in.nextInt();
        int w = in.nextInt();
        Flow f = new Flow(h * w * 2 + 1 + h + w + 1);
        char[][] s = new char[h][];
        for (int i = 0; i < h; i++) {
            s[i] = in.next().toCharArray();
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int id1 = i * w + j;
                int id2 = id1 + h * w;
                if (s[i][j] == 'S') {
                    f.addEdge(h * w * 2, id1, Integer.MAX_VALUE);
                    f.addEdge(id1, id2, Integer.MAX_VALUE);
                }
                if (s[i][j] == 'T') {
                    f.addEdge(id2, f.n - 1, Integer.MAX_VALUE);
                    f.addEdge(id1, id2, Integer.MAX_VALUE);
                }
                if (s[i][j] == 'o') {
                    f.addEdge(id1, id2, 1);
                }
                if (s[i][j] != '.') {
                    f.addEdge(h * w * 2 + 1 + i, id1, Integer.MAX_VALUE);
                    f.addEdge(h * w * 2 + 1 + h + j, id1, Integer.MAX_VALUE);
                    f.addEdge(id2, h * w * 2 + 1 + i, Integer.MAX_VALUE);
                    f.addEdge(id2, h * w * 2 + 1 + h + j, Integer.MAX_VALUE);
                }
            }
        }
        long v = f.flow(h * w * 2);
        out.println(v >= Integer.MAX_VALUE ? -1 : v);
    }

    class Edge {
        int fr, to;
        long flow, cap;
        Edge rev;

        Edge(int fr, int to, long cap) {
            this.fr = fr;
            this.to = to;
            this.cap = cap;
        }
    }

    class Flow {
        int n;
        ArrayList<Edge>[] g;

        Flow(int n) {
            this.n = n;
            g = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            q = new int[n];
            h = new int[n];
            cur = new int[n];
        }

        void addEdge(int fr, int to, long cap) {
            Edge e1 = new Edge(fr, to, cap);
            Edge e2 = new Edge(to, fr, 0);
            e1.rev = e2;
            e2.rev = e1;
            g[fr].add(e1);
            g[to].add(e2);
        }

        int[] h;
        int[] cur;
        int[] q;

        boolean bfs(int from) {
            int qIt = 0, qSz = 0;
            q[qSz++] = from;
            Arrays.fill(h, -1);
            h[from] = 0;
            while (qIt < qSz) {
                int v = q[qIt++];
                for (Edge e : g[v]) {
                    if (e.flow == e.cap)
                        continue;
                    if (h[e.to] == -1) {
                        h[e.to] = h[e.fr] + 1;
                        q[qSz++] = e.to;
                    }
                }
            }
            return h[n - 1] != -1;
        }

        long dfs(int v, long flow) {
            if (v == n - 1 || flow == 0)
                return flow;
            for (; cur[v] < g[v].size(); cur[v]++) {
                Edge e = g[v].get(cur[v]);
                if (h[e.to] != h[e.fr] + 1 || e.flow == e.cap)
                    continue;
                long add = dfs(e.to, Math.min(flow, e.cap - e.flow));
                if (add == 0)
                    continue;
                e.flow += add;
                e.rev.flow -= add;
                return add;
            }
            return 0;
        }

        long flow(int from) {
            long res = 0;
            while (bfs(from)) {
                Arrays.fill(cur, 0);
                while (true) {
                    long add = dfs(from, Long.MAX_VALUE);
                    if (add == 0)
                        break;
                    res += add;
                }
            }
            return res;
        }
    }

    private void run() {
        try {
            in = new FastScanner(new File("Main.in"));
            out = new PrintWriter(new File("Main.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void runIO() {
        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    private class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        new Main().runIO();
    }
}