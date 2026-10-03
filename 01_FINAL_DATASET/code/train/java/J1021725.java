import java.io.*;
import java.util.*;

public class Main {
  private static boolean debug = false;
  private static boolean elapsed = false;

  private static PrintWriter _err = new PrintWriter(System.err);

  private long n;
  private long s;

  private void solve(Scanner sc, PrintWriter out) {
    n = sc.nextLong();
    s = sc.nextLong();

    if (n == s) {
      out.println((n + 1));
      return;
    }

    for (long i = 2; i <= Math.sqrt(n); ++i) {
      if (f(i, n) == s) {
        out.println(i);
        return;
      }
    }

    for (long i = (long)Math.sqrt(n); i > 0; --i) {
      long b = (n - s) / i + 1;
      if (b > 1 && f(b, n) == s) {
        out.println(b);
        return;
      }
    }

    out.println(-1);
  }
  private long f(long b, long n) {
    if (n < b) {
      return n;
    } else {
      return f(b, n / b) + (n % b);
    }
  }
  private long C(long n, long r) {
    long res = 1;
    for (long i = n; i > n - r; --i) {
      res *= i;
    }
    for (long i = r; i > 1; --i) {
      res /= i;
    }
    return res;
  }
  private long P(long n, long r) {
    long res = 1;
    for (long i = n; i > n - r; --i) {
      res *= i;
    }
    return res;
  }
  private long ceil2pow(long n) {
    if (n == 0) {
      return 1;
    }
    n--;
    n |= (n >>> 1);
    n |= (n >>> 2);
    n |= (n >>> 4);
    n |= (n >>> 8);
    n |= (n >>> 16);
    n++;
    return n;
  }
  /*
   * 10^10 > Integer.MAX_VALUE = 2147483647 > 10^9
   * 10^19 > Long.MAX_VALUE = 9223372036854775807L > 10^18
   */
  public static void main(String[] args) {
    long S = System.currentTimeMillis();

    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    new Main().solve(sc, out);
    out.flush();

    long G = System.currentTimeMillis();
    if (elapsed) {
      _err.println((G - S) + "ms");
    }
    _err.flush();
  }
}