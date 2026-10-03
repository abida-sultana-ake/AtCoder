import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    void solve() throws IOException {
        int xs = ni();
        int ys = ni();
        int xt = ni();
        int yt = ni();

        int n = ni();

        int[] x = new int[n];
        int[] y = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = ni();
            y[i] = ni();
            r[i] = ni();
        }

        ArrayList<ArrayList<Edge>> G = new ArrayList<>();
        for (int i = 0; i < n + 2; i++) {
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double t = d(x[i], y[i], x[j], y[j]);
                if (t > r[i] + r[j]) {
                    G.get(i).add(new Edge(j, t - r[i] - r[j]));
                    G.get(j).add(new Edge(i, t - r[i] - r[j]));
                } else {
                    G.get(i).add(new Edge(j, 0));
                    G.get(j).add(new Edge(i, 0));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            double t = d(xs, ys, x[i], y[i]);
            if (t > r[i]) {
                G.get(n).add(new Edge(i, t - r[i]));
            } else {
                G.get(n).add(new Edge(i, 0));
            }
        }

        for (int i = 0; i < n; i++) {
            double t = d(xt, yt, x[i], y[i]);
            if (t > r[i]) {
                G.get(i).add(new Edge(n + 1, t - r[i]));
            } else {
                G.get(i).add(new Edge(n + 1, 0));
            }
        }

        G.get(n).add(new Edge(n + 1, d(xs, ys, xt, yt)));

        Dijkstra dijk = new Dijkstra(G);
        double[] dist = dijk.getDist(n);

        out.println(dist[n + 1]);
    }

    double d(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }


    class Dijkstra {
        int n;
        ArrayList<ArrayList<Edge>> G;

        int INF = Integer.MAX_VALUE / 3;

        public Dijkstra(ArrayList<ArrayList<Edge>> G) {
            n = G.size();
            this.G = G;
        }

        double[] getDist(int s) {
            PriorityQueue<Pair> Q = new PriorityQueue<>();
            Q.add(new Pair(s, 0));
            double[] dist = new double[n];
            Arrays.fill(dist, INF);
            boolean[] used = new boolean[n];
            while (!Q.isEmpty()) {
                Pair p = Q.poll();
                if (used[p.x]) continue;
                used[p.x] = true;
                dist[p.x] = p.y;

                for (Edge e : G.get(p.x)) {
                    Q.add(new Pair(e.to, p.y + e.cost));
                }
            }
            return dist;
        }

        public class Pair implements Comparable<Pair> {
            int x;
            double y;

            public Pair(int x, double y) {
                this.x = x;
                this.y = y;
            }

            public int compareTo(Pair p) {
                return Double.compare(y, p.y);
            }
        }
    }

    class Edge implements Comparable<Edge> {
        int to;
        double cost;

        public Edge(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge edge) {
            return Double.compare(cost, edge.cost);
        }
    }

    String ns() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine(), " ");
        }
        return tok.nextToken();
    }

    int ni() throws IOException {
        return Integer.parseInt(ns());
    }

    long nl() throws IOException {
        return Long.parseLong(ns());
    }

    double nd() throws IOException {
        return Double.parseDouble(ns());
    }

    String[] nsa(int n) throws IOException {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = ns();
        }
        return res;
    }

    int[] nia(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ni();
        }
        return res;
    }

    long[] nla(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = nl();
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        tok = new StringTokenizer("");
        Main main = new Main();
        main.solve();
        out.close();
    }
}