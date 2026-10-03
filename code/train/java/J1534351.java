import java.util.Scanner;

public class Main {

	static int N;
	static int[] widths;
	static int[] values;
	static int[][][] dp;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int W = s.nextInt();
		N = s.nextInt();
		int K = s.nextInt();

		widths = new int[N];
		values = new int[N];

		for (int i = 0; i < N; i++) {
			widths[i] = s.nextInt();
			values[i] = s.nextInt();
		}

		s.close();

		dp = new int[N+1][K+1][W+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				for(int k = 0; k < dp[i][j].length; k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		System.out.println(dfs(0, K, W));

	}

	private static int dfs(int now, int nokoriNum, int nokoriWidth) {

		if(dp[now][nokoriNum][nokoriWidth] != -1) {
			return dp[now][nokoriNum][nokoriWidth];
		}

		int result;

		// 入れるものを検討しつくしたか、個数の余裕がなくなった
		if(now == N || nokoriNum == 0) {
			result = 0;

		// 今検討中のスクショは残り幅的に使えない
		} else if(nokoriWidth < widths[now]) {
			result = dfs(now+1, nokoriNum, nokoriWidth);

		// 今検討中のスクショを使った場合か使わなかった場合かで
		// それぞれ以降のスクショまで検討、価値が大きいほうを採用
		} else {
			result = Math.max(
					dfs(now+1, nokoriNum-1, nokoriWidth-widths[now]) + values[now],
					dfs(now+1, nokoriNum, nokoriWidth));
		}

		// メモ化
		dp[now][nokoriNum][nokoriWidth] = result;
		return result;

	}

}