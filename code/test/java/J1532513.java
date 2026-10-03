
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		abc012_4(scan);
	}
	
	static void abc012_3(Scanner scan) {
		int n = scan.nextInt();
		
		int rest = 2025 - n;
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				if(rest == i * j) {
					System.out.print(i);
					System.out.print(" x ");
					System.out.println(j);
				}
			}
		}
	}
	
	static void abc012_4(Scanner scan) {
		final int N = scan.nextInt(); //バス停の数
		final int M = scan.nextInt(); //路線の数
		
		// 初期化処理 - バス停2点間の距離を表すdistance配列を用意
		// distance[1][2] = 3 means "it takes 3 minutes from 1 to 2"
		int[][] distance = new int[N+1][N+1];
		
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				// 初期化処理 - 初期値として想定し得ない大きな値を設定
				distance[i][j] = Integer.MAX_VALUE / 2; // 割る理由は後の処理で２倍するため
			}
			// 初期化処理 - 同じバス停への距離を0に設定
			distance[i][i] = 0;
		}
		for (int i = 1; i < N+1; i++) {
			
		}
		
		
		// 初期化処理 - 指定されたバス停2点間の距離を設定
		for (int i = 0; i < M; i++) {
			int a_i = scan.nextInt(); // BusStop1
			int b_i = scan.nextInt(); // BusStop2
			int d_i = scan.nextInt(); // Distance from BusStop1 to BusStop2
			
			
			distance[a_i][b_i] = distance[b_i][a_i] = d_i;
		}
		
		// 評価 - バス停2点間の最も短い経路を算出
		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}
		
		int shortestTime = Integer.MAX_VALUE;
		for (int i = 1; i < N+1; i++) {
			// 評価　- あるバス停から最も時間がかかるバス停への時間を算出
			int longestTime = 0;
			for (int j = 1; j < N+1; j++) {
				if(distance[i][j] > longestTime) {
					longestTime = distance[i][j];
				}
			}
			// 評価 - 各バス停ごとの最長時間の中での最短時間を算出
			if(longestTime < shortestTime) {
				shortestTime = longestTime;
			}
		}
		System.out.print(shortestTime);
	}

}
