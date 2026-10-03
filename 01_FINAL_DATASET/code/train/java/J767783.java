import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt();
		int W = sc.nextInt();
		char[][] picture = new char[H][W];
		for (int i = 0; i < H; i++) {
			picture[i] = sc.next().toCharArray();
		}
		char[][] before = beforeReduction(picture, H, W);
		
		boolean bool = check(picture, before, H, W);
		StringBuilder sb = new StringBuilder();
		if (bool) {
			sb.append("possible\n");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(before[i][j]);
				}
				sb.append("\n");
			}
		} else {
			sb.append("impossible\n");
		}
		System.out.println(sb.toString());
		
		sc.close();
	}

	private boolean check(char[][] after, char[][] before, int H, int W) {
		char[][] res = new char[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				res[i][j] = '.';
			}
		}
		if (H == 1 && W == 1) res[0][0] = before[0][0];
		else if (H == 1) {
			for (int j = 0; j < W; j++) {
				if (before[0][j] == '#') {
					res[0][j] = '#';
					if (j == 0) res[0][j+1] = '#';
					else if (j == W-1) res[0][j-1] = '#';
					else {
						res[0][j-1] = '#';
						res[0][j+1] = '#';
					}
				}
			}
		} else if (W == 1) {
			for (int i = 0; i < H; i++) {
				if (before[i][0] == '#') {
					res[i][0] = '#';
					if (i == 0) res[i+1][0] = '#';
					else if (i == W-1) res[i-1][0] = '#';
					else {
						res[i-1][0] = '#';
						res[i+1][0] = '#';
					}
				}
			}
		} else {
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (before[i][j] == '#') {
						res[i][j] = '#';
						if (i == 0 && j == 0) {
							res[i][j+1] = '#';
							res[i+1][j+1] = '#';
							res[i+1][j] = '#';
						} else if (i == 0 && j == W-1) {
							res[i][j-1] = '#';
							res[i+1][j-1] = '#';
							res[i+1][j] = '#';
						} else if (i == H-1 && j == 0) {
							res[i][j+1] = '#';
							res[i-1][j+1] = '#';
							res[i-1][j] = '#';
						} else if (i == H-1 && j == W-1) {
							res[i][j-1] = '#';
							res[i-1][j-1] = '#';
							res[i-1][j] = '#';
						} else if (i == 0) {
							res[i][j-1] = '#';
							res[i+1][j-1] = '#';
							res[i+1][j] = '#';
							res[i+1][j+1] = '#';
							res[i][j+1] = '#';
						} else if (i == H - 1) {
							res[i][j-1] = '#';
							res[i-1][j-1] = '#';
							res[i-1][j] = '#';
							res[i-1][j+1] = '#';
							res[i][j+1] = '#';
						} else if (j == 0) {
							res[i-1][j] = '#';
							res[i-1][j+1] = '#';
							res[i][j+1] = '#';
							res[i+1][j+1] = '#';
							res[i+1][j] = '#';
						} else if (j == W - 1) {
							res[i-1][j] = '#';
							res[i-1][j-1] = '#';
							res[i][j-1] = '#';
							res[i+1][j-1] = '#';
							res[i+1][j] = '#';
						} else {
							res[i-1][j-1] = '#';
							res[i-1][j] = '#';
							res[i-1][j+1] = '#';
							res[i][j-1] = '#';
							res[i][j] = '#';
							res[i][j+1] = '#';
							res[i+1][j-1] = '#';
							res[i+1][j] = '#';
							res[i+1][j+1] = '#';
						}
					}
				}
			}
		}
		
		boolean ans = true;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				ans &= (after[i][j] == res[i][j]);
			}
		}
		return ans;
	}
	private char[][] beforeReduction(char[][] pic, int H, int W) {
		char[][] ans = new char[H][W];
		if (W == 1 && H == 1) ans[0][0] = pic[0][0];
		else if (W == 1) {
			for (int i = 0; i < H; i++) {
				if (pic[i][0] == '#')
					if (i == 0) {
						if (pic[i+1][0] == '#') ans[i][0] = '#';
						else ans[i][0] = '.';
					} else if (i == H - 1) {
						if (pic[i-1][0] == '#') ans[i][0] = '#';
						else ans[i][0] = '.';
					} else {
						if (pic[i-1][0] == '#' && pic[i+1][0] == '#') ans[i][0] = '#';
						else ans[i][0] = '.';
					}
				else ans[i][0] = '.';
			}
		} else if (H == 1) {
			for (int j = 0; j < W; j++) {
				if (pic[0][j] == '#')
					if (j == 0) {
						if (pic[0][j+1] == '#') ans[0][j] = '#';
						else ans[0][j] = '.';
					} else if (j == W - 1) {
						if (pic[0][j-1] == '#') ans[0][j] = '#';
						else ans[0][j] = '.';
					} else {
						if (pic[0][j-1] == '#' && pic[0][j+1] == '#') ans[0][j] = '#';
						else ans[0][j] = '.';
					}
				else ans[0][j] = '.';
			}
		} else {
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (pic[i][j] == '#') {
						if (i == 0 && j == 0) {
							if (pic[i+1][j] == '#' && pic[i][j+1] == '#' && pic[i+1][j+1] == '#') ans[i][j] = '#';
							else ans[i][j] = '.';
						} else if (i == 0 && j == W-1) {
							if (pic[i][j-1] == '#' && pic[i+1][j] == '#' && pic[i+1][j-1] == '#') ans[i][j] = '#';
							else ans[i][j] = '.';
						} else if (i == H-1 && j == 0) {
							if (pic[i-1][j] == '#' && pic[i][j+1] == '#' && pic[i-1][j+1] == '#') ans[i][j] = '#';
							else ans[i][j] = '.';
						} else if (i == H-1 && j == W-1) {
							if (pic[i][j-1] == '#' && pic[i-1][j] == '#' && pic[i-1][j-1] == '#') ans[i][j] = '#';
							else ans[i][j] = '.';
						} else if (i == 0) {
							if (pic[i][j-1] == '#' && pic[i+1][j-1] == '#' && pic[i+1][j] == '#' && pic[i+1][j+1] == '#' && pic[i][j+1] == '#') ans[i][j] = '#';
							else ans[i][j] = '.';
						} else if (i == H - 1) {
							if (pic[i][j-1] == '#' && pic[i-1][j-1] == '#' && pic[i-1][j] == '#' && pic[i-1][j+1] == '#' && pic[i][j+1] == '#') ans[i][j] = '#';
							else ans[i][j] = '.';
						} else if (j == 0) {
							if (pic[i-1][j] == '#' && pic[i-1][j+1] == '#' && pic[i][j+1] == '#' && pic[i+1][j+1] == '#' && pic[i+1][j] == '#') ans[i][j] = '#';
							else ans[i][j] = '.';
						} else if (j == W - 1) {
							if (pic[i-1][j] == '#' && pic[i-1][j-1] == '#' && pic[i][j-1] == '#' && pic[i+1][j-1] == '#' && pic[i+1][j] == '#') ans[i][j] = '#';
							else ans[i][j] = '.';
						} else {
							if (pic[i-1][j-1] == '#' && pic[i-1][j] == '#' && pic[i-1][j+1] == '#' && pic[i][j-1] == '#' && pic[i][j+1] == '#' && pic[i+1][j-1] == '#' && pic[i+1][j] == '#' && pic[i+1][j+1] == '#') ans[i][j] = '#';
							else ans[i][j] = '.';
						}
					}
					else ans[i][j] = '.';
				}
			}
		}
		
		return ans;
	}

}
