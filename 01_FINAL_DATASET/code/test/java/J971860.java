import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		solve(s);
		s.close();
	}

	public static void solve(Scanner s) {
		int W = s.nextInt();
		int H = s.nextInt();
		int N = s.nextInt();
		boolean[][] rect = new boolean[W][H];
		for (boolean[] array : rect) {
			Arrays.fill(array, true);
		}

		for (int i = 0; i < N; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			int a = s.nextInt();

			paint(rect, x, y, a);
		}

		int count = 0;
		for (int i = 0; i < rect.length; i++) {
			for (int j = 0; j < rect[i].length; j++) {
				if (rect[i][j]) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

	public static void paint(boolean[][] rect, int x, int y, int a) {
		switch (a) {
		case 1:
			for (int i = 0; i < rect.length; i++) {
				for (int j = 0; j < rect[i].length; j++) {
					if (i < x) {
						rect[i][j] = false;
					}
				}
			}
			break;
		case 2:
			for (int i = 0; i < rect.length; i++) {
				for (int j = 0; j < rect[i].length; j++) {
					if (i >= x) {
						rect[i][j] = false;
					}
				}
			}
			break;
		case 3:
			for (int i = 0; i < rect.length; i++) {
				for (int j = 0; j < rect[i].length; j++) {
					if (j < y) {
						rect[i][j] = false;
					}
				}
			}
			break;
		case 4:
			for (int i = 0; i < rect.length; i++) {
				for (int j = 0; j < rect[i].length; j++) {
					if (j >= y) {
						rect[i][j] = false;
					}
				}
			}
			break;
		}
	}
}