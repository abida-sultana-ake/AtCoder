import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] map_size = br.readLine().split(" ");

		String[] start_point = br.readLine().split(" ");

		String[] goal_point = br.readLine().split(" ");

		int[][] map_count = new int[Integer.parseInt(map_size[0]) + 1][Integer.parseInt(map_size[1]) + 1];
		boolean[][] map_visisted = new boolean[Integer.parseInt(map_size[0]) + 1][Integer.parseInt(map_size[1]) + 1];

		char[][] map = new char[Integer.parseInt(map_size[0]) + 1][Integer.parseInt(map_size[1]) + 1];

		for (int i = 1; i <= Integer.parseInt(map_size[0]); i++) {
			String s = br.readLine();
			for (int k = 1; k <= Integer.parseInt(map_size[1]); k++) {

				map[i][k] = s.charAt(k - 1);

			}
		}
/*		for (int i = 1; i <= Integer.parseInt(map_size[0]); i++) {
			for (int k = 1; k <= Integer.parseInt(map_size[1]); k++) {

				System.out.print(map[i][k]);

			}
			System.out.println("");
		}*/

/*		map[Integer.parseInt(goal_point[0])][Integer.parseInt(goal_point[1])] = 'g';
*/
		Deque<points> dq = new ArrayDeque<>();

		dq.offer(new points(Integer.parseInt(start_point[1]), Integer.parseInt(start_point[0]), 0));
		map_count[Integer.parseInt(start_point[0])][Integer.parseInt(start_point[1])] = 0;
		map_visisted[Integer.parseInt(start_point[0])][Integer.parseInt(start_point[1])] = true;

		int[] x_direction = { 1, 0, -1, 0 };
		int[] y_direction = { 0, 1, 0, -1 };
		while (!(dq.isEmpty())) {
			points p = dq.poll();

			int x = p.x;
			int y = p.y;
			map_count[y][x] = p.count;
/*
			System.out.println(x + "" + y);
*/
			for (int i = 0; i < 4; i++) {
				int nx = x + x_direction[i];
				int ny = y + y_direction[i];
				if (nx >= 1 && nx <= Integer.parseInt(map_size[1]) && ny >= 1 && ny <= Integer.parseInt(map_size[0])
						&& map[ny][nx] != '#' && !map_visisted[ny][nx]) {
				/*	System.out.println("x" + nx + "y" + ny);*/
					dq.offer(new points(nx, ny, map_count[y][x] + 1));
					map_visisted[ny][nx] = true;
					map[ny][nx] = '1';
				}

			}
/*			for (int i = 1; i <= Integer.parseInt(map_size[0]); i++) {
				for (int k = 1; k <= Integer.parseInt(map_size[1]); k++) {

					System.out.print(map[i][k]);

				}
				System.out.println("");
			}*/

		}
		System.out.println(map_count[Integer.parseInt(goal_point[0])][Integer.parseInt(goal_point[1])]);

	}

	static class points {
		int x;
		int y;
		int count;

		public points(int a, int b, int c) {
			this.x = a;
			this.y = b;
			this.count = c;
		}
	}
}