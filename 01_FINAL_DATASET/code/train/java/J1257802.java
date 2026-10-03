import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}
	int N;
	int M;
	
	void run(){
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		boolean[][] friends=new boolean[N][N];
		for(int i=0;i<M;i++){
			int x=sc.nextInt()-1;
			int y=sc.nextInt()-1;
			friends[x][y]=true;
		}
		int ret=0;
		for(int i=0;i<(1<<N);i++){
			//この派閥の人数を数える
			int count=0;
			boolean flag=true;
			//任意のペアに対して友達になっているか確認
			for(int a=0;a<N;a++){
				if((i>>a)%2==0)continue;
				count++;
				for(int b=a+1;b<N;b++){
					if((i>>b)%2==0)continue;
					if(!friends[a][b]){
						flag=false;
					}
				}
			}
			if(flag) ret=Math.max(ret,count);
		}
		System.out.println(ret);
	}

}