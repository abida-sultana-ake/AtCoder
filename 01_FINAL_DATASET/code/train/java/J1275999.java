import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) {
		FastScanner cin = new FastScanner();
		PrintWriter cout = new PrintWriter(System.out);
		solve(cin, cout);
		cout.flush();
	}

	private static void solve(FastScanner cin, PrintWriter cout) {
		assert solve(4, 6, new int[][] { { 2, 1 }, { 3, 4 }, { 4, 10 }, { 3, 4 } }) == 11;
		assert solve(4, 10, new int[][] { { 1, 100 }, { 1, 100 }, { 1, 100 }, { 1, 100 } }) == 400;
		assert solve(4, 1, new int[][] { { 10, 100 }, { 10, 100 }, { 10, 100 }, { 10, 100 } }) == 0;
		int N = cin.nextInt();
		int W = cin.nextInt();
		int[][] wv = new int[N][];
		for (int i = 0; i < N; i++)
			wv[i] = new int[] { cin.nextInt(), cin.nextInt() };
		long ans = solve(N, W, wv);
		cout.println(ans);
	}

	private static long solve(long N, long W, int[][] wv) {
		// Q.メモリ使用量／計算量が爆発しないか？
		// A. w[1]<=w[i]<=w[1]+3, for i=2..N
		HashMap<Integer, Long> valueByWeight = new HashMap<>();
		valueByWeight.put(0, 0L);
		HashMap<Integer, Long> temp = new HashMap<>();
		for (int[] z : wv) {
			int w = z[0];
			int v = z[1];
			temp.clear();
			temp.putAll(valueByWeight);
			for (Map.Entry<Integer, Long> entry : valueByWeight.entrySet()) {
				int nw = entry.getKey() + w;
				long nv = entry.getValue() + v;
				if (nw > W)
					continue;
				if (temp.containsKey(nw) && temp.get(nw) > nv)
					continue;
				temp.put(nw, nv);
			}
			HashMap<Integer, Long> sw = temp;
			temp = valueByWeight;
			valueByWeight = sw;
			// System.out.println(sw);
		}
		long ans = valueByWeight.values().stream().mapToLong(x -> x).max().getAsLong();
		return ans;
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
