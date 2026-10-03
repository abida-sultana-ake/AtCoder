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
        int M = sc.nextInt();
        int[] a = new int[M];
        int[] b = new int[M];
        int[] c = new int[M];
        for (int i = 0; i < M; ++i) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
            c[i] = sc.nextInt() * -1;
        }

        // based on ベルマンフォード法
        long[] dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < N - 1; ++i) {
            for (int j = 0; j < M; ++j) {
                if (dist[a[j]] == Long.MAX_VALUE) {
                    continue;
                }

                if (dist[b[j]] > dist[a[j]] + c[j]) {
                    dist[b[j]] = dist[a[j]] + c[j];
                }
            }
        }

        long ans = -dist[N - 1];

        boolean[] neg = new boolean[N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (dist[a[j]] == Long.MAX_VALUE) {
                    continue;
                }

                if (dist[b[j]] > dist[a[j]] + c[j]) {
                    dist[b[j]] = dist[a[j]] + c[j];
                    neg[b[j]] = true;
                }

                if (neg[a[j]]) {
                    neg[b[j]] = true;
                }
            }
        }

        if (neg[N - 1]) {
            _out.println("inf");
        } else {
            _out.println(ans);
        }
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