import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
    private static boolean debug = false;
    private static boolean elapsed = false;
 
    private static PrintWriter _out = new PrintWriter(System.out);
    private static PrintWriter _err = new PrintWriter(System.err);
 
    private int N;
    private int W;
    private int[] w;
    private int[] v;
 
    private Map<String, Long> memo = new HashMap<>();
 
    private void solve(Scanner sc) {
        N = sc.nextInt();
        W = sc.nextInt();
        w = new int[N];
        v = new int[N];
        for (int i = 0; i < N; ++i) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
 
        _out.println(calc(0, 0));
    }
    private long calc(int d, long weight) {
        String key = d + ":" + weight;
        if (d >= N) {
            return 0;
        }
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
 
        long v1 = 0;
        if (weight + w[d] <= W) {
            v1 = calc(d + 1, weight + w[d]) + v[d];
        }
        long v2 = calc(d + 1, weight);
        long vr = Math.max(v1, v2);
        memo.put(key, vr);
        return vr;
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