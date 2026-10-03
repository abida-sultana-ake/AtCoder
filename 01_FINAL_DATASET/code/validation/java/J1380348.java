import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static int mod= (int) (1e9+7);
	public static void main(String[] args) throws IOException {
		FastScanner in = new FastScanner(System.in);
		int n= in.nextInt();
		int m= in.nextInt();
		
		if(Math.abs(n-m)>1){
			System.out.println(0);
			return;
		}
		if(n==m){
			BigInteger res= go(n);
			res= res.multiply(go(m));
			res= res.mod(new BigInteger(""+mod));
			res= res.multiply(new BigInteger("2"));
			res= res.mod(new BigInteger(""+mod));
			System.out.println(res.toString());
			return;
		}
		BigInteger res= go(n);
		res= res.multiply(go(m));
		res= res.mod(new BigInteger(""+mod));
		System.out.println(res.toString());
	}
	public static BigInteger go(int n){
		BigInteger res= BigInteger.ONE;
		for (int i = 1; i <=n; i++) {
			res= res.multiply(new BigInteger("" + i));
			res= res.mod(new BigInteger(""+mod));
		}
		return res;
	}
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer("");
		}

		public double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

		public String next() throws IOException {
			if (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
				return next();
			}
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}
