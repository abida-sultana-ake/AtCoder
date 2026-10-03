import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Printer pr = new Printer(System.out);

		final int MOD = 1_000_000_007;

		int h = sc.nextInt();
		int w = sc.nextInt();
		int[][] a = new int[h][w];
		dp = new int[h][w];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		int ret = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				ret = (ret + dfs(i, j, h, w, a, MOD)) % MOD;
			}
		}

		pr.println(ret);

		pr.close();
		sc.close();
	}

	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static int[][] dp;

	private static int dfs(int i, int j, int h, int w, int[][] a, int MOD) {
		if (dp[i][j] > 0) {
			return dp[i][j];
		}

		Deque<Integer> stx = new ArrayDeque<>();
		Deque<Integer> sty = new ArrayDeque<>();
		stx.push(j);
		sty.push(i);

		while (!stx.isEmpty()) {
			int x = stx.peek();
			int y = sty.peek();

			boolean flag = true;
			int ret = 1;
			for (int k = 0; k < dx.length; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
					continue;
				}

				if (a[ny][nx] <= a[y][x]) {
					continue;
				}

				if (dp[ny][nx] > 0) {
					ret = (ret + dp[ny][nx]) % MOD;
				} else {
					flag = false;
					stx.push(nx);
					sty.push(ny);
				}
			}

			if (flag) {
				dp[y][x] = ret;
				stx.pop();
				sty.pop();
			}
		}

		return dp[i][j];
	}

	@SuppressWarnings("unused")
	private static class Scanner {
		BufferedReader br;
		Iterator<String> it;

		Scanner (InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		String next() throws RuntimeException  {
			try {
				if (it == null || !it.hasNext()) {
					it = Arrays.asList(br.readLine().split(" ")).iterator();
				}
				return it.next();
			} catch (IOException e) {
				throw new IllegalStateException();
			}
		}

		int nextInt() throws RuntimeException {
			return Integer.parseInt(next());
		}

		long nextLong() throws RuntimeException {
			return Long.parseLong(next());
		}

		float nextFloat() throws RuntimeException {
			return Float.parseFloat(next());
		}

		double nextDouble() throws RuntimeException {
			return Double.parseDouble(next());
		}

		void close() {
			try {
				br.close();
			} catch (IOException e) {
//				throw new IllegalStateException();
			}
		}
	}

	private static class Printer extends PrintWriter {
		Printer(PrintStream out) {
			super(out);
		}
	}
}
