import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) {
		ConsoleScanner cin = new ConsoleScanner();
		PrintWriter cout = new PrintWriter(System.out);
		solve(cin, cout);
		cout.flush();
	}

	private static void solve(ConsoleScanner cin, PrintWriter cout) {
		int n = cin.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < a.length; i++)
			a[i] = cin.nextInt();

		long ans = solve(n, a);

		cout.println(ans);
	}

	private static long solve(int n, long[] a) {
		long ans = Long.MAX_VALUE;
		long sum = Arrays.stream(a).sum();
		long x = 0;
		long y = sum;
		for (int i = 0; i < a.length - 1; i++) {
			x += a[i];
			y -= a[i];
			ans = Math.min(ans, Math.abs(x - y));
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
	}

}
