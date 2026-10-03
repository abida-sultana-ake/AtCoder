import java.util.Scanner;

public class Main {

	static int[] ini;
	static long[][][] dp;

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner scan = new Scanner(System.in);
		int N=scan.nextInt();

		dp= new long[10][10][2];//[今見てる桁][それまでにいくつ1があったか][未満確定か]
		int cnt=0;
		ini = new int[9];
		for(int i=0;i<9;i++){
			ini[8-i]=N%10;
			N/=10;
			if(N!=0){
				cnt++;
			}
		}
		scan.close();

//未満未確定、0
		dp[0][0][0]=1;
		for(int i=0;i<9;i++){//~10^8 =9桁
			int D=ini[i];
			for(int j=0;j<9;j++){
				for(int k=0;k<2;k++){
					for(int l=0;l<10;l++){
						if(k==0){
							//未満未確定
							if(l>D){continue;}
							else if(l==D){
								if(l==1){
									dp[i+1][j+1][k] +=dp[i][j][k];
								}else{
									dp[i+1][j][k]+=dp[i][j][k];
								}
							}else{
								if(l==1){
									dp[i+1][j+1][1] +=dp[i][j][k];
								}else{
									dp[i+1][j][1] +=dp[i][j][k];
								}
							}
						}else{
							//未満確定
							if(l==1){
								dp[i+1][j+1][k]+=dp[i][j][k];
							}else{
								dp[i+1][j][k]+=dp[i][j][k];
							}
						}
					}
				}
			}
		}

		int ans=0;
		for(int i=0;i<10;i++){
			ans+=i*dp[9][i][0];
			ans+=i*dp[9][i][1];
		}


		System.out.println(ans);

	}
}

//最後の数え上げで iをかけるのを忘れていた
//結局dpで数え上げられるのは1~Nの数のみ、現れる数字の数などは積で考える
