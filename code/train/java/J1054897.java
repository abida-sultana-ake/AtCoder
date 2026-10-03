import java.io.*;
import java.util.*;

public class Main {
    private static boolean debug = false;
    private static boolean elapsed = false;

    private static PrintWriter _out = new PrintWriter(System.out);
    private static PrintWriter _err = new PrintWriter(System.err);

    private void solve(Scanner sc) {
        String s = sc.next();
        s = s.replaceAll(",", " ");
        _out.println(s);
    }
    private long C(long n, long r) {
        long res = 1;
        for (long i = n; i > n - r; --i) {
            res *= i;
        }
        for (long i = r; i > 1; --i) {
            res /= i;
        }
        return res;
    }
    private long P(long n, long r) {
        long res = 1;
        for (long i = n; i > n - r; --i) {
            res *= i;
        }
        return res;
    }
    /*
     * 10^10 > Integer.MAX_VALUE = 2147483647 > 10^9
     * 10^19 > Long.MAX_VALUE = 9223372036854775807L > 10^18
     */
    public static void main(String[] args) {
        long S = System.currentTimeMillis();

        Scanner sc = new Scanner(System.in);
        new Main().solve(sc);
        _out.flush();

        long G = System.currentTimeMillis();
        if (elapsed) {
            _err.println((G - S) + "ms");
        }
        _err.flush();
    }
}