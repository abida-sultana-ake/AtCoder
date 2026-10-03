
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();

		if (a % 2 == 0) {
			System.out.println(a - 1);
		} else if (a % 2 == 1) {

			System.out.println(a + 1);

		}
	}
}