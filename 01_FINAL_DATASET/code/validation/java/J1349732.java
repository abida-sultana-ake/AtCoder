import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    private static boolean debug = false;
    private static boolean elapsed = false;

    private static PrintWriter _out = new PrintWriter(System.out);
    private static PrintWriter _err = new PrintWriter(System.err);

    private static long MOD = 1_000_000_007;

    private void solve(Scanner sc) {
        int W = sc.nextInt();
        int H = sc.nextInt();

        long n = W + H - 2;
        long r = W - 1;
        long res = 1;
        for (long i = n; i > n - r; --i) {
            res = (res * i) % MOD;
        }
        for (long i = r; i > 1; --i) {
            res = (res * calc(i, MOD - 2, MOD)) % MOD;
        }

        _out.println(res);
    }
    private long calc(long a, long b, long p) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            long d = calc(a, b / 2, p);
            return (d * d) % p;
        } else {
            return (a * calc(a, b - 1, p)) % p;
        }
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