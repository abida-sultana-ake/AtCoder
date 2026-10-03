import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Printer pr = new Printer(System.out);

		int n = sc.nextInt();
		int m = sc.nextInt();

		List<Tri> aby = new ArrayList<>(m);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int y = sc.nextInt();
			aby.add(new Tri(a, b, y));
		}
		Collections.sort(aby);

		int q = sc.nextInt();
		List<Tri> vw = new ArrayList<>(q);
		for (int i = 0; i < q; i++) {
			int v = sc.nextInt() - 1;
			int w = sc.nextInt();
			vw.add(new Tri(i, v, w));
		}
		Collections.sort(vw);

		Map<Integer, Integer> ret = new TreeMap<>();

		UnionFind uf = new UnionFind(n);

		int j = 0;
		for (Tri e : vw) {
			for (; j < m && e.y < aby.get(j).y; j++) {
				uf.unite(aby.get(j).a, aby.get(j).b);
			}

			ret.put(e.a, uf.count(e.b));
		}

		for (int e : ret.values()) {
			pr.println(e);
		}

		pr.close();
		sc.close();
	}

	private static class Tri implements Comparable<Tri> {
		int a;
		int b;
		int y;

		Tri(int a, int b, int y) {
			this.a = a;
			this.b = b;
			this.y = y;
		}

		@Override
		public int compareTo(Tri o) {
			return Integer.compare(o.y, this.y);
		}
	}

	@SuppressWarnings("unused")
	private static class UnionFind {
		int n;
		// cnt : 異なる集合の数
		int cnt;
		// parent[x] : 0～n-1 の場合、要素xのroot要素
		//           : -1～-n の場合、自分自身がroot要素、
		//                            -parent[x]でxを含む集合の要素数
		int[] parent;

		UnionFind(int n) {
			this.n = n;
			cnt = n;
			parent = new int[n];
			Arrays.fill(parent, -1);
		}

		// xのrootを求める
		int find(int x) {
			if (parent[x] < 0) {
				return x;
			} else {
				return parent[x] = find(parent[x]);
			}
		}

		// xとyが同じ集合に属するのか
		boolean same(int x, int y) {
			return find(x) == find(y);
		}

		// xとyの属する集合を併合する
		void unite(int x, int y) {
			x = find(x);
			y = find(y);
			if (x == y) {
				return;
			}

			cnt--;
			// 要素数が大きい集合をrootにする(Quick Find Weighted?)
			if (parent[x] > parent[y]) {
				parent[y] += parent[x];
				parent[x] = y;
			} else {
				parent[x] += parent[y];
				parent[y] = x;
			}

			return;
		}

		// 要素xを含む集合の要素数
		int count(int x) {
			return -parent[find(x)];
		}

		// 異なる集合の数
		int count() {
			return cnt;
		}
	}

	@SuppressWarnings("unused")
	private static class Scanner {
		BufferedReader br;
		Iterator<String> it;

		Scanner (InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		String next() throws RuntimeException  {
			try {
				if (it == null || !it.hasNext()) {
					it = Arrays.asList(br.readLine().split(" ")).iterator();
				}
				return it.next();
			} catch (IOException e) {
				throw new IllegalStateException();
			}
		}

		int nextInt() throws RuntimeException {
			return Integer.parseInt(next());
		}

		long nextLong() throws RuntimeException {
			return Long.parseLong(next());
		}

		float nextFloat() throws RuntimeException {
			return Float.parseFloat(next());
		}

		double nextDouble() throws RuntimeException {
			return Double.parseDouble(next());
		}

		void close() {
			try {
				br.close();
			} catch (IOException e) {
//				throw new IllegalStateException();
			}
		}
	}

	private static class Printer extends PrintWriter {
		Printer(PrintStream out) {
			super(out);
		}
	}
}
