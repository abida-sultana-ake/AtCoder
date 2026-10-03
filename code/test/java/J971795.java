import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//変数//
		int W;		//右上頂点x座標
		int H;		//右上頂点y座標
		int N;		//長方形内の点の個数
		int minwx;	//白い部分のx座標始まり
		int maxwx;	//白い部分のx座標終わり
		int minwy;	//白い部分のy座標始まり
		int maxwy;	//白い部分のy座標終わり
		int warea;	//白い部分の面積
		
		int[] x;	//点のｘ座標
		int[] y;	//点のy座標
		int[] a;	//指定範囲ルールナンバー
		
		Scanner scan = new Scanner(System.in);
		
		//入力//
		W = scan.nextInt();
		H = scan.nextInt();
		N = scan.nextInt();
		
		x = new int[N];
		y = new int[N];
		a = new int[N];
		
		for(int i = 0; i < N; i++){
			x[i] = scan.nextInt();
			y[i] = scan.nextInt();
			a[i] = scan.nextInt();
		}
		
		scan.close();
		
		//処理//
		//初期処理
		minwx = 0;
		maxwx = W;
		minwy = 0;
		maxwy = H;
		
		//ルールナンバーごとに処理
		for(int j = 0; j < N; j++){
			if( a[j] == 1 && minwx < x[j] ){
				minwx = x[j];
			}else if( a[j] == 2 && maxwx > x[j] ){
				maxwx = x[j];
			}else if( a[j] == 3 && minwy < y[j] ){
				minwy = y[j];
			}else if( a[j] == 4 && maxwy > y[j] ){
				maxwy = y[j];
			}
		}
		
		//白い部分が残っているかどうか判定
		if( minwx >= maxwx || minwy >= maxwy ){
			warea = 0;
		}else{
			warea = (maxwx - minwx) * (maxwy - minwy);
		}
		
		//結果//
		System.out.println(warea);

	}

}
