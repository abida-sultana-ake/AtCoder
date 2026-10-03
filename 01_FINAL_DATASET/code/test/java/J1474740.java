import java.util.Scanner;

public class Main {
public static void main(String[] args) 
{	
	Scanner sc = new Scanner(System.in);
	
	//店の前を通りがかった人数
	int num;
	//人が通りがかった後にドアが開き続ける時間
	int time;
	//自動ドアが開いていた合計の秒数
	int ans;
	
	//設定
	num = sc.nextInt();
	time = sc.nextInt();
	ans=0;
	
	//0人目の客が通りがかった時間（ダミー）
	int timeP = -time;
	ans = 0;
	
	//2人目以降の計算
	for(int i = 1 ; i <= num ; i++)
	{
		//i人目の客が通りがかった時間
		int timeI = sc.nextInt();
		
		//前の客（i-1人目）との時間差がtime秒以下の時
		if(timeI - timeP < time)
		{
			//差のみ合計時間に計上
			ans += timeI - timeP;
		}
		else
		{
			//合計時間にtime計上
			ans += time;
		}
		
		timeP=timeI;
	}
	
	System.out.println(ans);
}
}
