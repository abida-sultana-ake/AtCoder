import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    private static boolean debug = false;
    private static boolean elapsed = true;

    private static PrintWriter _out = new PrintWriter(System.out);
    private static PrintWriter _err = new PrintWriter(System.err);

    private int N;
    private int K;
    private int[] a;

    private void solve(Scanner sc) {
        N = sc.nextInt();
        K = sc.nextInt();
        a = new int[N];
        long sum = 0;
        for (int i = 0; i < N; ++i) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        if (sum < K) {
            _out.println(N);
            return;
        }

        Arrays.sort(a);

        long ans = 0;
        int left = 0;
        int right = N;
        while (left < right) {
            int c = (left + right) / 2;
            boolean flg = true;
            if (a[c] < K) {
                boolean[][] dp = new boolean[N][K];
                dp[0][0] = true;
                if (c != 0) {
                    dp[0][a[0]] = true;
                }
                for (int i = 1; i < N; ++i) {
                    dp[i][0] = true;
                    for (int j = 0; j < K; ++j) {
                        if (i != c && a[i] <= j) {
                            dp[i][j] = dp[i - 1][j] || dp[i - 1][j - a[i]];
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
                flg = false;
                for (int i = K - a[c]; i < K; ++i) {
                    if (dp[N - 1][i]) {
                        flg = true;
                        break;
                    }
                }
            }
            if (flg) {
                right = c;
            } else {
                ans = c + 1;
                left = c + 1;
            }
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