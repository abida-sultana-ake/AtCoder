import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class Main {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static long R, B, s, t;

	static boolean f(long m) {
		return (R-m)/(s-1) + (B-m)/(t-1) >= m && R >= m && B >= m;
	}

	static long binSearch() {
		long l = -1, r = Math.max(R,B);
		while (r - l > 1) {
			long m = (l + r)/2;
			if (f(m)) l = m;
			else r = m;
		}
		return r;
	}

	static void solve() {
		R = in.nextLong();
		B = in.nextLong();
		s = in.nextLong();
		t = in.nextLong();
		long ans = binSearch();
		out.println(ans-1);
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.currentTimeMillis();

		solve();
		out.flush();

		long end = System.currentTimeMillis();
		dump((end-start) + "ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}