import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int H,W;
	static long[][]dp;
	static long[][]a;
	static int MOD=1000000007;
	static int[] vx={0,1,0,-1};
	static int[] vy={-1,0,1,0};

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		H=Integer.parseInt(sc.next());
		W=Integer.parseInt(sc.next());
		a=new long[H][W];
		dp=new long[H][W];
		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++){
				a[i][j]=Integer.parseInt(sc.next());
			}
		}
		long sum=0;
		
		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++){
				sum=(sum+dfs(i,j))%MOD;
			}
		}
		System.out.println(sum);
	}
	static long dfs(int i,int j){
		
		if(dp[i][j]>0){
			return dp[i][j];
		}
		
		dp[i][j]=1;
		
		for(int k=0;k<4;k++){
			int xs=j+vx[k];
			int ys=i+vy[k];
			
			if(xs>=0 && xs<W && ys>=0 && ys<H && a[i][j]<a[ys][xs]){
					dp[i][j]=(dp[i][j]+dfs(ys,xs))%MOD;
				}
			}
		return dp[i][j];
	}
}
