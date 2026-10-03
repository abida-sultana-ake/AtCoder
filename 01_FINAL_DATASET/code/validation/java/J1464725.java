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
		TaskE solver = new TaskE();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskE {
		public void solve(int testNumber, FastScanner in, PrintWriter out) {
			int n = in.nextInt();
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextLong();
			}
			long ans = 0;
			while (true) {
				boolean changed = false;
				for (int i = 0; i < n; i++) {
					if (a[i] < n) {
						continue;
					}
					changed = true;
					long x = a[i] / n;
					a[i] -= n * x;
					ans += x;
					for (int j = 0; j < n; j++) {
						if (j != i) {
							a[j] += x;
						}
					}
				}
				if (!changed) {
					break;
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

		public long nextLong() {
			return Long.parseLong(next());
		}

	}
}

