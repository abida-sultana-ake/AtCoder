import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class Main {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		int n = in.nextInt();
		int x = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = b[i] = in.nextInt();
		}

		long ans = 0;
		for (int i=1; i<n; i++) {
			long s = a[i] + a[i-1];
			long t = Math.max(0, s - x);
			long y = Math.min(t, a[i]);
			a[i] -= y;
			ans += t;
		}

		long ans2 = 0;
		for (int i=n-2; i>=0; i--) {
			long s = b[i] + b[i+1];
			long t = Math.max(0, s - x);
			long y = Math.min(t, b[i]);
			b[i] -= y;
			ans2 += t;
		}

		out.println(Math.min(ans, ans2));
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		solve();
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}