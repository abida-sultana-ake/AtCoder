import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextLong();
			}
			long ans = Long.MAX_VALUE;
			if (a[0] == 0) {
				ans = Math.min(ans, 1 + solve(n, a, +1));
				ans = Math.min(ans, 1 + solve(n, a, -1));
			} else {
				ans = solve(n, a, a[0]);
				ans = Math.min(ans, Math.abs(a[0]) + 1 + solve(n, a, -Long.signum(a[0])));
			}
			out.println(ans);
		}

		private long solve(int n, long[] a, long sum) {
			long res = 0;
			for (int i = 1; i < n; i++) {
				long x = a[i];
				long nx = x;
				if (Long.signum(sum) + Long.signum(sum + nx) != 0) {
					nx = -sum;
					if (sum > 0) {
						--nx;
					} else {
						++nx;
					}
				}
				sum += nx;
				res += Math.abs(nx - x);
			}
			return res;
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
					String rl = in.readLine();
					if (rl == null) {
						return null;
					}
					st = new StringTokenizer(rl);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

	}
}

