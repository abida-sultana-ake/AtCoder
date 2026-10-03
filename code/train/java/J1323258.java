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
        int[] s = new int[n];
        int sum = 0;
        for (int i=0; i<n; i++) {
            s[i] = in.nextInt();
            sum += s[i];
        }
        Arrays.sort(s);
        if (sum%10 != 0) {
            out.println(sum);
        } else {
            for (int i=0; i<n; i++) {
                if (s[i] % 10 != 0) {
                    sum -= s[i];
                    break;
                }
            }
            if (sum % 10 == 0) {
                out.println(0);
            } else {
                out.println(sum);
            }
        }
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