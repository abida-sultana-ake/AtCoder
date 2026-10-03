import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] fact = new long[300000];
	static long mod = (long) 1e9 + 7;

	static long pow(long base, long pow) {
		if (pow == 1)
			return base;
		long half = pow(base, pow / 2);
		half %= mod;
		half *= half;
		half %= mod;
		if (pow % 2 == 1)
			half *= base;
		half %= mod;
		return half;
	}

	static long C(int n, int r) {
		long f = fact[n];
		f *= pow(fact[r], mod - 2);
		f %= mod;
		f *= pow(fact[n - r], mod - 2);
		f %= mod;
		return f;
	}

	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++) {
			fact[i] = fact[i - 1] * i;
			fact[i] %= mod;
		}
		long h = r.nextLong();
		long w = r.nextLong();
		long a = r.nextLong();
		long b = r.nextLong();
		long res = 0;
		for (long i = 1; i <= h - a; i++) {
			long way1 = C((int) (b - 1 + i - 1), (int) b - 1);
			way1 *= C((int) (w - b - 1 + h - i), (int) (h - i));
			way1 %= mod;
			res += way1;
			res %= mod;
		}
		System.out.println(res);
	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader(FileReader stream) {
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
