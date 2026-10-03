import java.util.Arrays;

public class Main {
	MyScanner sc = new MyScanner();
	int N, M, w, v;

	void run() {
		N = sc.nextInt();
		M = sc.nextInt();
		UnionFind uf = new UnionFind();
		uf.init(N);
		Bridge[] B = new Bridge[M];
		for (int i = 0; i < M; i++) B[i] = new Bridge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
		int Q = sc.nextInt();
		Info[] I = new Info[Q];
		for (int i = 0; i < Q; i++) I[i] = new Info(i, sc.nextInt() - 1, sc.nextInt());
		Arrays.sort(B);
		Arrays.sort(I);

		int[] ans = new int[Q];
		int bCnt = 0;
		for (int i = 0; i < Q; i++) {
			while (bCnt < M && B[bCnt].y > I[i].y) {
				uf.union(B[bCnt].a, B[bCnt].b);
				bCnt++;
			}
			ans[I[i].id] = uf.getGroupSize(I[i].v);
		}
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < Q; i++) s.append(ans[i] + "\n");
		System.out.print(s);
	}

	class Bridge implements Comparable<Bridge> {

		int a, b, y;

		public Bridge(int a, int b, int y) {
			super();
			this.a = a;
			this.b = b;
			this.y = y;
		}

		@Override
		public int compareTo(Bridge arg0) {
			return arg0.y - this.y;
		}
	}

	class Info implements Comparable<Info> {

		int id, v, y;

		public Info(int id, int v, int y) {
			super();
			this.id = id;
			this.v = v;
			this.y = y;
		}

		@Override
		public int compareTo(Info arg0) {
			return arg0.y - this.y;
		}
	}

	public class UnionFind {

		int[] par;
		int[] rank;
		int groupCnt;

		void init(int n) {
			groupCnt = n;
			par = new int[n];
			rank = new int[n];
			Arrays.fill(par, -1);
		}

		void union(int x, int y) {
			x = find(x);
			y = find(y);
			if (x == y) {
				return;
			}
			groupCnt--;
			if (rank[x] < rank[y]) {
				par[y] += par[x];
				par[x] = y;
			} else {
				par[x] += par[y];
				par[y] = x;
				if (rank[x] == rank[y]) {
					rank[x]++;
				}
			}
		}

		int find(int x) {
			if (par[x] < 0) {
				return x;
			} else {
				return par[x] = find(par[x]);
			}
		}

		boolean same(int x, int y) {
			return find(x) == find(y);
		}

		int getGroupSize(int x) {
			return -par[find(x)];
		}

		int getGroupCnt() {
			return groupCnt;
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}

	class MyScanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-')
					return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}
	}
}