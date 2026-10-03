import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main{ // Main

	public static void main(String args[]) {
		ConsoleScanner cin = new ConsoleScanner();
		PrintWriter cout = new PrintWriter(System.out);
		solve(cin, cout);
		cout.flush();
	}

	static long now() {
		return System.currentTimeMillis();
	}

	static void trace(Object... objects) {
		assert null != System.out.format("trace:%s\n", Arrays.deepToString(objects));
	}

	private static void solve(ConsoleScanner cin, PrintWriter cout) {
		// assert solve(1) == 1;

		int h = cin.nextInt();
		int w = cin.nextInt();
		int n = cin.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < a.length; i++)
			a[i] = cin.nextInt();

		long start = now();

		int[][] ans = solve(h, w, n, a);
		String ansstr = Arrays.stream(ans)
				.map(row -> Arrays.stream(row).mapToObj(Objects::toString).collect(Collectors.joining(" ")))
				.collect(Collectors.joining(System.lineSeparator()));
		cout.println(ansstr);

		trace("elapsed", now() - start);
	}

	private static int[][] solve(int h, int w, int n, int[] a) {
		int[][] ans = new int[h][w];
		int c = 0;
		for (int y = 0; y < h; y++) {
			int s, d;
			if (y % 2 == 0) {
				s = 0;
				d = 1;
			} else {
				s = w - 1;
				d = -1;
			}
			for (int i = 0, x = s; i < w; i++, x += d) {
				ans[y][x] = c + 1;
				a[c] -= 1;
				if (a[c] == 0)
					c += 1;
			}
		}
		return ans;
	}

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

}
