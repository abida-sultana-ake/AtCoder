import java.util.Scanner;

public class Main {

	static boolean dfs(int y, char[][] board) {
		if (y == 8)
			return true;
		int target = -1;

		for (int i = 0; i < 8; i++) {
			if (board[y][i] == 'Q') {
				if (target == -1)
					target = i;
				else
					return false;
			}
		}

		if (target != -1) {
			if (isPuttable(y, target, board) && dfs(y + 1, board)) {
				return true;
			}
		} else {
			for (int i = 0; i < 8; i++) {
				if (isPuttable(y, i, board)) {
					board[y][i] = 'Q';
					if (dfs(y + 1, board))
						return true;
					else
						board[y][i] = '.';
				}
			}
		}
		return false;
	}

	static boolean isPuttable(int y, int x, char[][] board) {
		for (int vy = -1; vy <= 1; vy++) {
			for (int vx = -1; vx <= 1; vx++) {
				if (vy == 0 && vx == 0)
					continue;
				int ty = y;
				int tx = x;
				while (true) {
					ty += vy;
					tx += vx;
					if (ty < 0 || ty >= 8 || tx < 0 || tx >= 8)
						break;
					if (board[ty][tx] == 'Q')
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[][] board = new char[8][8];
		for (int i = 0; i < 8; i++) {
			String st = scanner.next();
			for (int j = 0; j < 8; j++) {
				board[i][j] = st.charAt(j);
			}
		}
		if (dfs(0, board)) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
		} else {
			System.out.println("No Answer");
		}
	}

}