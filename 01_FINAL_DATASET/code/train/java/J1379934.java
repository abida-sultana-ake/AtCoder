import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class Main {

	public static void main(String args[]) {
		FastScanner cin = new FastScanner();
		PrintWriter cout = new PrintWriter(System.out);
		solve(cin, cout);
		cout.flush();
	}

	private static void solve(FastScanner cin, PrintWriter cout) {
		int n = cin.nextInt();
		int[][] xys = new int[n][];
		for (int i = 0; i < n; i++)
			xys[i] = new int[] { cin.nextInt(), cin.nextInt(), i };

		long ans = solve(n, xys);
		cout.println(ans);
	}

	private static long solve(int n, int[][] xys) {
		// editorialと他人の解答を参考

		ArrayList<int[]> edges = new ArrayList<>();

		ArrayList<int[]> ordered = new ArrayList<>();
		ordered.addAll(Arrays.asList(xys));
		for (int j = 0; j < 2; j++) {
			int tmp = j;
			Collections.sort(ordered, Comparator.comparingInt((xy) -> xy[tmp]));
			for (int i = 1; i < n; i++) {
				int fr = ordered.get(i - 1)[2];
				int to = ordered.get(i)[2];
				int[] frxy = xys[fr];
				int[] toxy = xys[to];
				int w = Math.abs(frxy[tmp] - toxy[tmp]);
				// int w = Math.min(Math.abs(frxy[0] - toxy[0]),
				// Math.abs(frxy[1] - toxy[1]));
				edges.add(new int[] { w, fr, to });
			}
		}

		// 最小全域木
		// https://ja.wikipedia.org/wiki/%E5%85%A8%E5%9F%9F%E6%9C%A8
		// クラスカル法
		// https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
		long ans = 0;
		Collections.sort(edges, Comparator.comparingInt((e) -> e[0]));

		int[] rt = new int[n];
		Arrays.fill(rt, -1);
		IntUnaryOperator root = new IntUnaryOperator() {
			@Override
			public int applyAsInt(int operand) {
				if (rt[operand] < 0)
					return operand;
				return rt[operand] = this.applyAsInt(rt[operand]);
			}
		};
		Predicate<int[]> unite = new Predicate<int[]>() {
			@Override
			public boolean test(int[] t) {
				int a = root.applyAsInt(t[0]);
				int b = root.applyAsInt(t[1]);
				if (a == b)
					return false;
				if (rt[a] > rt[b]) {
					int tmp = a;
					a = b;
					b = tmp;
				}
				rt[a] += rt[b];
				rt[b] = a;
				return true;
			}
		};
		for (int[] e : edges) {
			int w = e[0];
			int fr = e[1];
			int to = e[2];
			if (!unite.test(new int[] { fr, to }))
				continue;
			ans += w;
			// System.out.println(fr + " " + to);
			// System.out.println(Arrays.toString(rt));
		}
		return ans;
	};

	/**
	 * How to read input in Java — tutorial <br />
	 * By Flatfoot<br />
	 * http://codeforces.com/blog/entry/7018
	 */
	static class FastScanner {
		private BufferedReader br;
		private StringTokenizer st;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
			return st.nextToken();
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
			return str;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
