import java.lang.*;
import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws java.lang.Exception {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(in, out);
		out.close();
	}
}


class TaskA {
	
	public void solve(InputReader in, PrintWriter out) {
		final int mod = (int)(1e9+7);
		int n = in.nextInt();
		int m = in.nextInt();
		int mx = Math.max(n, m);
		long fact = 1;
		long fn = 1, fm = 1;
		
		for (int i=1; i<=mx; ++i) {
			fact = fact * i % mod;
			if (i == n) fn = fact;
			if (i == m) fm = fact;
		}
		
		// out.println(fn + " " + fm);
		long ans = 0;
		
		if (n == m) {
			ans = (2*fn%mod)*fm%mod;
		} else if (n==m+1 || n+1==m) {
			ans = fn*fm%mod;
		}
		
		out.println(ans);
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;
	
	InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}
	
	public String next() {
		while (tokenizer==null || !tokenizer.hasMoreTokens()) {
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

