import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		//CDに番号付け
		int nowPlaying = 0;
		int [] CDCase = new int[n];
		for (int i = 0 ; i < n ; i++)  CDCase[i] = i + 1;
		
		//CD聞く枚数分入れ替え操作
		for (int i = 0 ; i < m ; i++) {
			//目的のCD番号取得
			int targetCD = scanner.nextInt();
			int targetCase = -1;
			//目的のCD探す
			for (int j = 0 ; j < n ; j++) {
				if (CDCase[j] == targetCD) {
					targetCase = j; break;
				}
			}
			//前のCDと同じなら何もしない
			if (targetCase == -1) continue;
			//入れ替え操作
			CDCase[targetCase] = nowPlaying;
			nowPlaying = targetCD;
		}
		//出力
		for (int i = 0 ; i < n ; i ++) {
			System.out.println(CDCase[i]);
		}
	}
}