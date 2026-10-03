import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Printer pr = new Printer(System.out);

		int n = sc.nextInt();

		Pair[] hw = new Pair[n + 1];
		for (int i = 0; i < n; i++) {
			hw[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
		hw[n] = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
		Arrays.sort(hw);

		int[] dp = new int[n];
		Arrays.fill(dp, n);

		for (int i = 0; i < n; i++) {
			int l = -1;
			int r = n;
			while (r - l > 1) {
				int mid = l + (r - l) / 2;
				if (hw[dp[mid]].b >= hw[i].b) {
					r = mid;
				} else {
					l = mid;
				}
			}
			dp[r] = i;
		}

		int l = -1;
		int r = n;
		while (r - l > 1) {
			int mid = l + (r - l) / 2;
			if (hw[dp[mid]].b >= hw[n].b) {
				r = mid;
			} else {
				l = mid;
			}
		}

		pr.println(r);

		pr.close();
		sc.close();
	}

	private static class Pair implements Comparable<Pair> {
		int a;
		int b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.a == o.a) {
				return Integer.compare(o.b, this.b);
			} else {
				return Integer.compare(this.a, o.a);
			}
		}
	}

	@SuppressWarnings("unused")
	private static class Scanner {
		BufferedReader br;
		Iterator<String> it;

		Scanner (InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		String next() throws RuntimeException  {
			try {
				if (it == null || !it.hasNext()) {
					it = Arrays.asList(br.readLine().split(" ")).iterator();
				}
				return it.next();
			} catch (IOException e) {
				throw new IllegalStateException();
			}
		}

		int nextInt() throws RuntimeException {
			return Integer.parseInt(next());
		}

		long nextLong() throws RuntimeException {
			return Long.parseLong(next());
		}

		float nextFloat() throws RuntimeException {
			return Float.parseFloat(next());
		}

		double nextDouble() throws RuntimeException {
			return Double.parseDouble(next());
		}

		void close() {
			try {
				br.close();
			} catch (IOException e) {
//				throw new IllegalStateException();
			}
		}
	}

	private static class Printer extends PrintWriter {
		Printer(PrintStream out) {
			super(out);
		}
	}
}
