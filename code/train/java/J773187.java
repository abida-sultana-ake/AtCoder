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
				uf.union(aby.get(j).a, aby.get(j).b);
			}

//			int cnt = 0;
//			for (int k = 0; k < n; k++) {
//				if (uf.same(e.b, k)) {
//					cnt++;
//				}
//			}
			ret.put(e.a, uf.cnt(e.b));
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
		int[] parent;
		int[] rank;
		int[] cnt;

		UnionFind(int n) {
			parent = new int[n];
			rank = new int[n];
			cnt = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				rank[i] = 0;
				cnt[i] = 1;
			}

		}

		int find(int x) {
			if (parent[x] == x) {
				return x;
			} else {
				return parent[x] = find(parent[x]);
			}
		}

		boolean same(int x, int y) {
			return find(x) == find(y);
		}

		void union(int x, int y) {
			x = find(x);
			y = find(y);
			if (x != y) {
				if (rank[x] > rank[y]) {
					parent[y] = x;
					cnt[x] += cnt[y];
				} else {
					parent[x] = y;
					cnt[y] += cnt[x];
					if (rank[x] == rank[y]) {
						rank[y]++;
					}
				}
			}

			return;
		}

		int cnt(int x) {
			return cnt[find(x)];
		}

		// 異なる集合の数
		int count() {
			int ret = 0;
			for (int i = 0; i < parent.length; i++) {
				if (find(i) == i) {
					ret++;
				}
			}

			return ret;
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
