import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        new Main().solve();
    }
    int MAX_N=100000;
    int MAX_LOG=(int)(Math.log(MAX_N)/Math.log(2))+1;
    int n;
    ArrayList<Integer>[]path;
    int root=0;
    //parent[k][v]:=頂点vから2^k回親を辿った時に到達する頂点
    int[][]parent;
    int[]depth;
    
   void solve() {
	  Scanner sc=new Scanner(System.in);
	  int n=sc.nextInt();
	  int[]x=new int[n-1];
	  int[]y=new int[n-1];
	  path=new ArrayList[n];
	  for(int i=0;i<n;i++) {
		  path[i]=new ArrayList<Integer>();
	  }
	  for(int i=0;i<n-1;i++) {
		  x[i]=sc.nextInt()-1;
		  y[i]=sc.nextInt()-1;
		  path[x[i]].add(y[i]);
		  path[y[i]].add(x[i]);
	  }
	  
	  int q=sc.nextInt();
	  int[]a=new int[q];
	  int[]b=new int[q];
	  for(int i=0;i<q;i++) {
		  a[i]=sc.nextInt()-1;
		  b[i]=sc.nextInt()-1;
	  }
	  parent=new int[MAX_LOG][n];
	  depth=new int[n];
	  init(n);
	  for(int i=0;i<q;i++) {
		  System.out.println(depth[a[i]]+depth[b[i]]-2*depth[lca(a[i],b[i])]+1);
	  }
   }
   
   
   void dfs(int v,int p,int d) {
	   parent[0][v]=p;
	   depth[v]=d;
	   for(int i=0;i<path[v].size();i++) {
		   if(path[v].get(i)!=p) {
			   dfs(path[v].get(i), v, d+1);
		   }
	   }
   }
   //初期化
   void init(int V) {
	   //parent[0]とdepthを初期化する
	   dfs(root,-1,0);
	   //parentを初期化する
	   for(int k=0;k+1<MAX_LOG;k++) {
		   for(int v=0;v<V;v++) {
			   if(parent[k][v]<0)parent[k+1][v]=-1;
			   else parent[k+1][v]=parent[k][parent[k][v]];
		   }
	   }
   }
   
   //uとvのLCAを求める
   int lca(int u, int v) {
	   //uとvの深さが同じになるまで親をたどる
	   if(depth[u]>depth[v]) {
		   int temp=u;
		   u=v;
		   v=temp;
	   }
	   for(int k=0;k<MAX_LOG;k++) {
		   if((((depth[v]-depth[u])>>k)&1)==1) {
			   v=parent[k][v];
		   }
	   }
	   if(u==v)return u;
	   //二分探索でLCAを求める
	   for(int k=MAX_LOG-1;k>=0;k--) {
		   if(parent[k][u]!=parent[k][v]) {
			   u=parent[k][u];
			   v=parent[k][v];
		   }
	   }
	   return parent[0][u];
   }
}