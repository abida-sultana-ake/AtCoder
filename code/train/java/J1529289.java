import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskC {
		public void solve(int testNumber, FastScanner in, PrintWriter out) {
			int n = in.nextInt();
			Map<Integer, Integer> am = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int x = in.nextInt();
				int v = 0;
				if (am.containsKey(x)) {
					v = am.get(x);
				}
				am.put(x, v + 1);
			}
			long max1 = -1;
			long max2 = -1;
			long max3 = -1;
			for (Map.Entry<Integer, Integer> e : am.entrySet()) {
				int x = e.getKey();
				if (e.getValue() >= 4) {
					max3 = Math.max(max3, x);
				}
				if (e.getValue() >= 2) {
					if (x >= max1) {
						max2 = max1;
						max1 = x;
					} else if (x >= max2) {
						max2 = x;
					}
				}
			}
			long ans = 0;
			if (max1 >= 0 && max2 >= 0) {
				ans = Math.max(ans, max1 * max2);
			}
			if (max3 >= 0) {
				ans = Math.max(ans, max3 * max3);
			}
			out.println(ans);
		}

	}

	static class FastScanner {
		private BufferedReader in;
		private StringTokenizer st;

		public FastScanner(InputStream stream) {
			in = new BufferedReader(new InputStreamReader(stream));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(in.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}

