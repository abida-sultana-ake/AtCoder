

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		if (b < 10) {
			System.out.println((a * 10 + b) * 2);
		} else if (b < 100) {

			System.out.println((a * 100 + b) * 2);

		} else if (b < 1000) {

			System.out.println((a * 1000 + b) * 2);

		}
	}
}