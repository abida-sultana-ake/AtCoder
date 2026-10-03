import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    private static boolean debug = false;
    private static boolean elapsed = false;

    private static PrintWriter _out = new PrintWriter(System.out);
    private static PrintWriter _err = new PrintWriter(System.err);

    private void solve(Scanner sc) {
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] l = new int[Q];
        int[] r = new int[Q];
        for (int i = 0; i < Q; ++i) {
            l[i] = sc.nextInt() - 1;
            r[i] = sc.nextInt() - 1;
        }

        // いもす法
        int[] cnt = new int[N + 1];
        for (int i = 0; i < Q; ++i) {
            ++cnt[l[i]];
            --cnt[r[i] + 1];
        }

        for (int i = 0; i < N; ++i) {
            cnt[i + 1] += cnt[i];
        }

        for (int i = 0; i < N; ++i) {
            _out.print((cnt[i] % 2 == 0 ? 0 : 1));
        }
        _out.println();
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