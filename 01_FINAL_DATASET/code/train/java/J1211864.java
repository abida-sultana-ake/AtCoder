import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		int X = sc.nextInt();

		int n = 0;
		int ans = 0;
		for (int i = 0; i < X; i++) {
			n += i + 1;
			if (X <= n) {
				ans = i + 1;
				break;
			}
		}
		// 出力
		System.out.println(ans);
	}
}
