import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) {
		ConsoleScanner cin = new ConsoleScanner();
		PrintWriter cout = new PrintWriter(System.out);
		solve(cin, cout);
		cout.flush();
	}

	private static void solve(ConsoleScanner cin, PrintWriter cout) {
		// assert solve(1) == 1;

		int n = cin.nextInt();
		int m = cin.nextInt();
		int[][] abs = new int[m][];
		for (int i = 0; i < abs.length; i++)
			abs[i] = new int[] { cin.nextInt(), cin.nextInt() };

		long millis = System.currentTimeMillis();

		boolean ans = solve(n, m, abs);
		if (ans)
			cout.println("POSSIBLE");
		else
			cout.println("IMPOSSIBLE");

		assert null != cout.format("%d elapsed", System.currentTimeMillis() - millis);
	}

	private static boolean solve(int n, int m, int[][] abs) {
		Set<Long> ships = new HashSet<>();
		for (int[] ab : abs) {
			ships.add(((long) ab[0] << 30) + ab[1]);
			ships.add(((long) ab[1] << 30) + ab[0]);
		}
		for (int mid = 2; mid < n; mid++) {
			if (!ships.contains(((long) mid << 30) + 1))
				continue;
			if (!ships.contains(((long) mid << 30) + n))
				continue;
			return true;
		}
		return false;
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
