import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan =new Scanner(System.in);
		Kunou kunou=new Kunou(scan);
		System.out.println(kunou.rec(kunou.N, kunou.W, kunou.K));
	}

}

class Kunou{
	int W;
	int N;
	int K;
	int[] A;
	int[] B;
	int[][][] dp;
	int res;

	Kunou(Scanner scan){
		W=scan.nextInt();
		N=scan.nextInt();
		K=scan.nextInt();
		A=new int[N];
		B=new int[N];
		for(int i=0;i<N;i++){
			A[i]=scan.nextInt();
			B[i]=scan.nextInt();
		}
		dp=new int[N+1][W+1][K+1];
	}


	int rec(int i,int j,int k){
		if(i==0){
			return 0;
		}
		if(dp[i][j][k]!=0){
			return dp[i][j][k];
		}

		if(j-A[i-1]>=0&&k-1>=0){
			res=Math.max(rec(i-1,j,k), rec(i-1,j-A[i-1],k-1)+B[i-1]);
		}else{
			res=rec(i-1,j,k);
		}
		return dp[i][j][k]=res;
	}
}