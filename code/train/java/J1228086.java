import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n=s.nextInt();
		System.out.println((n/10*100)+((n%10<7)?n%10*15:100));
	}
}
