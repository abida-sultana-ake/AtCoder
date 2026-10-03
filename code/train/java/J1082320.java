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
		long curr=sc.nextLong();
		if(curr<=6)
		{
			out.println(1);
		}
		else if(curr<=11)
		{
			out.println(2);
		}
		else
		{
			long val1=(curr/11L);curr-=(val1*11L);long add=((curr==0?0:(curr<=6?1:2)));
			out.println((val1*2)+add);
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