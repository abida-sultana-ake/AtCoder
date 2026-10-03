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
	static ArrayList<Integer>[] al;
	static int[] size,level,parent;
	
	static void dfs(int u,int p,int curr)
	{
		size[u]=1;level[u]=curr;
		
		parent[u]=p;
		
		for(int x:al[u])
		{
			if(x!=p)
			{
				dfs(x,u,curr+1);size[u]+=size[x];
			}
		}
	}
	
	@SuppressWarnings("unchecked")
    public static void main(String args[]) throws Exception
    {
		int n=sc.nextInt();al=new ArrayList[n];
		
		for(int i=0;i<n;i++)
		{
			al[i]=new ArrayList<Integer>();
		}
		
		for(int i=1;i<n;i++)
		{
			int u=sc.nextInt()-1,v=sc.nextInt()-1;
			
			al[u].add(v);al[v].add(u);
		}
	
		level=new int[n];size=new int[n];parent=new int[n];dfs(0,-1,1);
		
		int dis=level[n-1]-level[0]-1,now=dis/2,curr=n-1;
		
		while(now>0)
		{
			curr=parent[curr];now--;
		}
		
		int val2=size[curr],val1=n-val2;
		
		out.println(val1>val2?"Fennec":"Snuke");out.close();
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