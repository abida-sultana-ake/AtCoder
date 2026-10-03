import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Main {
	int H;
	int W;
	
	void run(){
		Scanner sc=new Scanner(System.in);
		H=sc.nextInt();
		W=sc.nextInt();
		String[] board=new String[H];
		for(int i=0;i<H;i++){
			board[i]=sc.next();
		}
		
		//sの場所を探す
		int fx=-1;
		int fy=-1;
		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++){
				if(board[i].charAt(j)=='s'){
					fy=i;
					fx=j;
				}
			}
		}
		//初期状態の挿入
		Queue<Integer> nowq=new LinkedList<Integer>();
		nowq.add(encode(fy,fx));
		
		//移動先の列挙
		int[] vy=new int[]{1,0,-1,0};
		int[] vx=new int[]{0,1,0,-1};
		
		//到達したかどうかのチェック用
		boolean[][] check=new boolean[H][W];
		check[fy][fx]=true;
		
		//幅優先探索を3回繰り返す
		for(int i=0;i<3;i++){
			
			//破壊した壁を入れるキュー
			Queue <Integer> nextq=new LinkedList<Integer>();
			
			//幅優先探索
			while(!nowq.isEmpty()){
				//現在の位置を取ってくる
				int now=nowq.poll();
				int y=now/1000;
				int x=now%1000;
				
				//4方向に移動できるので、それぞれの移動先を調べる
				for(int j=0;j<4;j++){
					int ny=y+vy[j];
					int nx=x+vx[j];
					
					//範囲外だったらcontinue
					if(!ok(ny,nx))continue;
					//既に調べてあるマスだったらcontinue
					if(check[ny][nx])continue;
					
					//調査済みフラグを立てる
					check[ny][nx]=true;
					
					//ゴールなら終了
					if(board[ny].charAt(nx)=='g'){
						System.out.println("YES");
						return;
					}
					//壁なら壁用キューに入れる
					else if(board[ny].charAt(nx)=='#'){
						nextq.add(encode(ny,nx));
					}
					//それ以外なら通常のキューに入れる
					else{
						nowq.add(encode(ny,nx));
					}
				}
			}
			//次のキューに、壁を破壊したキューを移し替える
			nowq=nextq;
		}
		//sにたどり着けなかったらNO
		System.out.println("NO");
		return;
	}
	
	//座標を一つの整数に変換する
	int encode(int y,int x){
		return y*1000+x;
	}
	
	//範囲内に収まっているかチェック
	boolean ok(int y,int x){
		return y>=0 && x>=0 && y<H && x<W;
	}

	 public static void main(String[] args) {
		new Main().run();
	}

}