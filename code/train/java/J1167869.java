import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	BufferedReader br;
	PrintWriter out;
	StringTokenizer st;
	boolean eof;

	static final Random rng = new Random();
	static final int P = BigInteger.probablePrime(30, rng).intValue();
	
	void solve() throws IOException {
//		System.err.println(P);
		int n = nextInt();
		int k = nextInt();
		int[] a = new int[n];
		
		int[] ways = new int[k + 1];
		ways[0] = 1;
		
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
			a[i] = Math.min(a[i], k);
			
			
			for (int j = k; j >= a[i]; j--) {
				ways[j] += ways[j - a[i]];
				if (ways[j] >= P) {
					ways[j] -= P;
				}
			}
		}
		
		int ret = 0;
		
		outer: for (int i = 0; i < n; i++) {
			int[] waysWO = ways.clone();
			for (int j = a[i]; j <= k; j++) {
				waysWO[j] -= waysWO[j - a[i]];
				if (waysWO[j] < 0) {
					waysWO[j] += P;
				}
			}
			
			for (int j = k - a[i]; j < k; j++) {
				if (waysWO[j] > 0) {
					continue outer;
				}
			}
			
			ret++;
			
		}
		
		out.println(ret);
	}

	Main() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return null;
			}
		}
		return st.nextToken();
	}

	String nextString() {
		try {
			return br.readLine();
		} catch (IOException e) {
			eof = true;
			return null;
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
}