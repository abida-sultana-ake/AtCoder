import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	int n, m;
	List<Integer>[] e;
	long[] dp;

	long dp(int bit, int k) {
		if (bit == 0) {
			return dp[bit] = 1;
		}
		if (0 <= dp[bit]) {
			return dp[bit];
		}

		long ret = 0;
		L: for (int i = 0; i < n; i++) {
			if ((bit & (1 << i)) == 0) {
				continue L;
			}
			for (Integer nei : e[i]) {
				if (0 < (bit & (1 << nei))) {
					continue L;
				}
			}
			ret += dp(bit ^ (1 << i), k + 1);
		}
		return dp[bit] = ret;
	}

	void run() {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		e = new List[n];
		for (int i = 0; i < n; i++) {
			e[i] = new LinkedList<Integer>();
		}
		for (int j = 0; j < m; j++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			e[x].add(y);
		}
		dp = new long[(1 << n) + 1];
		Arrays.fill(dp, -1);
		System.out.println(dp((1 << n) - 1, 0));
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
