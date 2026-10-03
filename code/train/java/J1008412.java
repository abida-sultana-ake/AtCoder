import java.io.*;
import java.util.*;
class Main
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	
    public static void main(String args[]) throws Exception
    {
		long a=sc.nextLong(),b=sc.nextLong(),x=sc.nextLong();
		if(a==0)
		{
			out.println((b/x)+1);
		}
		else if(a==1)
		{
			out.println(b/x);
		}
		else
		{
			long val1=(b/x),val2=((a-1)/x);out.println(val1-val2);
		}
		out.close();
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