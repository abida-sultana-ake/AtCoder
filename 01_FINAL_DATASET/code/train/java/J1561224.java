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

		int[] a = new int[n];
		for (int i = 0; i < a.length; i++)
			a[i] = cin.nextInt();

		now.getAsLong();

		int ans = solve(n, a);
		cout.println(ans);

		assert 0 == tr("elapsed", now.getAsLong());
	}

	private static int solve(int n, int[] a) {
		int ans = 0;
		for (int i = 1; i < n; i++) {
			if (a[i - 1] == i && a[i] == i + 1) {
				ans += 1;
				int t = a[i - 1];
				a[i - 1] = a[i];
				a[i] = t;
			}
		}
		for (int i = 0; i < n; i++) {
			if (a[i] == i + 1) {
				ans += 1;
			}
		}
		return ans;
	}

}
