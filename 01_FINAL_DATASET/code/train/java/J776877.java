import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Dijkstra dj = new Dijkstra(n, 2 * n - 3);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                int c = Math.abs(a[i] - a[i - 1]);
                dj.set(i, i - 1, c);
                dj.set(i - 1, i, c);
            } if (i > 1) {
                int c = Math.abs(a[i] - a[i - 2]);
                dj.set(i, i - 2, c);
                dj.set(i - 2, i, c);
            }
        }
        dj.run(0);
        System.out.println(dj.d[n - 1]);
    }

    static class Dijkstra {
        int vn, en;
        int[] d;

        ArrayList<Edge>[] edges;

        @SuppressWarnings("unchecked")
        Dijkstra(int vn, int en) {
            this.vn = vn;
            this.en = en;
            edges = new ArrayList[vn];
            for (int i = 0; i < vn; i++) {
                edges[i] = new ArrayList<>();
            }
        }

        void run(int start) {
            d = new int[vn];
            Arrays.fill(d, Integer.MAX_VALUE);
            d[start] = 0;

            Queue<Edge> queue = new PriorityQueue<>();
            queue.add(new Edge(start, 0));

            while (!queue.isEmpty()) {
                Edge e1 = queue.poll();
                if (d[e1.target] < e1.cost) {
                    continue;
                }

                for (Edge e2 : edges[e1.target]) {
                    if (d[e2.target] > d[e1.target] + e2.cost) {
                        d[e2.target] = d[e1.target] + e2.cost;
                        queue.add(new Edge(e2.target, d[e2.target]));
                    }
                }
            }
        }

        void set(int from, int to, int cost) {
            this.edges[from].add(new Edge(to, cost));
            this.edges[to].add(new Edge(from, cost));
        }
    }

    static class Edge implements Comparable<Edge> {
        int target;
        int cost;

        public Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}