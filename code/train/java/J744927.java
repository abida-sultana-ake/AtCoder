import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;

import java.io.*;

public class Main {

	static final long MOD = (long)(1e9+7);
	void solve() {
		int n = sc.nextInt();
		Range[] ranges = new Range[n];
		for (int i = 0; i < n; i++) {
			ranges[i] = new Range(i, sc.nextInt(), sc.nextInt());
		}
		boolean[] isCovered = new boolean[n];
		int[] v = new int[2 * n];
		for (int i = 0; i < n; i++) { v[2*i] = ranges[i].a; v[2*i+1] = ranges[i].b; }
		v = normalize(v);
		for (int i = 0; i < n; i++) {
			ranges[i].a = v[i*2] + 1;
			ranges[i].b = v[i*2+1] + 1;
		}
		Arrays.sort(ranges, new Comparator<Range>(){
			@Override
			public int compare(Range a, Range b) {
				if (a.a != b.a) return a.a < b.a ? -1 : 1;
				if (a.b != b.b) return a.b > b.b ? -1 : 1;
				return Integer.compare(a.id, b.id);
			}
		});
		int ans = 0;
		BITMAX bitmax = new BITMAX(2 * n + 1);
		for (Range range : ranges) {
//			tr(range);
			int count = bitmax.get(range.b - 1);
			ans = Math.max(ans, count + 1);
			bitmax.update(range.b, count + 1);
		}
		out.println(ans);
	}
	
	public class BITMAX {
		int n;
		int[] vs;
		public BITMAX(int n) {
			this.n = n;
			vs = new int[n+1];
		}

		/** [idx, ∞] の範囲の最大値を val で更新しようと試みる */
		public void update(int idx, int val) {
			for (int x = idx + 1; x <= n; x += x & -x) vs[x] = Math.max(vs[x], val);
		}

		/** [idx, ∞] の範囲の最大値を取得 */
		public int get(int idx) {
			int max = 0;
			for (int x = idx + 1; x > 0; x -= x & -x) max = Math.max(max, vs[x]);
			return max;
		}
		
	}

	
	static class Range {
		int id;
		int a, b;
		Range(int id, int a, int b) {
			this.id = id;
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
			return "[" + a + ", " + b + "]";
		}
	}

	public static int[] normalize(int[] v) {
		int[] res = new int[v.length];
		int[][] t = new int[v.length][2];
		for (int i = 0; i < v.length; i++) {
			t[i][0] = v[i];
			t[i][1] = i;
		}
		Arrays.sort(t, 0, t.length, new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				if (a[0] != b[0]) return a[0] < b[0] ? -1 : 1;
				return 0;
			}
		});

		int r = 0;
		for (int i = 0; i < v.length; i++) {
			r += (i > 0 && t[i - 1][0] != t[i][0]) ? 1 : 0;
			res[(int)t[i][1]] = r;
		}
		return res;
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