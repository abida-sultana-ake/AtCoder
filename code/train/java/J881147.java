import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class Main {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		String s = in.next();
		int n = s.length();
		long ans = 0;
		for (int i=0; i<1<<(n-1); i++) {
			long tmp = 0;
			int idx = 0;
			for (int j=1; j<n; j++) {
				if ((i>>(j-1)&1) == 1) {
					tmp += Long.parseLong(s.substring(idx, j));
					idx = j;
				}
			}
			tmp += Long.parseLong(s.substring(idx, n));
			ans += tmp;
		}
		out.println(ans);
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