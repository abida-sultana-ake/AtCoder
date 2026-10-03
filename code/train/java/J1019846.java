import java.io.*;
import java.util.*;

public class Main {

	private static Scanner sc;
	private static Printer pr;

	private static void solve() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int l = sc.nextInt();

		UnionFindList road = new UnionFindList(n);
		UnionFindList rail = new UnionFindList(n);

		int[] p = new int[k];
		int[] q = new int[k];
		for (int i = 0; i < k; i++) {
			p[i] = sc.nextInt() - 1;
			q[i] = sc.nextInt() - 1;

			road.unite(p[i], q[i]);
		}

		int[] r = new int[l];
		int[] s = new int[l];
		for (int i = 0; i < l; i++) {
			r[i] = sc.nextInt() - 1;
			s[i] = sc.nextInt() - 1;

			rail.unite(r[i], s[i]);
		}

		int[] ret = new int[n];
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (ret[i] == 0) {
				Set<Integer> roadtmp = road.getList(i);
				Set<Integer> railtmp = rail.getList(i);

				ans.clear();
				if (roadtmp.size() < railtmp.size()) {
					for (int e : roadtmp) {
						if (railtmp.contains(e)) {
							ans.add(e);
						}
					}
				} else {
					for (int e : railtmp) {
						if (roadtmp.contains(e)) {
							ans.add(e);
						}
					}
				}

				for (int e : ans) {
					ret[e] = ans.size();
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (i > 0) {
				pr.print(" ");
			}
			pr.print(ret[i]);
		}
		pr.println();
	}

	@SuppressWarnings("unused")
	private static class UnionFindList {
		int n;
		// cnt : 異なる集合の数
		int cnt;

		// i2g : i番目の要素が属するグループ
		List<Integer> i2g;
		// g2i : そのグループに属する要素のリスト
		List<Set<Integer>> g2i;

		// 「データ構造をマージする一般的なテク」に基づくUnionFind
		// 指定した要素に属する集合を得られる。
		// Quick Find Weightedと呼ばれ、uniteがならしO(log n)、sameはO(1)
		UnionFindList(int n) {
			this.n = n;
			cnt = n;
			i2g = new ArrayList<>(n);
			g2i = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				i2g.add(i);
				Set<Integer> tmp = new HashSet<>();
				tmp.add(i);
				g2i.add(tmp);
			}
		}

		// xのrootを求める
		int find(int x) {
			return i2g.get(x);
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
			// 要素数が大きい集合にmergeする(Quick Find Weighted?)
			if (g2i.get(x).size() > g2i.get(y).size()) {
				g2i.get(x).addAll(g2i.get(y));
				for (int e : g2i.get(y)) {
					i2g.set(e, x);
				}
				g2i.set(y, null);
			} else {
				g2i.get(y).addAll(g2i.get(x));
				for (int e : g2i.get(x)) {
					i2g.set(e, y);
				}
				g2i.set(x, null);
			}

			return;
		}

		// 要素xを含む集合のリスト
		public Set<Integer> getList(int x) {
			return g2i.get(find(x));
		}

		// 要素xを含む集合の要素数
		int count(int x) {
			return g2i.get(find(x)).size();
		}

		// 異なる集合の数
		int count() {
			return cnt;
		}
	}

	// ---------------------------------------------------
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		pr = new Printer(System.out);

		solve();

		pr.close();
		sc.close();
	}

	@SuppressWarnings("unused")
	private static class Scanner {
		BufferedReader br;

		Scanner (InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		private boolean isPrintable(int ch) {
			return ch >= '!' && ch <= '~';
		}

		private boolean isCRLF(int ch) {
			return ch == '\n' || ch == '\r' || ch == -1;
		}

		private int nextPrintable() {
			try {
				int ch;
				while (!isPrintable(ch = br.read())) {
					if (ch == -1) {
						throw new NoSuchElementException();
					}
				}

				return ch;
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		String next() {
			try {
				int ch = nextPrintable();
				StringBuilder sb = new StringBuilder();
				do {
					sb.appendCodePoint(ch);
				} while (isPrintable(ch = br.read()));

				return sb.toString();
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		int nextInt() {
			try {
				// parseInt from Integer.parseInt()
				boolean negative = false;
				int res = 0;
				int limit = -Integer.MAX_VALUE;
				int radix = 10;

				int fc = nextPrintable();
				if (fc < '0') {
					if (fc == '-') {
						negative = true;
						limit = Integer.MIN_VALUE;
					} else if (fc != '+') {
						throw new NumberFormatException();
					}
					fc = br.read();
				}
				int multmin = limit / radix;

				int ch = fc;
				do {
					int digit = ch - '0';
					if (digit < 0 || digit >= radix) {
						throw new NumberFormatException();
					}
					if (res < multmin) {
						throw new NumberFormatException();
					}
					res *= radix;
					if (res < limit + digit) {
						throw new NumberFormatException();
					}
					res -= digit;

				} while (isPrintable(ch = br.read()));

				return negative ? res : -res;
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		long nextLong() {
			try {
				// parseLong from Long.parseLong()
				boolean negative = false;
				long res = 0;
				long limit = -Long.MAX_VALUE;
				int radix = 10;

				int fc = nextPrintable();
				if (fc < '0') {
					if (fc == '-') {
						negative = true;
						limit = Long.MIN_VALUE;
					} else if (fc != '+') {
						throw new NumberFormatException();
					}
					fc = br.read();
				}
				long multmin = limit / radix;

				int ch = fc;
				do {
					int digit = ch - '0';
					if (digit < 0 || digit >= radix) {
						throw new NumberFormatException();
					}
					if (res < multmin) {
						throw new NumberFormatException();
					}
					res *= radix;
					if (res < limit + digit) {
						throw new NumberFormatException();
					}
					res -= digit;

				} while (isPrintable(ch = br.read()));

				return negative ? res : -res;
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		float nextFloat() {
			return Float.parseFloat(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			try {
				int ch;
				while (isCRLF(ch = br.read())) {
					if (ch == -1) {
						throw new NoSuchElementException();
					}
				}
				StringBuilder sb = new StringBuilder();
				do {
					sb.appendCodePoint(ch);
				} while (!isCRLF(ch = br.read()));

				return sb.toString();
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		void close() {
			try {
				br.close();
			} catch (IOException e) {
//				throw new NoSuchElementException();
			}
		}
	}

	private static class Printer extends PrintWriter {
		Printer(PrintStream out) {
			super(out);
		}
	}
}
