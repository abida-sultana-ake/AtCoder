import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class Main {
	int n, m, t;
	long[] A;
	int INF = Integer.MAX_VALUE / 3;
 
	class Edge {
		int to;
		int cost;
 
		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
 
	class D implements Comparable<D> {
		int k;
		int len;
 
		D(int k, int len) {
			this.k = k;
			this.len = len;
		}
 
		@Override
		public int compareTo(D o) {
			if (this.len != o.len) {
				return this.len - o.len;
			}
			return this.k - o.k;
		}
	}
 
	void dijkstra(int s, List<Edge>[] edge, int[] res) {
		PriorityQueue<D> queue = new PriorityQueue<D>();
		queue.offer(new D(s, 0));
		while (!queue.isEmpty()) {
			D d = queue.poll();
			int cur = d.k;
			int len = d.len;
 
			if (res[cur] != INF) {
				continue;
			}
			res[cur] = len;
 
			for (Edge e : edge[cur]) {
				int to = e.to;
				int cost = e.cost;
				queue.offer(new D(to, len + cost));
			}
		}
	}
 
	void run() {
		Scanner sc = new Scanner(System.in);
 
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		A = new long[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		List<Edge>[] e = new LinkedList[n];
		List<Edge>[] rev = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			e[i] = new LinkedList<Edge>();
			rev[i] = new LinkedList<Edge>();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			e[a].add(new Edge(b, c));
			rev[b].add(new Edge(a, c));
		}
 
		int[] min = new int[n];
		int[] revMin = new int[n];
		Arrays.fill(min, INF);
		Arrays.fill(revMin, INF);
		dijkstra(0, e, min);
		dijkstra(0, rev, revMin);
 
		long max = 0;
		for (int i = 0; i < n; i++) {
			if (min[i] == INF || revMin[i] == INF) {
				continue;
			}
			long rem = t - min[i] - revMin[i];
			if (0 < rem) {
				max = Math.max(max, A[i] * rem);
			}
		}
		System.out.println(max);
	}
 
	public static void main(String[] args) {
		new Main().run();
	}
}