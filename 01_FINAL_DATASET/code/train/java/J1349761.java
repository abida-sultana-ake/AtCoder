import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    private static boolean debug = false;
    private static boolean elapsed = false;

    private static PrintWriter _out = new PrintWriter(System.out);
    private static PrintWriter _err = new PrintWriter(System.err);

    private int N;
    private int K;
    private int[] w;
    private int[] p;

    private void solve(Scanner sc) {
        N = sc.nextInt();
        K = sc.nextInt();
        w = new int[N];
        p = new int[N];
        for (int i = 0; i < N; ++i) {
            w[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        double ans = 0;

        double left = 0d;
        double right = 100d;
        while (right > left + 1e-9 && (right - left) / right > 1e-9) {
            double mid = (left + right) / 2;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        _out.printf("%.9f%n", left);
    }
    private boolean check(double m) {
        List<Pair<Double>> s = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            s.add(new Pair<>(w[i] * (p[i] - m), 1d * w[i]));
        }

        Collections.sort(s);
        double sum = 0d;
        for (int i = N - 1; i >= N - K; --i) {
            sum += s.get(i).a;
        }
        return (sum > 0d);
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