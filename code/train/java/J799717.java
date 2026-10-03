
import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;
import java.io.*;

public class Main {

	static final int INF = 1001001001;
	void solve() {
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] a = sc.nextIntArray(N);
		int[][] dp = new int[N+1][N+1];
		int[] m = new int[N+1];
		for (int i = 0; i < N; i++) {
			m[i+1] = m[i] + a[i];
		}
		for (int i = 0; i < dp.length; i++) fill(dp[i], INF);
		
		dp[0][0] = 0;
		for (int i = 0; i < N; i++) {
			for (int g = 0; g <= i; g++) {
				{
					long w2 = dp[i][g]; 
					if (m[N]-m[i+1]+ w2 < K) {
						w2 = K-m[N]+m[i+1];
					}
					dp[i+1][g] = Math.min(dp[i+1][g], (int)w2);
				}
				long w = dp[i][g];
				long w2 = m[i] == 0 ? 1 : 1 + (m[i+1] * w / m[i]);
				if (m[N] - m[i+1] + w2 < K) {
					w2 = K-m[N]+m[i+1];
				}
//				tr(i, g, "=>", i+1, g+1, w2);
				if (w2 <= m[i+1]) {
					if (g+1<=N) dp[i+1][g+1] = Math.min(dp[i+1][g+1], (int)w2);
				}
			}
		}
		
//		for (int i = 0; i < dp.length; i++)
//			tr(dp[i]);
		
		int ans = 0;
		for (int g = 0; g <= N; g++) {
			if (dp[N][g] <= K) ans = Math.max(ans, g);
		}
		out.println(ans);
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