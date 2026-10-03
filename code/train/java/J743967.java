import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Printer pr = new Printer(System.out);

		int n = sc.nextInt();

		int[] a = new int[n];
		int cnt = 1;
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if (i > 0) {
				if (a[i] > a[i - 1]) {
					cnt++;
				} else {
					res.add(cnt);
					cnt = 1;
				}
			}
		}
		res.add(cnt);

		long ret = 0;
		for (int e : res) {
			if (e > 1) {
				ret += (long)e * (e - 1) / 2;
			}
		}

		pr.println(ret + n);

		pr.close();
		sc.close();
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
