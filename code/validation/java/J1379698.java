
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	static final long MOD = (long) 1e9 + 7;
	static final int MAX = (int) 1e5 + 1;

	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), m = sc.nextInt();
		long[] fact = new long[MAX];
		fact[0] = fact[1] = 1;
		for (int i = 2; i < MAX; i++)
			fact[i] = (i * fact[i - 1]) % MOD;
		if (n == m)
			out.println((((fact[n] * fact[m]) % MOD) << 1) % MOD);
		else if (n + 1 == m || n - 1 == m)
			out.println((fact[n] * fact[m]) % MOD);
		else
			out.println(0);
		out.flush();
		out.close();
	}

	static class MyScanner {
		StringTokenizer st;
		BufferedReader br;

		public MyScanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public MyScanner(String file) throws IOException {
			br = new BufferedReader(new FileReader(new File(file)));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
