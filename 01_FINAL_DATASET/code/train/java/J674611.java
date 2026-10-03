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
		int t = in.nextInt();
		int x = 0, y = 0;

		int n = s.length();
		int cnt = 0;
		for (int i=0; i<n; i++) {
			if (s.charAt(i) == '?') {
				cnt++;
			} else if (s.charAt(i) == 'L'){
				x--;
			} else if (s.charAt(i) == 'R') {
				x++;
			} else if (s.charAt(i) == 'U') {
				y++;
			} else {
				y--;
			}
		}

		int tmp = Math.abs(x)+Math.abs(y);

		if (t == 1) {
			out.println((tmp+cnt));
		} else {
			out.println(tmp >= cnt ? (tmp - cnt) : ((cnt - tmp)%2 == 0 ? 0 : 1));
		}
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