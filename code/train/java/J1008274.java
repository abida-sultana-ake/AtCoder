/*
 * Code Author: Akshay Miterani
 * DA-IICT
 */
import java.io.*;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

	static double eps=(double)1e-6;
	static long mod=(long)1e9+7;
	static final long INF = Long.MAX_VALUE / 100;
	public static void main(String args[]) throws FileNotFoundException{
		InputReader in = new InputReader(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		//----------------My Code------------------
		int n=in.nextInt();
		long k=in.nextInt();
		long a[]=new long[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextLong();
		}
		long ans=0;
		for(int i=0;i<n-1;i++){
			long del=a[i+1]+a[i]-k;
			if(del<=0)
				continue;
			if(del<=a[i+1]){
				a[i+1]-=del;
			}
			else{
				a[i]-=del-a[i+1];
				a[i+1]=0;
			}
			ans+=del;
		}
		System.out.println(ans);
		out.close();
		//----------------The End------------------

	}
	static boolean isPrime(long x){
		for(int i=2;i<=Math.sqrt(x)+1;i++){
			if(x%i==0 && i!=x)
				return false;
		}
		return true;
	}
	static long modulo(long a,long b,long c) {
		long x=1;
		long y=a;
		while(b > 0){
			if(b%2 == 1){
				x=(x*y)%c;
			}
			y = (y*y)%c; // squaring the base
			b /= 2;
		}
		return  x%c;
	}
	static long gcd(long x, long y)
	{
		if(x==0)
			return y;
		if(y==0)
			return x;
		long r=0, a, b;
		a = (x > y) ? x : y; // a is greater number
		b = (x < y) ? x : y; // b is smaller number
		r = b;
		while(a % b != 0)
		{
			r = a % b;
			a = b;
			b = r;
		}
		return r;
	}
	static class Pair implements Comparable<Pair>{
		int x;
		int y;

		Pair(int xx,int yy){
			x=xx;
			y=yy;
		}
		@Override
		public int compareTo(Pair o) {
			if(Long.compare(this.x, o.x)!=0)
				return Long.compare(this.x, o.x);
			else
				return Long.compare(this.y, o.y);
		}
	}
	public static void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream inputstream) {
			reader = new BufferedReader(new InputStreamReader(inputstream));
			tokenizer = null;
		}

		public String nextLine(){
			String fullLine=null;
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					fullLine=reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}     