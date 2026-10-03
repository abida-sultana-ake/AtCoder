import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
    private static boolean debug = false;
    private static boolean elapsed = false;
 
    private static PrintWriter _out = new PrintWriter(System.out);
    private static PrintWriter _err = new PrintWriter(System.err);
 
    private void solve(Scanner sc) {
        Pair<Integer> overRate = new Pair<>(3200, Integer.MAX_VALUE);
 
        Map<Pair<Integer>, Integer> map = new HashMap<>();
        map.put(new Pair<>(   1,  399), 0);
        map.put(new Pair<>( 400,  799), 0);
        map.put(new Pair<>( 800, 1199), 0);
        map.put(new Pair<>(1200, 1599), 0);
        map.put(new Pair<>(1600, 1999), 0);
        map.put(new Pair<>(2000, 2399), 0);
        map.put(new Pair<>(2400, 2799), 0);
        map.put(new Pair<>(2800, 3199), 0);
        map.put(overRate, 0);
 
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = sc.nextInt();
            Pair<Integer> pair = null;
            for (Pair<Integer> p : map.keySet()) {
                if (p.a <= a[i] && a[i] <= p.b) {
                    pair = p;
                    break;
                }
            }
            map.put(pair, map.get(pair) + 1);
        }
 
        int cnt1 = 0;
        int cnt2 = 0;
        for (Map.Entry<Pair<Integer>, Integer> entry : map.entrySet()) {
            if (entry.getKey() == overRate) {
                cnt2 += entry.getValue();
            } else if (entry.getValue() > 0) {
                ++cnt1;
            }
        }
 
        _out.println(Math.max(cnt1, (cnt2 > 0 ? 1 : 0)) + " " + (cnt1 + cnt2));
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
    private static class Pair<T extends Comparable<T>> implements Comparable<Pair<T>> {
        T a;
        T b;
        public Pair(T a, T b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Pair<T> that) {
            if (this == that) {
                return 0;
            }
            if (this.a != null && that.a == null) {
                return 1;
            } else if (this.a == null && that.a != null) {
                return -1;
            }
            if (this.b != null && that.b == null) {
                return 1;
            } else if (this.b == null && that.b != null) {
                return -1;
            }
            int r = 0;
            if (this.a != null && that.a != null) {
                r = this.a.compareTo(that.a);
                if (r != 0) {
                    return r;
                }
            }
            if (this.b != null && that.b != null) {
                r = this.b.compareTo(that.b);
                if (r != 0) {
                    return r;
                }
            }
            return r;
        }
        @Override
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair that = (Pair)o;
                boolean res = (this.a == null && this.a == that.a || this.a != null && this.a.equals(that.a));
                res = res && (this.b == null && this.b == that.b || this.b != null && this.b.equals(that.b));
                return res;
            }
            return false;
        }
        @Override
        public int hashCode() {
            int hashCode = 17;
            hashCode = hashCode * 31 + (a != null ? a.hashCode() : 0);
            hashCode = hashCode * 31 + (b != null ? b.hashCode() : 0);
            return hashCode;
        }
        @Override
        public String toString() {
            return "[" + a + ", " + b + "]";
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