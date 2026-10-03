import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;
import java.io.*;

public class Main {
	
	void solve() {
		int N = sc.nextInt();
		int[] A = sc.nextIntArray(3 * N);
		
		long[] B = new long[3 * N + 1];
		long[] C = new long[3 * N + 1];
		
		{
			PriorityQueue<Integer> q= new PriorityQueue<>();
			long sum = 0;
			for (int i = 0; i < N; i++) {
				sum += A[i];
				q.add(A[i]);
			}
			for (int i = N; i <= 3 * N; i++) {
				B[i] = sum;
				if (i < 3 * N) {
					sum += A[i];
					q.add(A[i]);
					sum -= q.poll();
				}
			}
//			tr(B);
		}
		{
			PriorityQueue<Integer> q = new PriorityQueue<>();
			long sum = 0;
			for (int i = 3*N-1; i >= 2*N; i--) {
				sum += A[i];
				q.add(-A[i]);
			}
			for (int i = 2*N-1; i >= 0; i--) {
				C[i+1] = sum;
				sum += A[i];
				q.add(-A[i]);
				sum += q.poll();
			}
			C[0] = sum;
//			tr(C);
		}
		long ans = -(1L << 58);
		for (int i = N; i <= 2*N; i++) {
			ans = max(B[i] - C[i], ans);
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