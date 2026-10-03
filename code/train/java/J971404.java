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
		int t = in.nextInt();
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}

		int min = Integer.MAX_VALUE;
		int d = 0;
		for (int i=0; i<n; i++) {
			min = Math.min(min, a[i]);
			d = Math.max(d, a[i] - min);
		}

		int cnt = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		for (int i=0; i<n; i++) {
			cnt += map.getOrDefault(a[i]-d, 0);
			map.put(a[i], map.getOrDefault(a[i], 0)+1);
		}

		out.println(cnt);
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