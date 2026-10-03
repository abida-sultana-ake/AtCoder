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
	static ArrayList<Node>[] al;
	static long[] sum;
	
	static void dfs(int u,int p)
	{	
		for(Node x:al[u])	
		{
			if(x.val!=p)
			{
				sum[x.val]=sum[u]+x.cost;
				
				dfs(x.val,u);
			}
		}
	}
	
    public static void main(String args[]) throws Exception
    {
		int n=sc.nextInt();al=new ArrayList[n];sum=new long[n];
		
		for(int i=0;i<n;i++)
		{
			al[i]=new ArrayList<>();
		}
		
		for(int i=1;i<n;i++)
		{
			int u=sc.nextInt()-1,v=sc.nextInt()-1,cost=sc.nextInt();
			
			al[u].add(new Node(v,cost));al[v].add(new Node(u,cost));
		}
		
		int q=sc.nextInt(),k=sc.nextInt()-1;dfs(k,-1);
		
		for(int i=0;i<q;i++)
		{
			out.println(sum[sc.nextInt()-1]+sum[sc.nextInt()-1]);
		}
		
		out.close();
    }
}

class Node
{
	int val;long cost;
	
	public Node(int val,long cost)
	{
		this.val=val;this.cost=cost;
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