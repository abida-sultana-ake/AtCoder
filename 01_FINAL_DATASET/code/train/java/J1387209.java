import java.util.Scanner;

public class Main {
	public static int flag = 0;

	public static boolean isPuttable(int memo_x, int memo_y, String[] chess) {
		for (int i = 0; i < 8; i++) {
			if (i == memo_y)
				continue;
			if (chess[i].charAt(memo_x) == 'Q')
				return false;
		}
		for (int i = 0; i < 8; i++) {
			if (i == memo_x)
				continue;
			if (chess[memo_y].charAt(i) == 'Q')
				return false;
		}
		for (int i = 1; i < 8; i++) {
			if (memo_x - i >= 0 && memo_y - i >= 0) {
				if (chess[memo_y - i].charAt(memo_x - i) == 'Q') {
					return false;
				}
			}
			if (memo_x + i < 8 && memo_y - i >= 0) {
				if (chess[memo_y - i].charAt(memo_x + i) == 'Q') {
					return false;
				}
			}
			if (memo_x - i >= 0 && memo_y + i < 8) {
				if (chess[memo_y + i].charAt(memo_x - i) == 'Q') {
					return false;
				}
			}
			if (memo_x + i < 8 && memo_y + i < 8) {
				if (chess[memo_y + i].charAt(memo_x + i) == 'Q') {
					return false;
				}
			}
		}
		return true;

	}

	public static boolean dfs(int n, String[] chess) {
		int memo_x = -1, memo_y = -1;
		if (n == 8) {
			flag = 1;
		} else {
			for (int i = 0; i < 8; i++) {
				if (chess[n].charAt(i) == 'Q') {
					memo_x = i;
					memo_y = n;
				}
			}
			if (memo_x != -1) {
				if (isPuttable(memo_x, memo_y, chess)) {
					if (dfs(n + 1, chess))
						return true;
				}
			} else {
				for (int i = 0; i < 8; i++) {
					if (isPuttable(i, n, chess)) {
						String line1 = chess[n].substring(0, i);
						String line2 = chess[n].substring(i + 1, 8);
						chess[n] = line1 + "Q" + line2;
						if (dfs(n + 1, chess))
							return true;
						else {
							line1 = chess[n].substring(0, i);
							line2 = chess[n].substring(i + 1, 8);
							chess[n] = line1 + "." + line2;
						}
					}
				}
			}
		}
		if (flag == 1)
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] chess = new String[8];
		for (int i = 0; i < 8; i++) {
			chess[i] = sc.nextLine();
		}
		if (dfs(0, chess)) {
			for (int i = 0; i < 8; i++) {
				System.out.println(chess[i]);
			}
		} else {
			System.out.println("No Answer");
		}

	}
}