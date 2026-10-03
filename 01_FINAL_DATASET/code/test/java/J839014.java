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
		for (int i=0; i<n-1; i++) {
			if (s.charAt(i) == s.charAt(i+1)) {
				out.println((i+1)+" "+(i+2));
				return;
			}
		}
		for (int i=0; i<n-3; i++) {
			if (s.charAt(i) == s.charAt(i+2)) {
				out.println((i+1)+" "+(i+3));
				return;
			}
		}
		out.println("-1 -1");
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