import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;
import java.io.*;

public class Main {
	static final long MOD = (long)(1e9 + 7);
	
	void solve() {
		int H = sc.nextInt()-1;
		int W = sc.nextInt()-1;
		int A = sc.nextInt()-1;
		int B = sc.nextInt()-1;
		long ans = f(H, W);
		for (int a = 0; a <= A; a++) {
			long k = f(a, W - B - 1) * f(B, H - a) % MOD;
			ans = (ans - k + MOD) % MOD;
		}
		out.println(ans);
		
	}
	
	static final long[] fact = new long[1000000 + 10];
	static final long[] fact_inv = new long[1000000 + 10];
	static {
	    long[] inv = new long[1000000 + 10];
	    inv[1] = fact[0] = fact_inv[0] = 1;
	    for (int i = 2; i < inv.length; i++) inv[i] = inv[(int)(MOD % i)] * (MOD - MOD / i) % MOD;
	    for (int i = 1; i < fact.length; i++) fact[i] = (fact[i-1] * i) % MOD;
	    for (int i = 1; i < fact_inv.length; i++) fact_inv[i] = (fact_inv[i-1] * inv[i]) % MOD;
	}
	long f(long A, long B) {
		long res = fact[(int)(A + B)];
		res = (res * fact_inv[(int)(A)]) % MOD;
		res = (res * fact_inv[(int)(B)]) % MOD;
		return res;
	}
	long C(long n, long k) {
	    if ( n < 0 || k < 0 || n < k) return 0;
	    return fact[(int)n] * fact_inv[(int)(n - k)] % MOD * fact_inv[(int)k] % MOD;
	}
	
	static void tr(Object... os) { System.err.println(deepToString(os)); }
	static void tr(int[][] as) { for (int[] a : as) tr(a); }

	void print(int[] a) {
		out.print(a[0]);
		for (int i = 1; i < a.length; i++) out.print(" " + a[i]);
		out.println();
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

	MyScanner sc = null;
	PrintWriter out = null;
	public void run() throws Exception {
		sc = new MyScanner(System.in);
		out = new PrintWriter(System.out);
		for (;sc.hasNext();) {
			solve();
			out.flush();
		}
		out.close();
	}

	class MyScanner {
		String line;
		BufferedReader reader;
		StringTokenizer tokenizer;

		public MyScanner(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}
		public void eat() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					line = reader.readLine();
					if (line == null) {
						tokenizer = null;
						return;
					}
					tokenizer = new StringTokenizer(line);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		public String next() {
			eat();
			return tokenizer.nextToken();
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		public boolean hasNext() {
			eat();
			return (tokenizer != null && tokenizer.hasMoreElements());
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
		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
	}
}