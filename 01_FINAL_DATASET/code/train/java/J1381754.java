import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node ns[] = new Node[n];
        for (int i = 0; i < n; i++) {
            ns[i] = new Node(i, sc.nextLong(), sc.nextLong());
        }

        ArrayList<Edge> es[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            es[i] = new ArrayList<>();
        }
        Arrays.sort(ns, (n1, n2) -> Long.compare(n1.x, n2.x));
        createEdge(es, ns, n);
        Arrays.sort(ns, (n1, n2) -> Long.compare(n1.y, n2.y));
        createEdge(es, ns, n);

        boolean used[] = new boolean[n];
        long res = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) ->
                Long.compare(e1.cost, e2.cost));
        used[0] = true;
        queue.addAll(es[0]);

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            if (used[e.to]) continue;
            used[e.to] = true;
            res += e.cost;

            queue.addAll(es[e.to]);
        }
        System.out.println(res);
    }

    static long dist(int i, int j, Node[] ns) {
        return Math.min(Math.abs(ns[i].x - ns[j].x), Math.abs(ns[i].y - ns[j].y));
    }

    static void createEdge(ArrayList<Edge> es[], Node[] ns, int n) {
        for (int i = 1; i < n; i++) {
            long dist1 = dist(i, i-1, ns);
            int prevID = ns[i-1].id;
            int ID = ns[i].id;
            Edge e1 = new Edge(prevID, ID, dist1);
            Edge e2 = new Edge(ID, prevID, dist1);
            es[prevID].add(e1);
            es[ID].add(e2);
        }

    }

    static class Node {
        int id;
        long x, y;
        Node(int id, long x, long y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

    }

    static class Edge {
        int from, to;
        long cost;
        Edge(int f, int t, long c) {
            from = f;
            to = t;
            cost = c;
        }

    }


}
