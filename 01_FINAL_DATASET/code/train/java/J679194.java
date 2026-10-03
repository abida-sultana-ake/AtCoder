import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;


	static void solve() throws IOException {
		String S = readString();
		String ans = "";
		int[] A = readArr(4);
		int idx = 0;
		if (A[0] == 0) {
			ans += "\"";
			idx++;
		}
		for (int i=0; i<S.length(); i++) {
			ans += S.charAt(i);
			if (idx < 4 && i+1 == A[idx]) {
				ans += "\"";
				idx++;
			}
		}
		out.println(ans);
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
