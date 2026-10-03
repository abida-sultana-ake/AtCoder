import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] D = new int[N][N];
		int[][] sumd = new int[N+1][N+1];


		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				D[i][j]=scan.nextInt();
				if(j==N-1){
					sumd[i][j]=D[i][j];
				}
			}
		}

		int sum=0;
		for(int i=0;i<N;i++){
			for(int j=1;j<N+1;j++){
				sumd[i][N-j]=sumd[i][N-j+1]+D[i][N-j];
/*				for(int k=j;k<N;k++){
					sum+=D[i][k];
					sumd[i][j].add(sum);
				}*/
			}
		}


		int[] max = new int[N*N+1];
		int erea=0;

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				//(N-i)(N-j)の長方形の最大を求める
				for(int k=0;k<i+1;k++){
					for(int l=0;l<j+1;l++){
						//左上から求めていく
						//

						for(int m=0;m<N-i;m++){
							erea +=sumd[k+m][l] -sumd[k+m][l+N-j];
						}
						if(erea>max[(N-i)*(N-j)]){
							max[(N-i)*(N-j)]=erea;
						}
						erea=0;
					}
				}




			}
		}

		int ereamax=0;
		for(int i=0;i<N*N+1;i++){
			if(max[i]>ereamax){
				ereamax=max[i];
			}else{
				max[i]=ereamax;
			}
		}

//		int ereap=0;
		int Q = scan.nextInt();
		for(int i=0;i<Q;i++){
			int P = scan.nextInt();

			System.out.println(max[P]);
		}


	}

}

class SumD extends ArrayList<Integer>{

}
