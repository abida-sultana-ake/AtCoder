import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static int r;
	static int c;
	static int sy;
	static int sx;
	static int gy;
	static int gx;
	static int[][] m;
	static int[] x = { 0, 1, 0, -1 };
	static int[] y = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		r = scan.nextInt();
		c = scan.nextInt();
		sy = scan.nextInt();
		sx = scan.nextInt();
		gy = scan.nextInt();
		gx = scan.nextInt();

		m = new int[r + 2][c + 2];

		for (int i = 1; i <= r; i++) {
			String temp = scan.next();
			for (int j = 1; j <= c; j++) {
				if (temp.charAt(j - 1) == '.') {
					m[i][j] = -1;
				} else {
					m[i][j] = -2;
				}

			}
		}
		m[sy][sx] = 0;
		bfs(sy, sx);
		int ans = Integer.MIN_VALUE;

		ans = m[gy][gx];
		System.out.println(ans);

	}

	static void bfs(int ny, int nx) {
		Deque<Integer> qy = new ArrayDeque<Integer>();
		Deque<Integer> qx = new ArrayDeque<Integer>();
		qy.offer(ny);
		qx.offer(nx);
		while (!qy.isEmpty() && !qx.isEmpty()) {
			int tempX = qx.poll();
			int tempY = qy.poll();

			for (int i = 0; i < 4; i++) {
				if (m[tempY + y[i]][tempX + x[i]] == -1) {
					m[tempY + y[i]][tempX + x[i]] = m[tempY][tempX] + 1;
					qy.offer(tempY + y[i]);
					qx.offer(tempX + x[i]);
				}
			}

		}

	}
}