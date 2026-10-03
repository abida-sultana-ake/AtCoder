import java.util.Scanner;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		solve(s);
		s.close();
	}

	public static void solve(Scanner s) {
		long n = s.nextLong();

		System.out.println((int) Math.pow(n, 0.25));
	}
}