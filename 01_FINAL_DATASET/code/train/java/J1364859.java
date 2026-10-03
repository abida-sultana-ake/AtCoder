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
        int ans = 0;
        for (int i = 0, j = 10; i < 9; ++i, j *= 10) {
            ans += (N / j) * (j / 10) + (N % j >= (j / 10) ? (N % j >= (j * 2 / 10) ? (j / 10) : (N % j) % (j / 10) + 1) : 0);
//_err.println(i + ":" + ans);
        }

if (false) {
int[] cnt = new int[9];
for (int i = 1; i <= N; ++i) {
    String s = String.valueOf(i);
    cnt[0] += s.matches(".*1$") ? 1 : 0;
    cnt[1] += s.matches(".*1.$") ? 1 : 0;
    cnt[2] += s.matches(".*1..$") ? 1 : 0;
    cnt[3] += s.matches(".*1...$") ? 1 : 0;
    cnt[4] += s.matches(".*1....$") ? 1 : 0;
    cnt[5] += s.matches(".*1.....$") ? 1 : 0;
    cnt[6] += s.matches(".*1......$") ? 1 : 0;
    cnt[7] += s.matches(".*1.......$") ? 1 : 0;
    cnt[8] += s.matches(".*1........$") ? 1 : 0;
}
_err.println(Arrays.toString(cnt) + ", " + Arrays.stream(cnt).sum());
}

        _out.println(ans);
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