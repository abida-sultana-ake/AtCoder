import java.util.*;

public class Main {
	void solve() {
		try (final Scanner sc = new Scanner(System.in)) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long x = sc.nextLong();
			System.out.println(b / x - (a == 0 ? -1 : (a - 1) / x));
		}
	}

	public static void main(String[] args) {
		new Main().solve();
	}

}
