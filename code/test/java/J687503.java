import static java.lang.Math.*;
import static java.util.Arrays.*;

import java.util.*;
import java.io.*;

public class Main {
	
	int[] a;
	
	void solve() {
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		a = sc.nextIntArray(N);
		
		V[] g = new V[N]; for (int i = 0; i < N; i++) g[i] = new V();
		V[] rev = new V[N]; for (int i = 0; i < N; i++) rev[i] = new V();
		for (int mi = 0; mi < M; mi++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			int w = sc.nextInt();
			g[from].add(g[to], w);
			rev[to].add(rev[from], w);
		}
		dijk(g, g[0]);
		dijk(rev, rev[0]);

		long ans = 0;
		for (int i = 0; i < N; i++) {
			long cur = 0;
			int t = g[i].dist + rev[i].dist;
			int res = Math.max(0, T - t);
			cur += (long)res * a[i];
			ans = Math.max(ans, cur);
		}
		out.println(ans);
	}

	void dijk(V[] vs, V start) {
		final int INF = 1001001001;
		for (int i = 0; i < vs.length; i++) vs[i].dist = INF;
		PriorityQueue<V> pq = new PriorityQueue<>();
		start.dist = 0;
		pq.add(start);
		while (!pq.isEmpty()) {
			V cur = pq.poll();
			for (E e : cur.es) {
				int nw = cur.dist + e.w;
				if (e.to.dist > nw) {
					e.to.dist = nw;
					pq.add(e.to);
				}
			}
		}
	}
	class V implements Comparable<V> {
		ArrayList<E> es = new ArrayList<E>();
		int dist;
		void add(V to, int w) {
			this.es.add(new E(to, w));
		}
		@Override
		public int compareTo(V o) {
			return dist - o.dist;
		}
	}
	class E {
		V to;
		int w;
		E(V to, int w) {
			this.to = to;
			this.w = w;
		}

	}
	static void tr(Object... os) { System.err.println(deepToString(os)); }
	static void tr(int[][] as) { for (int[] a : as) tr(a); }

	void print(int[] a) {
		out.print(a[0]);
		for (int i = 1; i < a.length; i++) out.print(" " + a[i]);
		out.println();
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

	MyScanner sc = null;
	PrintWriter out = null;
	public void run() throws Exception {
		sc = new MyScanner(System.in);
		out = new PrintWriter(System.out);
		for (;sc.hasNext();) {
			solve();
			out.flush();
		}
		out.close();
	}

	class MyScanner {
		String line;
		BufferedReader reader;
		StringTokenizer tokenizer;

		public MyScanner(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}
		public void eat() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					line = reader.readLine();
					if (line == null) {
						tokenizer = null;
						return;
					}
					tokenizer = new StringTokenizer(line);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		public String next() {
			eat();
			return tokenizer.nextToken();
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		public boolean hasNext() {
			eat();
			return (tokenizer != null && tokenizer.hasMoreElements());
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
	}
}