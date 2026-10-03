import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;

	static final long MOD = 1000000007;

	static void solve() throws IOException {
		int N = readInt();
		int[] a = readArr(N);
		Pair[] pair = new Pair[N];
		for (int i=0; i<N; i++) {
			pair[i] = new Pair(a[i], i);
		}
		Arrays.sort(pair);
		int[] ans = new int[N];
		int num = 0;
		ans[0] = num;
		for (int i=1; i<N; i++) {
			if (pair[i-1].val != pair[i].val) num++;
			ans[i] = num;
		}
		Pair[] pair2 = new Pair[N];
		for (int i=0; i<N; i++) {
			pair2[i] = new Pair(pair[i].num, ans[i]);
		}
		Arrays.sort(pair2);
		for (int i=0; i<N; i++) {
			out.println(pair2[i].num);
		}
	}

	static class Pair implements Comparable<Pair> {
		int val;
		int num;
		public Pair(int val, int num) {
			this.val = val;
			this.num = num;
		}
		@Override
		public int compareTo(Pair pair) {
			return Integer.compare(val, pair.val);
		}
	}


	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		tok = new StringTokenizer("");
		solve();
		out.close();
	}

	static String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine(), " .");
		}
		return tok.nextToken();
	}

	static int readInt() throws IOException {
		return Integer.parseInt(readString());
	}

	static long readLong() throws IOException {
		return Long.parseLong(readString());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(readString());
	}

	static int[] readArr(int n) throws IOException {
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = readInt();
		}
		return res;
	}

	static long[] readArrL(int n) throws IOException {
		long[] res = new long[n];
		for (int i = 0; i < n; i++) {
			res[i] = readLong();
		}
		return res;
	}

	static void readArr2(int[] A, int[] B) throws IOException {
		int n = A.length;
		for (int i = 0; i < n; i++) {
			A[i] = readInt();
			B[i] = readInt();
		}
	}

	static void readArrL2(long[] A, long[] B) throws IOException {
		int n = A.length;
		for (int i = 0; i < n; i++) {
			A[i] = readLong();
			B[i] = readLong();
		}
	}
}
