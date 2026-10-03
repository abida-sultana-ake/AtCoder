import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M =scan.nextInt();
		int a[][]= new int[N+1][N+1];
		int count =0;
		int c =0;
		int v[] = new int[N+1];
		v[1]=1;
		int red = 0;
		for(int i=0;i<M;i++){
			a[scan.nextInt()][scan.nextInt()]=1;
		}
		for(int i=0;i<N+1;i++){
			for(int j=0;j<i;j++){
				a[i][j]=a[j][i];
			}
		}
		c = dfs(1,N,count,red,a,v);
		System.out.println(c);
	}
	
	public static int dfs(int l,int N,int t,int red,int a[][],int v[]){
		if(red==N-1){
			t++;
		}for(int j=1;j<=N;j++){
			if(a[l][j]==1 && v[j]==0){
				v[j]=1;
				red++;
				t = dfs(j,N,t,red,a,v);
				v[j]=0;
				red--;
			}
		}return t;
	}
}