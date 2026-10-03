import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner scan = new Scanner(System.in);

		Integer x = scan.nextInt();
		Integer a = scan.nextInt();
		Integer b = scan.nextInt();

		int ax = x - a;
		int bx = x - b;

		int axx = ax * ax ;
		int bxx = bx * bx ;

		if (axx < bxx) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
	}
}
