import java.io.*;
import java.util.*;

public class Main {
  private static boolean debug = false;
  private static boolean elapsed = false;

  private static PrintWriter _err = new PrintWriter(System.err);

  private static long MOD = 1_000_000_007;

  private int N;
  private int[] A;

  private void solve(Scanner sc, PrintWriter out) {
    N = sc.nextInt();
    A = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
    }

    boolean[] b = new boolean[N];
    long total = 1;
    for (int i = 0; i < N; ++i) {
      if (!b[(N - A[i]) / 2]) {
        b[(N - A[i]) / 2] = true;
      } else if (!b[N - ((N - A[i]) / 2) - 1]) {
        b[N - ((N - A[i]) / 2) - 1] = true;
        total <<= 1;
        total %= MOD;
      } else {
        out.println(0);
        return;
      }
    }
    out.println(total);
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