import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		for (int i = 1;i <= m;i++) {
			int c = sc.nextInt();
			if (n<=a) n += b;
			n -= c;
			if (n<0) {
				System.out.println(i);
				return;
			}
		}

		System.out.println("complete");
	}
}
