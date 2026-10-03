import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	
	int N;
	Long[] f; //iを根として塗れる数
	Long[] g; //iが白で根として塗れる数
	List<Edge>[] edge;
	int mod=(int)Math.pow(10, 9)+7;
	boolean used[];
	
	void solve(){
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		f=new Long[N];
		g=new Long[N];
		edge=new List[N];
		used=new boolean[N];
		for(int i=0;i<N;i++)edge[i]=new ArrayList<Edge>();
		
		for(int i=0;i<N-1;i++){
			int a=sc.nextInt()-1;
			int b=sc.nextInt()-1;
			addEdge(a,b);
			addEdge(b,a);
		}
		
		dfs(0);
		System.out.println(f[0]);
	}
	void dfs(int s){
		used[s]=true;
		long gg=1;
		long ff=1;
		for(Edge e:edge[s]){
			if(used[e.to])continue;
			dfs(e.to);
			gg*=f[e.to];
			ff*=g[e.to];
			gg%=mod;
			ff%=mod;
		}
		ff+=(gg%mod);
		g[s]=gg%mod;
		f[s]=ff%mod;
	}
	
	void addEdge(int from,int to){
		edge[from].add(new Edge(to,from));
	}
	
	class Edge{
		int to;
		int from;
		Edge(int to,int from){
			this.to=to;
			this.from=from;
		}
	}
}
