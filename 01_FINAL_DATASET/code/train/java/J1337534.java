import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    private static boolean debug = false;
    private static boolean elapsed = false;

    private static PrintWriter _out = new PrintWriter(System.out);
    private static PrintWriter _err = new PrintWriter(System.err);

    private static class A {
        boolean left;
        char ch;
        boolean same;
        boolean sheep;
        boolean right;
        public A(boolean sheep, char ch) {
            this.sheep = sheep;
            this.ch = ch;
            if (sheep) {
                same = (ch == 'o');
            } else {
                same = (ch != 'o');
            }
            if (!same) {
                right = true;
            }
        }
    }
    private void solve(Scanner sc) {
        int N = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        String[] pat = { "SS", "SW", "WS", "WW", };
        for (int i = 0; i < pat.length; ++i) {
            StringBuilder sb = new StringBuilder();
            sb.append(pat[i]);
            for (int j = 1; j < N - 1; ++j) {
                char ch = s.charAt(j);
                char ch2 = sb.charAt(j);
                char ch3 = sb.charAt(j - 1);
                if (ch == 'o') {
                    if (ch2 == 'S') {
                        sb.append(ch3);
                    } else {
                        if (ch3 == 'S') {
                            sb.append('W');
                        } else {
                            sb.append('S');
                        }
                    }
                } else {
                    if (ch2 == 'W') {
                        sb.append(ch3);
                    } else {
                        if (ch3 == 'S') {
                            sb.append('W');
                        } else {
                            sb.append('S');
                        }
                    }
                }
            }
            if (s.charAt(0) == 'o') {
                if (sb.charAt(0) == 'S') {
                    if (sb.charAt(1) != sb.charAt(N - 1)) {
                        continue;
                    }
                } else {
                    if (sb.charAt(1) == sb.charAt(N - 1)) {
                        continue;
                    }
                }
            } else {
                if (sb.charAt(0) == 'W') {
                    if (sb.charAt(1) != sb.charAt(N - 1)) {
                        continue;
                    }
                } else {
                    if (sb.charAt(1) == sb.charAt(N - 1)) {
                        continue;
                    }
                }
            }
            if (s.charAt(N - 1) == 'o') {
                if (sb.charAt(N - 1) == 'S') {
                    if (sb.charAt(0) == sb.charAt(N - 2)) {
                        _out.println(sb);
                        return;
                    }
                } else {
                    if (sb.charAt(0) != sb.charAt(N - 2)) {
                        _out.println(sb);
                        return;
                    }
                }
            } else {
                if (sb.charAt(N - 1) == 'W') {
                    if (sb.charAt(0) == sb.charAt(N - 2)) {
                        _out.println(sb);
                        return;
                    }
                } else {
                    if (sb.charAt(0) != sb.charAt(N - 2)) {
                        _out.println(sb);
                        return;
                    }
                }
            }
        }

        _out.println(-1);
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