import java.io.*;
import java.util.*;


public class Main {

	private static Scanner sc;
	private static Printer pr;

	private static void solve() {
		int n = sc.nextInt();

		int max = 0;
		int min = 1000;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();

			max = Math.max(max, a);
			min = Math.min(min, a);
		}

		pr.println(max - min);
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
