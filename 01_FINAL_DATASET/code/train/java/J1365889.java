import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    private static boolean debug = false;
    private static boolean elapsed = false;

    private static PrintWriter _out = new PrintWriter(System.out);
    private static PrintWriter _err = new PrintWriter(System.err);

    private void solve(Scanner sc) {
        long N = sc.nextInt();
        long K = sc.nextInt();

        BigInteger tmp = BigInteger.ZERO;
        tmp = tmp.add(C(K - 1, 1).multiply(C(N - K, 1)).multiply(P(3, 3)));
        tmp = tmp.add(C(K - 1, 1).multiply(P(3, 1)));
        tmp = tmp.add(C(N - K, 1).multiply(P(3, 1)));
        tmp = tmp.add(BigInteger.ONE);
        BigDecimal ans = new BigDecimal(tmp.longValue()).divide(BigDecimal.valueOf(Math.pow(N, 3)), 20, RoundingMode.HALF_EVEN);
        _out.printf("%.20f%n", ans);
    }
    private static BigInteger C(long n, long r) {
        BigInteger res = BigInteger.ONE;
        for (long i = n; i > n - r; --i) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        for (long i = r; i > 1; --i) {
            res = res.divide(BigInteger.valueOf(i));
        }
        return res;
    }
    private static BigInteger P(long n, long r) {
        BigInteger res = BigInteger.ONE;
        for (long i = n; i > n - r; --i) {
            res = res.multiply(BigInteger.valueOf(i));
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