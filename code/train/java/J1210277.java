import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;
import java.io.*;

public class Main {
	
	void solve() {
		String S = sc.next();
		String T = sc.next();
		
		int[] sumS = new int[S.length() + 1];
		for (int i = 0; i < S.length(); i++) {
			sumS[i+1] = sumS[i] + (S.charAt(i) == 'A' ? 1 : 2);
		}
		int[] sumT = new int[T.length() + 1];
		for (int i = 0; i < T.length(); i++) {
			sumT[i+1] = sumT[i] + (T.charAt(i) == 'A' ? 1 : 2);
		}
		int Q = sc.nextInt();
		for (;Q-->0;) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			int d = sc.nextInt()-1;
			int x = sumS[b+1] - sumS[a];
			int y = sumT[d+1] - sumT[c];
			String ans = x % 3 == y % 3 ? "YES" : "NO";
			out.println(ans);
		}
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