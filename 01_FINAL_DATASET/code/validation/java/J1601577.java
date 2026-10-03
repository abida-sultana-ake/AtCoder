import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.LongSupplier;

public class Main{ // 

	static class ConsoleScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			try {
				while (!st.hasMoreElements())
					st = new StringTokenizer(br.readLine());
				return st.nextToken();
			} catch (IOException e) {
				throw new AssertionError(e);
			}
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

	static LongSupplier now = new LongSupplier() {
		private long t = System.currentTimeMillis();

		@Override
		public long getAsLong() {
			long a = t;
			t = System.currentTimeMillis();
			long ans = t - a;
			return ans;
		}
	};

	public static void main(String args[]) {
		ConsoleScanner cin = new ConsoleScanner();
		PrintWriter cout = new PrintWriter(System.out);
		solve(cin, cout);
		cout.flush();
	}

	static int tr(Object... objects) {
		System.out.println("tr:" + Arrays.deepToString(objects));
		return 0;
	}

	private static void solve(ConsoleScanner cin, PrintWriter cout) {
		// assert solve(1) == 1;

		int n = cin.nextInt();

		int[][] a = new int[n][n];
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a.length; j++)
				a[i][j] = cin.nextInt();

		now.getAsLong();

		long ans = solve(n, a);
		cout.println(ans);

		assert 0 == tr("elapsed", now.getAsLong());
	}

	private static long solve(int n, int[][] a) {
		// Warshall-Floyd

		long ans = 0;

		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (a[i][j] > a[i][k] + a[k][j])
						return -1;

		for (int i = 0; i < n; i++)
			fromTo: for (int j = 0; j < i; j++) {
				via: for (int k = 0; k < n; k++)
					if (k != i && k != j && a[i][j] == a[i][k] + a[k][j])
						// if can bypass
						continue fromTo;
					else
						continue via;
				ans += a[i][j];
			}

		return ans;
	}

}
