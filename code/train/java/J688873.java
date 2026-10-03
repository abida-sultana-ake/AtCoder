import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;
import java.io.*;

public class Main {

	static final long MOD = (long)(1e9+7);
	void solve() {
		int n = sc.nextInt();
		V[] vs = new V[n];
		for (int i = 0; i < n; i++) vs[i] = new V(i);
		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			vs[a].add(vs[b]);
			vs[b].add(vs[a]);
		}
		long ans = (dp(vs[0], null, 0) + dp(vs[0], null, 1)) % MOD;
		out.println(ans);
	}
	
	long dp(V v, V prev, int color) {
		if (v.memo[color] != -1) return v.memo[color];
		long res = 1;
		for (V child : v) if (child != prev) {
			long c = 0;
			if (color == 0) c = dp(child, v, 0) + dp(child, v, 1);
			if (color == 1) c = dp(child, v, 0);
			res = (res * (c % MOD) ) % MOD;
		}
		v.memo[color] = res;
		return res;
	}

	class V extends ArrayList<V> {
		int id;
		long[] memo = new long[] { -1, -1 };
		public V(int id) { this.id = id; }
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