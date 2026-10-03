
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) {
		FastScanner cin = new FastScanner();
		PrintWriter cout = new PrintWriter(System.out);
		solve(cin, cout);
		cout.flush();
	}

	private static void solve(FastScanner cin, PrintWriter cout) {
		int n = cin.nextInt();
		int[][] xs = new int[n][];
		int[][] ys = new int[n][];
		for (int i = 0; i < n; i++) {
			xs[i] = new int[] { cin.nextInt(), i };
			ys[i] = new int[] { cin.nextInt(), i };
		}

		long ans = solve(n, xs, ys);
		cout.println(ans);
	}

	private static long solve(int n, int[][] xs, int[][] ys) {
		// editorialと他人の解答を参考
		// 速度・メモリを調整中

		ArrayList<int[]> edges = new ArrayList<>();

		Arrays.sort(xs, Comparator.comparingInt((vi) -> vi[0]));
		Arrays.sort(ys, Comparator.comparingInt((vi) -> vi[0]));
		for (int[][] vis : new int[][][] { xs, ys })
			for (int i = 1; i < n; i++)
				edges.add(new int[] { Math.abs(vis[i - 1][0] - vis[i][0]), vis[i - 1][1], vis[i][1] });

		// 最小全域木
		// https://ja.wikipedia.org/wiki/%E5%85%A8%E5%9F%9F%E6%9C%A8
		// https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
		long ans = 0;
		Collections.sort(edges, Comparator.comparingInt((edge) -> edge[0]));

		rt = new int[n];
		Arrays.fill(rt, -1);

		for (int[] edge : edges) {
			int w = edge[0];
			int fr = edge[1];
			int to = edge[2];
			if (!unite(fr, to))
				continue;
			ans += w;
		}
		return ans;
	};

	private static int[] rt;

	private static int root(int operand) {
		if (rt[operand] < 0)
			return operand;
		return rt[operand] = root(rt[operand]);
	}

	private static boolean unite(int fr, int to) {
		int a = root(fr);
		int b = root(to);
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
