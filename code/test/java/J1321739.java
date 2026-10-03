import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    private static boolean debug = false;
    private static boolean elapsed = false;

    private static PrintWriter _out = new PrintWriter(System.out);
    private static PrintWriter _err = new PrintWriter(System.err);

    private int N;
    private int A;
    private int B;
    private long[] v;

    private long count;

    private void solve(Scanner sc) {
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        v = new long[N];
        for (int i = 0; i < N; ++i) {
            v[i] = sc.nextLong();
        }
        Arrays.sort(v);
        for (int i = 0; i < N / 2; ++i) {
            long t = v[i];
            v[i] = v[N - i - 1];
            v[N - i - 1] = t;
        }

        double avg = avg(v, 0, A - 1);
        long count;
        if (v[0] != v[A - 1]) {
            int x = 0;
            for (int i = 0; i < N; ++i) {
                if (v[A - 1] == v[i]) {
                    ++x;
                }
            }
            int y = 0;
            for (int i = 0; i < A; ++i) {
                if (v[A - 1] == v[i]) {
                    ++y;
                }
            }
            count = C(x, y).longValue();
        } else {
            int x = 0;
            for (int i = 0; i < N; ++i) {
                if (v[0] == v[i]) {
                    ++x;
                }
            }
            count = 0;
            for (int i = A; i <= B; ++i) {
                count += C(x, i).longValue();
            }
        }

        _out.printf("%.6f%n", avg);
        _out.println(count);
    }
    private double avg(long[] ary, int from, int to) {
        long sum = 0;
        for (int i = from; i <= to; ++i) {
            sum += ary[i];
        }
        return 1d * sum / (to - from + 1);
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