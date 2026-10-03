import java.util.LinkedList;
import java.util.Scanner;

public class Main{
	static int n;
	static long dp[][],mod=1000000007;
	static LinkedList<Integer>[] g;
	static long cal(int x,int y){
		dp[x][0]=1; dp[x][1]=1;
		for(int e:g[x]){
			if(e!=y){
				cal(e,x);
				dp[x][0]*=(dp[e][0]+dp[e][1])%mod; dp[x][0]%=mod;
				dp[x][1]*=dp[e][0]; dp[x][1]%=mod;
			}
		}
		return (dp[x][0]+dp[x][1])%mod;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			n=sc.nextInt();
			g=new LinkedList[n];
			dp=new long[n][2];
			for(int i=0;i<n;i++) g[i]=new LinkedList<Integer>();
			for(int i=0;i<n-1;i++){
				int a=sc.nextInt(); a--;
				int b=sc.nextInt(); b--;
				g[a].add(b);
				g[b].add(a);
			}
			System.out.println(cal(0,-1)%mod);
		}
	}
}