import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {
	InputStream is;

	int __t__ = 1;
	int __f__ = 0;
	int __FILE_DEBUG_FLAG__ = __f__;
	String __DEBUG_FILE_NAME__ = "src/D1";

	FastScanner in;
	PrintWriter out;
	
	class Edge implements Comparable<Edge> {
		int a;
		int b;
		int y;

		Edge(int a, int b, int y) {
			this.a = a;
			this.b = b;
			this.y = y;
		}

		public int compareTo(Edge s) {
			return s.y - y;
		}

		public String toString() {
			return "(" + a + ", " + b + ", " + y + ")";
		}
	}
	
	class Query implements Comparable<Query> {
		int id;
		int v;
		int w;

		Query(int id, int v, int w) {
			this.id = id;
			this.v = v;
			this.w = w;
		}

		public int compareTo(Query s) {
			return s.w - w;
		}

		public String toString() {
			return "(" + id + ", " + v + ", " + w + ")";
		}
	}

	class UnionFindTree {
		int[] parent;
		int[] cnt;
		
		public UnionFindTree(int n) {
			parent = new int[n];
			cnt = new int[n];
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
				cnt[i] = 1;
			}
		}
		
		public int size(int x) {
			return cnt[x];
		}
		
		public int find(int x) {
			if (parent[x] == x) return x;
			return parent[x] = find(parent[x]);
		}
		
		public boolean same(int x, int y) {
			return find(x) == find(y);
		}
		
		public void unite(int x, int y) {
			int xx = find(x), yy = find(y);
			if (xx == yy) return;
			parent[xx] = yy;
			cnt[yy] += cnt[xx];
		}

		public String toString() {
			return Arrays.toString(parent);
		}
	}
	
	void solve() {
		int n = in.nextInt(), m = in.nextInt();
		Edge[] es = new Edge[m];
		for (int i = 0; i < m; i++) {
			int a = in.nextInt() - 1, b = in.nextInt() - 1;
			int y = in.nextInt();
			es[i] = new Edge(a, b, y);
		}
		int Q = in.nextInt();
		Query[] qs = new Query[Q];
		for (int i = 0; i < Q; i++) {
			int v = in.nextInt() - 1, w = in.nextInt();
			qs[i] = new Query(i, v, w);
		}
		Arrays.sort(es);
		Arrays.sort(qs);
		
		UnionFindTree uft = new UnionFindTree(n);
				
		int[] res = new int[Q];
		int eidx = 0, qidx = 0;
		while (eidx < m || qidx < Q) {
			if (eidx == m || (qidx < Q && es[eidx].y <= qs[qidx].w)) {
				// query processing
				res[qs[qidx].id] = uft.size(uft.find(qs[qidx].v));
				qidx++;
			} else {
				// edge processing
				uft.unite(es[eidx].a, es[eidx].b);
				eidx++;
			}
		}
		for (int i = 0; i < Q; i++) {
			out.println(res[i]);
		}
		out.close();
	}

	public void run() {
		if (__FILE_DEBUG_FLAG__ == __t__) {
			try {
				is = new FileInputStream(__DEBUG_FILE_NAME__);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("FILE_INPUT!");
		} else {
			is = System.in;
		}
		in = new FastScanner(is);
		out = new PrintWriter(System.out);

		solve();
	}

	public static void main(String[] args) {
		new Main().run();
	}

	public void mapDebug(int[][] a) {
		System.out.println("--------map display---------");

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%3d ", a[i][j]);
			}
			System.out.println();
		}

		System.out.println("----------------------------");
		System.out.println();
	}

	public void debug(Object... obj) {
		System.out.println(Arrays.deepToString(obj));
	}

	class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
			// stream = new FileInputStream(new File("dec.in"));

		}

		int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] nextIntArray(int n) {
			int[] array = new int[n];
			for (int i = 0; i < n; i++)
				array[i] = nextInt();

			return array;
		}

		int[][] nextIntMap(int n, int m) {
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextIntArray(m);
			}
			return map;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		long[] nextLongArray(int n) {
			long[] array = new long[n];
			for (int i = 0; i < n; i++)
				array[i] = nextLong();

			return array;
		}

		long[][] nextLongMap(int n, int m) {
			long[][] map = new long[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextLongArray(m);
			}
			return map;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		double[] nextDoubleArray(int n) {
			double[] array = new double[n];
			for (int i = 0; i < n; i++)
				array[i] = nextDouble();

			return array;
		}

		double[][] nextDoubleMap(int n, int m) {
			double[][] map = new double[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextDoubleArray(m);
			}
			return map;
		}

		String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		String[] nextStringArray(int n) {
			String[] array = new String[n];
			for (int i = 0; i < n; i++)
				array[i] = next();

			return array;
		} 
		String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}
}
