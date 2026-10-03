import java.io.*;
import java.util.*;
class Main
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	static long[][] dis;
	
    public static void main(String args[]) throws Exception
    {
		int n=sc.nextInt(),m=sc.nextInt();dis=new long[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				dis[i][j]=Integer.MAX_VALUE;
			}
			dis[i][i]=0;
		}
		List<Node> list=new ArrayList<Node>();
		for(int i=1;i<=m;i++)
		{
			int u=sc.nextInt(),v=sc.nextInt(),cost=sc.nextInt();dis[u][v]=dis[v][u]=Math.min(cost,dis[u][v]);
			list.add(new Node(u,v,cost));
		}
		for(int k=1;k<=n;k++)
		{
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<=n;j++)
				{
					dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
				}
			}
		}
		int ans=0;
		for(int i=0;i<list.size();i++)
		{
			int u=list.get(i).u,v=list.get(i).v,cost=list.get(i).cost;
			if(cost==dis[u][v])
			{
				continue;
			}
			ans++;
		}
		out.println(ans);out.close();
    }
}
class Node
{
	int u,v,cost;
	public Node(int u,int v,int cost)
	{
		this.u=u;this.v=v;this.cost=cost;
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