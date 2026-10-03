import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	int[][]b;
	int[][]c;
	int[][] board=new int[3][3];
	int sum=0;
	
	void solve(){
		Scanner sc=new Scanner(System.in);
		b=new int[2][3];
		c=new int[3][2];
		for(int i=0;i<2;i++){
			for(int j=0;j<3;j++){
				b[i][j]=sc.nextInt();
				sum+=b[i][j];
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<2;j++){
				c[i][j]=sc.nextInt();
				sum+=c[i][j];
			}
		}
		board=new int[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				board[i][j]=-1;
			}
		}
		
		int s=dfs(0);
		System.out.println(s);
		System.out.println(sum-s);
	}
	
	int dfs(int t){
		if(t==9)return score();
		int ret=(t%2==0)?0:sum;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[i][j]==-1){
					board[i][j]=t%2;
					ret=(t%2==0)?Math.max(ret, dfs(t+1)):Math.min(ret, dfs(t+1));
					board[i][j]=-1;
				}
			}
		}
		return ret;
	}
	
	int score(){
		int s=0;
		for(int i=0;i<2;i++){
			for(int j=0;j<3;j++){
				if(board[i][j]==board[i+1][j] && board[i][j]!=-1){
					s+=b[i][j];
				}
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<2;j++){
				if(board[i][j]==board[i][j+1] && board[i][j]!=-1){
					s+=c[i][j];
				}
			}
		}
		return s;
	}
}