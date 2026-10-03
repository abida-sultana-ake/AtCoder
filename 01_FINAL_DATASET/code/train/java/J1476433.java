import java.util.Scanner;

/**
 * http://abc015.contest.atcoder.jp/tasks/abc015_4
 * ナップサック問題
 */
public class Main {

	static int N;
	static int[] a;
	static int[] b;
	static int[][][] dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final int W = sc.nextInt();
		N = sc.nextInt();
		final int K = sc.nextInt();
		a = new int[N];
		b = new int[N];
		dp = new int[N+1][W+1][K+1];
		for(int i=0; i<=N; i++)
			for(int j=0; j<=W; j++)
				for(int k=0; k<=K; k++)
					dp[i][j][k] = -1;
		for(int i=0; i<N; i++){
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println(dfs(0,W,K));

	}
	
	static int dfs(int n, int w, int r) {
		if (dp[n][w][r] != -1) {
			return dp[n][w][r];
		}
		int res;
		if (n==N || r==0) {
			res=0;
		}else if(w<a[n]) {
			res = dfs(n+1, w, r);
		}else{
			res = Math.max( dfs(n+1, w, r), dfs(n+1, w-a[n], r-1)+b[n]);
		}
		return dp[n][w][r] = res;
	}

}