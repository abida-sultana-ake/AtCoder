import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int totalValue = 0;
		int[] zougenList = new int[M+2];

		for(int i=1; i<=N; i++) {
			
			int l = sc.nextInt();	// 宝石の番号:これ以上
			int r = sc.nextInt();	// 宝石の番号:これ以下
			int s = sc.nextInt();	// 獲得得点

			zougenList[l] += s;
			zougenList[r + 1] -= s;
			totalValue += s;
		
		}
		sc.close();

		int min = Integer.MAX_VALUE;
		for(int i=1; i<=M; i++) {

			zougenList[i+1] = zougenList[i] + zougenList[i+1];
			min = Math.min(min, zougenList[i]);

		}

		System.out.println(totalValue - min);

	}

}