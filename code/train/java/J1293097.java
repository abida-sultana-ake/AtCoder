import java.io.*;
import java.util.*;


public class Main {

	private static Scanner sc;
	private static Printer pr;

	private static void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] a = new int[m];
		int[] b = new int[m];
		int[] cnt = new int[n];
		for (int i = 0; i < m; i++) {
			a[i] = sc.nextInt() - 1;
			b[i] = sc.nextInt() - 1;

			cnt[a[i]]++;
			cnt[b[i]]++;
		}

		for (int i = 0; i < n; i++) {
			pr.println(cnt[i]);
		}
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
