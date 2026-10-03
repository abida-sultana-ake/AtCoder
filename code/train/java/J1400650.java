import java.util.Scanner;

public class Main{
	
	public static boolean dfs(int x, char[][] board){
		if(x == 8)
			return true;
		int key = -1;
		for(int i=0;i<8;i++){
			if(board[x][i] == 'Q'){
				if(key!=-1) return false;
				key = i;
			}
		}
		if(key!=-1){
			if(Sure(x,key,board)){
				if(dfs(x+1,board))return true;
			}
		}
		else {
			for(int i=0;i<8;i++){
				if(Sure(x,i,board)){
					board[x][i] = 'Q';
					if(dfs(x+1,board)) return true;
					else board[x][i] ='.';
				}
			}
		}
		return false;
	}

	public static boolean Sure(int a, int b,char[][] board) {
		for(int i=-1;i<=1;i++){
			for(int j=-1;j<=1;j++){	
				if(i==0 && j==0) continue;	
				int c = a;
				int d = b;
				while(true){
					c = c + i;
					d = d + j;
					if(c<0||c>=8||d<0||d>=8) break;
					if(board[c][d]=='Q') return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char[][] board = new char[8][8];
		for(int i=0;i<8;i++){
			String S = sc.next();
			for(int j=0;j<8;j++){
				board[i][j] = S.charAt(j);
			}
		}
		System.out.println();
		if(dfs(0, board)){
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
		}else{
			System.out.println("No Answer");
		}
	}
}