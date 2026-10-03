import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan=new Scanner(System.in);

		long A=scan.nextLong()-1;
		long B=scan.nextLong();

		Banned banA = new Banned(A);
		Banned banB = new Banned(B);

		System.out.println(banB.bannednum()-banA.bannednum());


	}

}

class Banned{
	int[] d;
	long[][][] dp;//決定した桁数,N未満が確定か？,4or9を含むか？

	Banned(long N){
		d=new int[19];
		dp=new long[20][2][2];
			for(int j=0;j<19;j++){
				d[18-j]=(int)(N%10);
				N/=10;
			}

/*			for(int i=0;i<19;i++){
				System.out.print(d[i]+" ");
			}
			System.out.println();*/
		//d[][]={0,0,0,0,0,0,2,3,4,5,5...}
	}

	long bannednum(){
		dp[0][0][0]=1;

		for(int i=0;i<19;i++){
			//桁ループ
			int D=d[i];
			for(int j=0;j<2;j++){
				for(int k=0;k<2;k++){

					for(int m=0;m<10;m++){
						if(j==1){//N未満確定
							if(k==1){
								dp[i+1][j][k]+=dp[i][j][k];
							}else{
								if(m==4||m==9){
									dp[i+1][j][1]+=dp[i][j][k];
								}else{
									dp[i+1][j][k]+=dp[i][j][k];
								}
							}
						}else{
							//N未満が未確定
							if(m>D){
								continue;
							}else if(m==D){
								if(m==4||m==9){
									dp[i+1][0][1] +=dp[i][j][k];
								}else{
									dp[i+1][0][k]+=dp[i][j][k];
								}
							}else{
								//N未満が確定になる
								if(m==4||m==9){
									dp[i+1][1][1]+=dp[i][j][k];
								}else{
									dp[i+1][1][k]+=dp[i][j][k];
								}
							}

						}
				}

					//System.out.println(dp[i][j][k]);
			}
			}


		}
		return dp[19][0][1]+dp[19][1][1];
	}

}