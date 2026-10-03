import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main{ // 

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

		int n = cin.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < a.length; i++)
			a[i] = cin.nextInt();

		long start = now();

		long ans = solve(n, a);
		cout.println(ans);

		trace("elapsed", now() - start);
	}

	private static long solve(int n, int[] a) {
		TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		for (int x : a)
			map.put(x, 1 + map.getOrDefault(x, 0));
		long area = 1;
		long sides = 0;
		outer: for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			int len = e.getKey();
			int cnt = e.getValue();
			for (int i = 0; i < 2; i++) {
				if (cnt < 2)
					break;
				cnt -= 2;
				sides += 2;
				area *= len;
				if (sides == 4)
					break outer;
			}
		}
		if (sides != 4)
			return 0;
		return area;
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
