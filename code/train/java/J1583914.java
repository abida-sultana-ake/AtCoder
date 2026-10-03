import java.util.Scanner;

public class Main {
	private static int[][] nArray = new int[201][201];
	private static int[] rArray = new int[9];
	private static boolean[] usedArray = new boolean[9];
	private static int N = 0;
	private static int M = 0;
	private static int R = 0;
	private static int result = 999999999;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				nArray[i][j] = 999999999;
			}
		}
		for (int i = 1; i <= R; i++) {
			rArray[i] = sc.nextInt();
		}
		for (int i = 1; i <= M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			nArray[A][B] = C;
			nArray[B][A] = C;
		}
		sc.close();
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (nArray[i][k] != 999999999 && nArray[k][j] != 999999999) {
						if (nArray[i][j] == 999999999 || nArray[i][j] > nArray[i][k] + nArray[k][j]) {
							nArray[i][j] = nArray[i][k] + nArray[k][j];
						}
					}
				}
			}
		}
		
		dfs(1, -1, 0);
		System.out.println(result);
	}
	
	private static void dfs(int c, int las, int dist) {
		if (c == R + 1) {
			if (result > dist)
				result = dist;
			return;
		}
		for (int i = 1; i <= R; i++)
			if (!usedArray[i]) {
				usedArray[i] = true;
				if (las == -1)
					dfs(c + 1, i, 0);
				else
					dfs(c + 1, i, dist + nArray[rArray[las]][rArray[i]]);
				usedArray[i] = false;
			}
	}
}