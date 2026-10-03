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
			int[] a = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				sum += a[i];
			}
			boolean[] f = new boolean[sum + 1];
			f[0] = true;
			for (int x : a) {
				for (int i = sum; i >= 0; i--) {
					if (f[i] && i + x <= sum) {
						f[i + x] = true;
					}
				}
			}
			int ans = 0;
			for (int i = 0; i <= sum; i++) {
				if (i % 10 == 0) {
					continue;
				}
				if (f[i]) {
					ans = Math.max(ans, i);
				}
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

	}
}

