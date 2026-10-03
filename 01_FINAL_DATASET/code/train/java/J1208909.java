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
			char[] s = in.next().toCharArray();
			char[] t = in.next().toCharArray();
			int[][] sumsS = partialSums(s);
			int[][] sumsT = partialSums(t);
			int numQueries = in.nextInt();
			for (int query = 0; query < numQueries; query++) {
				int a = in.nextInt() - 1;
				int b = in.nextInt() - 1;
				int c = in.nextInt() - 1;
				int d = in.nextInt() - 1;
				int is = getInvariant(sumsS, a, b);
				int it = getInvariant(sumsT, c, d);
				out.println(is == it ? "YES" : "NO");
			}
		}

		private int getInvariant(int[][] sums, int l, int r) {
			int na = sums[0][r + 1] - sums[0][l];
			int nb = sums[1][r + 1] - sums[1][l];
			return (na + 2 * nb) % 3;
		}

		private int[][] partialSums(char[] s) {
			int[][] sums = new int[2][s.length + 1];
			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < 2; j++) {
					sums[j][i + 1] = sums[j][i];
					if (s[i] == (char) (j + 'A')) {
						++sums[j][i + 1];
					}
				}
			}
			return sums;
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

