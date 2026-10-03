import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if (a+b==c&&a-b==c) {
			System.out.println("?");
		} else if (a+b==c) {
			System.out.println("+");
		} else if (a-b==c) {
			System.out.println("-");
		} else {
			System.out.println("!");
		}
	}
}
