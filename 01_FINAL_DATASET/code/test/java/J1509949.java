import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	final long MODULO = 1_000_000_000 + 7;

	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n - 1];
		int[] b = new int[n - 1];
		int[] c = new int[n - 1];
		HLDecomposition hl = new HLDecomposition(n);
		for (int i = 0; i < n - 1; ++i) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			c[i] = sc.nextInt();
			--a[i];
			--b[i];
			hl.ae(a[i], b[i], c[i]);
		}
		int Q = sc.nextInt();
		int K = sc.nextInt();
		--K;
		int[] x = new int[Q];
		int[] y = new int[Q];
		hl.root = K;
		hl.pre();
		for (int i = 0; i < Q; ++i) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			--x[i];
			--y[i];
			System.out.println(hl.depth2[x[i]] + hl.depth2[y[i]]);
		}
	}

	class HLDecomposition {
		int root = 0;
		int n;
		int[] depth;
		long[] depth2;
		int[] head;
		int[] heavy;
		int[] parent;
		int[] sz;
		ArrayList<Edge>[] g;
		int[] id;

		class Edge {
			int src, dst;
			long cost;

			public Edge(int src_, int dst_, int cost_) {
				src = src_;
				dst = dst_;
				cost = cost_;
			}
		}

		@SuppressWarnings("unchecked")
		public HLDecomposition(int n) {
			this.n = n;
			depth = new int[n];
			depth2 = new long[n];
			head = new int[n];
			heavy = new int[n];
			parent = new int[n];
			id = new int[n];
			sz = new int[n];
			g = new ArrayList[n];
			for (int i = 0; i < n; ++i) {
				g[i] = new ArrayList<>();
			}
			Arrays.fill(head, -1);
			Arrays.fill(id, -1);
			Arrays.fill(parent, -1);
		}

		void ae(int a, int b, int c) {
			g[a].add(new Edge(a, b, c));
			g[b].add(new Edge(b, a, c));
		}

		void pre() {
			dfs(root, -1);
			bfs();
		}

		void bfs() {
			ArrayDeque<Integer> pend = new ArrayDeque<>();
			int gen = 0;
			pend.add(0);
			while (!pend.isEmpty()) {
				int v = pend.pollFirst();
				int top = v;
				for (; v != -1; v = heavy[v]) {
					id[v] = gen++;
					head[v] = top;
					for (Edge e : g[v]) {
						int d = e.dst;
						if (d == parent[v] || d == heavy[v]) {
							continue;
						}
						pend.add(d);
					}
				}
			}
		}

		int lca(int u, int v) {
			if (head[u] != head[v]) {
				if (depth[head[u]] < depth[head[v]]) {
					int tmp = u;
					u = v;
					v = tmp;
				}
				return lca(parent[head[u]], v);
			} else {
				if (depth[u] > depth[v]) {
					int tmp = u;
					u = v;
					v = tmp;
				}
				return u;
			}
		}

		int dfs(int c, int p) {
			parent[c] = p;
			int s = 1;
			int to = -1;
			for (Edge e : g[c]) {
				int d = e.dst;
				if (d == p)
					continue;
				depth[d] = depth[c] + 1;
				depth2[d] = depth2[c] + e.cost;
				s += dfs(d, c);
				if (to == -1 || sz[d] > sz[to]) {
					to = d;
				}
			}
			sz[c] = s;
			heavy[c] = to;
			return s;
		}

	}

	static void tr(Object... objects) {
		System.out.println(Arrays.deepToString(objects));
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
