import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args){
        new Main().solve();
    }
    int n,m,R;
    int[]r;
    int[]a;
    int[]b;
    long[]c;
    long[][]path;
    void solve() {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        R=sc.nextInt();
        r=new int[R];
        for(int i=0;i<R;i++) {
        	r[i]=sc.nextInt()-1;
        }
        a=new int[m];
        b=new int[m];
        c=new long[m];
        path=new long[n][n];
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(i==j)path[i][j]=0;
        		else path[i][j]=Long.MAX_VALUE/2;
        	}
        }
        for(int i=0;i<m;i++) {
        	a[i]=sc.nextInt()-1;
        	b[i]=sc.nextInt()-1;
        	c[i]=sc.nextLong();
        	path[a[i]][b[i]]=c[i];
        	path[b[i]][a[i]]=c[i];
        }

        for(int k=0;k<n;k++) {
        	for(int i=0;i<n;i++) {
        		for(int j=0;j<n;j++) {
        			path[i][j]=Math.min(path[i][j], path[i][k]+path[k][j]);
        		}
        	}
        }
        
        visited=new boolean[R];
        long min_cost=Long.MAX_VALUE/2;
        
        for(int i=0;i<R;i++) {
        	count=0;
        	Arrays.fill(visited, false);
        	visited[i]=true;
        	cost=0;
        	min=Long.MAX_VALUE/2;
        	dfs(i);
        	min_cost=Math.min(min_cost, min);
        }
        System.out.println(min_cost);
    }
    
    boolean[] visited;
    long cost=0;
    long min=Long.MAX_VALUE/2;
    int count=0;
    
    void dfs(int n) {
    	if(count==R-1)min=Math.min(cost, min);
    	long p=0;
    	for(int i=0;i<R;i++) {
    		if(!visited[i]) {
    			p=path[r[n]][r[i]];
    			visited[i]=true;
    			cost+=p;
    			count++;
    			dfs(i);
    			
    			visited[i]=false;
    			cost-=p;
    			count--;
    		}
    	}
    }
}
