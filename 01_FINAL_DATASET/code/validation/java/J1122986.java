import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int c = 0;
		int sum = 0;
		for (int i = 0;i < n;i++) {
			int a = sc.nextInt();
			if (a>0) {
				sum += a;
				c++;
			}
		}
		System.out.println((sum+(c-1))/c);
	}
}
