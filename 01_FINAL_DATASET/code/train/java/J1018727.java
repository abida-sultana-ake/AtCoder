import static java.util.Arrays.deepToString;
import static java.util.Arrays.fill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	void solve() {
		int N = sc.nextInt();
		int K = sc.nextInt();
		int L = sc.nextInt();
		UnionFind A = new UnionFind(N);
		UnionFind B = new UnionFind(N);
		
		for (int i = 0; i < K; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			A.link(x, y);
		}
		for (int i = 0; i < L; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			B.link(x, y);
		}
		
		Map<Long, Integer> count = new HashMap<Long, Integer>();
		for (int i = 0; i < N; i++) {
			int p1 = A.root(i);
			int p2 = B.root(i);
			long key = ((long)p1 << 20) + p2;
			count.put(key, 1 + count.getOrDefault(key, 0));
		}
		
		for (int i = 0; i < N; i++) {
			int p1 = A.root(i);
			int p2 = B.root(i);
			long key = ((long)p1 << 20) + p2;
			if (i > 0) out.print(" ");
			out.print(count.get(key));
		}
		out.println();
		
	}

	public class UnionFind {
		int[] data;

		public UnionFind(int n) {
			data = new int[n];
			fill(data, -1);
		}

		boolean link(int x, int y) {
			x = root(x);
			y = root(y);
			if (x != y) {
				if (data[y] < data[x]) {
					data[y] += data[x];
					data[x] = y;
				} else {
					data[x] += data[y];
					data[y] = x;
				}
			}
			return x != y;
		}
		int root(int x) {
			return data[x] < 0 ? x : (data[x] = root(data[x]));
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