import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		solve(s);
		s.close();
	}

	public static void solve(Scanner s) {
		long a = s.nextLong();
		long b = s.nextLong();
		long c = s.nextLong();

		long x = 1000000000 + 7;

		System.out.println(((a * b) % x * (c) % x) % x);
	}
}
