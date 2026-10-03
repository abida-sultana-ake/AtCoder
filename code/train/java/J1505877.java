import java.io.*;
import java.util.*;
import java.math.*;
import java.util.concurrent.*;

class Main
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	
	static long gcd(long a,long b)
	{
		if(b==0)
		{
			return a;
		}
		
		else
		{
			return gcd(b,a%b);
		}
	}
	
    public static void main(String args[]) throws Exception
    {
		int n=sc.nextInt();long[] arr=new long[n];
		
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextLong();
		}
		
		long curr=arr[0];
		
		for(int i=1;i<n;i++)
		{
			
		//	out.println(curr);
			
			long gcd=gcd(arr[i],curr);
			
			long p1=curr/gcd,p2=arr[i];
			
			curr=(p1*p2);
		}
		
		out.println(curr);out.close();
    }
}
class FastScanner
{
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }
	
    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
	
	public String next() throws Exception {
		return nextToken().toString();
	}
	
    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}