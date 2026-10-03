import java.io.*;
import java.math.*;
import java.util.*;


public class Main {

	private static Scanner sc;
	private static Printer pr;

	private static void solve() {
		int n = sc.nextInt();

		int[] t = new int[n];
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
			a[i] = sc.nextInt();
		}

		long total = 0;
		long ttmp = 0;
		long atmp = 0;
		for (int i = 0; i < n; i++) {
			long tmp = t[i] + a[i];
			if (tmp >= total && ttmp <= t[i] && atmp <= a[i]) {
				total = tmp;
				ttmp = t[i];
				atmp = a[i];
			} else {
				BigInteger max = BigInteger.valueOf(total).add(BigInteger.valueOf(tmp)).subtract(BigInteger.ONE).divide(BigInteger.valueOf(tmp));
//				long max = (total + tmp - 1) / tmp;
				max = max.max(BigInteger.valueOf(ttmp).add(BigInteger.valueOf(t[i])).subtract(BigInteger.ONE).divide(BigInteger.valueOf(t[i])));
				max = max.max(BigInteger.valueOf(atmp).add(BigInteger.valueOf(a[i])).subtract(BigInteger.ONE).divide(BigInteger.valueOf(a[i])));
//				max = Math.max(max, (ttmp + t[i] - 1) / t[i]);
//				max = Math.max(max, (atmp + a[i] - 1) / a[i]);
				total = max.multiply(BigInteger.valueOf(tmp)).longValue();
//				total =  max * tmp;
				ttmp = BigInteger.valueOf(total).multiply(BigInteger.valueOf(t[i])).divide(BigInteger.valueOf(tmp)).longValue();
				atmp = BigInteger.valueOf(total).multiply(BigInteger.valueOf(a[i])).divide(BigInteger.valueOf(tmp)).longValue();
//				ttmp = total * t[i] / tmp;
//				atmp = total * a[i] / tmp;
			}
		}

		pr.println(total);
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
