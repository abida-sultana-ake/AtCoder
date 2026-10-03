import static java.lang.Math.*;
import static java.util.Arrays.*;

import java.util.*;
import java.io.*;

public class Main {

	void solve() {
		int N = sc.nextInt();
		int M = sc.nextInt();
		final int INF = 1<<20;
		int[][] g = new int[N][N];
		for (int i = 0; i < N; i++) Arrays.fill(g[i], INF);
		for (int i = 0; i < N; i++) g[i][i] = 0;
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			g[a][b] = g[b][a] = c;
		}
		for (int k = 0; k < N; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
		int ans = INF;
		for (int i = 0; i < N; i++) {
			int cur = 0;
			for (int j = 0; j < N; j++)
				cur = Math.max(cur, g[i][j]);
			ans = Math.min(ans, cur);
		}
		out.println(ans);
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