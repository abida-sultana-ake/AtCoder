import java.util.Scanner;

public class Main {

	static int D;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		D = sc.nextInt();
		int K = sc.nextInt();

		int[][] movePlan = new int[D][2];
		for(int i = 0; i < D; i++) {
			movePlan[i][0] = sc.nextInt();	// i日目はここから
			movePlan[i][1] = sc.nextInt();	// ここまで移動可能
		}

		int[][] sgs = new int [K][2];
		for(int i = 0; i < K; i++) {
			sgs[i][0] = sc.nextInt();
			sgs[i][1] = sc.nextInt();
		}

		sc.close();

		for(int[] sg : sgs) {
			int ans = donyoku(movePlan, sg[0], sg[1]);

			System.out.println(ans);
		}

	}

	private static int donyoku(int[][] movePlan, int now, int goal) {

		boolean goUp = now<goal;
		int index = goUp ? 1 : 0;

		int ans = -1;

		for(int i=0; i<D; i++) {

			if(movePlan[i][0] <= now && now <= movePlan[i][1]) {

				now = movePlan[i][index];

				if( (goUp && now >= goal) || (!goUp && now <= goal) ) {
					ans = i+1;
					break;
				}

			}
		}

		return ans;

	}
}