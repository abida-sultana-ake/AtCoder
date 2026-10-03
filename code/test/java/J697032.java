import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class Main {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int cnt = 0;
	static int gcd(int a, int b) {
		if (b == 0) return a;
		cnt++;
		return gcd(b, a%b);
	}

	static void solve() {
		int k = in.nextInt();

		long x = 1, y = 0;

		for (int i=0; i<=k; i++) {
			long t = y;
			y = x;
			x = t + y;
		}
		// gcd((int)x,(int)y);
		// dump(cnt);
		out.println(x+" "+y);
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