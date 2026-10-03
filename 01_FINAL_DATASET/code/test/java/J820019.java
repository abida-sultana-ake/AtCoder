import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N, M, T;
	static int[] A;
	static ArrayList<ArrayList<Edge>> edge, redge;
	static final int INF = (int) 1e9;
	static ArrayList<Edge> buf;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		N = cin.nextInt();
		M = cin.nextInt();
		T = cin.nextInt();
		A = new int[N];
		edge = new ArrayList<>(N);
		redge = new ArrayList<>(N);
		long[] go = new long[N];
		long[] ret = new long[N];
		for (int i = 0; i < N; i++) {
			A[i] = cin.nextInt();
			go[i] = INF;
			ret[i] = INF;
			edge.add(i, new ArrayList<Edge>());
			redge.add(i, new ArrayList<Edge>());
		}
		for (int i = 0; i < M; i++) {
			int a, b, c;
			a = cin.nextInt() - 1;
			b = cin.nextInt() - 1;
			c = cin.nextInt();
			buf = edge.get(a);
			buf.add(new Edge(b, c));
			edge.set(a, buf);
			buf = redge.get(b);
			buf.add(new Edge(a, c));
			redge.set(b, buf);
		}
		dijkstra(edge, go);
		dijkstra(redge, ret);
		long ans = 0;
		for (int i = 0; i < N; i++) {
			long sum = (T - (go[i] + ret[i])) * A[i];
			if (sum >= 0)
				ans = Math.max(ans, sum);
			//System.out.println(ans);
		}
		System.out.println(ans);
		cin.close();
	}

	static void dijkstra(ArrayList<ArrayList<Edge>> e, long[] res) {
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		q.add(new Edge(0, 0));
		while (!q.isEmpty()) {
			long costs = q.element().getCost();
			int now = q.element().getPoint();
			q.poll();
			if (res[now] == INF)
				res[now] = costs;
			else
				continue;
			buf = e.get(now);
			for (Edge next : buf) {
				q.add(new Edge(next.getPoint(), next.getCost() + costs));
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		long cost;
		int point;

		Edge(int next, long cost) {
			this.cost = cost;
			this.point = next;
		}

		public int compareTo(Edge o) {
			return (int) (this.cost - o.cost);
		}

		long getCost() {
			return this.cost;
		}

		int getPoint() {
			return this.point;
		}
	}
}
