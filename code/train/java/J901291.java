import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int h = sc.nextInt();
		System.out.println((a+b)*h/2);
		sc.close();
	}
}
