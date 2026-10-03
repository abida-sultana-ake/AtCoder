import java.io.*;
import java.util.*;


public class Main {

	private static Scanner sc;
	private static Printer pr;

	private static void solve() {
		int n = sc.nextInt();

		long ans = 0;
		for (int i = 0; i < n; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();

			ans += r - l + 1;
		}

		pr.println(ans);
	}

	// ---------------------------------------------------
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		pr = new Printer(System.out);

		solve();

		pr.close();
		sc.close();
	}

	private static class Printer extends PrintWriter {
		Printer(PrintStream out) {
			super(out);
		}
	}
}
