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
		int N = readInt();
		int Q = readInt();
		int[] lcnt = new int[N];
		int[] rcnt = new int[N];
		int[] l = new int[Q];
		int[] r = new int[Q];
		readArr2(l, r);
		for (int i=0; i<Q; i++) {
			lcnt[l[i]-1]++;
			rcnt[r[i]-1]++;
		}
		int tmp = 0;
		for (int i=0; i<N; i++) {
			tmp += lcnt[i];
			out.print(tmp%2);
			tmp -= rcnt[i];
		}
		out.println();
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
