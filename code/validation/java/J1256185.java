import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();

		if (A == B) {
			System.out.println("Draw");
		} else if (A == 1 && B >= 2 && B <= 13) {
			System.out.println("Alice");
		} else if (B == 1 && A >= 2 && B <= 13) {
			System.out.println("Bob");
		} else if (A > B) {
			System.out.println("Alice");
		} else if (A < B) {
			System.out.println("Bob");
		}

	}

}
