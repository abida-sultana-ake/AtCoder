import java.io.*;
import java.util.*;
class Main
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	static int[] arr,sp;
	static int maxn=(int)(1e3)+3;
	static Map<Integer,Integer> m1=new HashMap<>();
	static long mod=(long)(1e9+7);
	
	static void mark(int num)
	{
		int i=2,elem;
		while((elem=(num*i))<maxn)
		{
			arr[elem]=1;i++;sp[elem]=num;
		}
	}
	
	static void build()
	{
		arr=new int[maxn];sp=new int[maxn];
		for(int i=2;i<maxn;i++)
		{
			if(arr[i]==0)
			{
				sp[i]=i;mark(i);
			}
		}
	}
	
	static void put(int idx,int val)
	{
		if(m1.get(idx)==null)	
		{
			m1.put(idx,val);
		}
		else
		{
			m1.put(idx,m1.get(idx)+val);
		}
	}
	
    public static void main(String args[]) throws Exception
    {
		build();int n=sc.nextInt();
		if(n==1)
		{
			out.println(1);
		}
		else
		{
			for(int i=2;i<=n;i++)
			{
				int curr=i;
				while(curr>1)
				{
					put(sp[curr],1);curr/=sp[curr];
				}
			}
			long res=1;
			for(Map.Entry<Integer,Integer> en:m1.entrySet())
			{
				long now=en.getValue()+1;
				res=(res*now)%mod;
			}
			out.println(res);
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