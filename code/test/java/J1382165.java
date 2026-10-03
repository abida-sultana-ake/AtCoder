import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int N = sc.nextInt();
		int ans=0;
		int outer=0;
		
		while(N>0){
			//売る
			ans+=N;
			//素材をまとめる
			N+=outer;
			//まとめたから無くなる
			outer=0;
			//使わない素材を計算する
			outer+=N;
			//次ぎ売れるやつ
			N/=m;
			//使った素材を減らす
			outer-=N*m;
			//売れるやつ
			N*=n;
			//System.out.println(N);
		}
		System.out.println(ans);
	}
	
	
	
}