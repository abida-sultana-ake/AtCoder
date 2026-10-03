import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;

import java.io.*;

public class Main {

	void solve() {
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		V[] vs = new V[N];
		for (int i = 0; i < N; i++) vs[i] = new V(i);
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			vs[a].add(vs[b], c);
		}
		long INF = 1L << 58;
		for (V v : vs) v.score = -INF;
		vs[0].score = 0;
		
		for (int step = 0; step < 3 * N + 10; step++) {
			for (V v : vs) {
				for (E e : v.es) {
					if (e.to.score < (v.score + e.w)) {
						e.to.score = v.score + e.w;
						if (step >= N) {
							e.to.score = INF;
						}
					}
				}
			}
		}
		
		long ans = vs[N-1].score;
		if (ans >= INF / 2)
			out.println("inf");
		else
			out.println(ans);
	}
	
	class V {
		ArrayList<E> es = new ArrayList<E>();
		int id;
		long score = 0;
		public V(int id) { this.id = id; }
		void add(V to, int w) {
			this.es.add(new E(to, w));
		}
	}
	class E {
		V to;
		long w;
		E(V to, long w) {
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