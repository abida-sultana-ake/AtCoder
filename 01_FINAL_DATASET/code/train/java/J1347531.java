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
    private int[] h;
 
    private void solve(Scanner sc) {
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        h = new int[N];
        for (int i = 0; i < N; ++i) {
            h[i] = sc.nextInt();
        }
 
        int max = Arrays.stream(h).max().getAsInt();
 
        int left = 0;
        int right = 1_000_000_000;
        int ans = (int)Math.ceil(1d * max / B);
        while (left < right) {
            int c = (left + right) / 2;
            if (enough(c)) {
                right = c;
                ans = c;
            } else {
                left = c + 1;
            }
        }
 
        _out.println(ans);
    }
    private boolean enough(int t) {
        int total = 0;
        for (int i = 0; i < N; ++i) {
            if (h[i] > (long)B * t) {
                total += Math.ceil(((double)h[i] - B * t) / (A - B));
            }
        }
        return total <= t;
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