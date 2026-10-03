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
        int[] a = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = sc.nextInt();
        }
        IntSummaryStatistics stat = Arrays.stream(a).summaryStatistics();
        if (stat.getMax() == stat.getMin()) {
            _out.println(0);
            return;
        } else if (stat.getSum() % stat.getCount() != 0) {
            _out.println(-1);
            return;
        }

        int target = (int)stat.getAverage();
        boolean[] b = new boolean[N - 1];

        int idx = 0;
        do {
            int sum = a[idx];
            int cnt = 1;
            ++idx;
            while (idx < N && (sum % cnt != 0 || sum / cnt != target)) {
                if (idx > 0) {
                    b[idx - 1] = true;
                }
                sum += a[idx];
                ++cnt;
                ++idx;
            }
        } while (idx < N);

        int cnt = 0;
        for (int i = 0; i < b.length; ++i) {
            if (b[i]) {
                ++cnt;
            }
        }
        _out.println(cnt);
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