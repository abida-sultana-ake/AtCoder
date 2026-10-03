import java.io.*;
import java.util.*;

public class Main {
  private static boolean debug = false;
  private static boolean elapsed = false;

  private static PrintWriter _err = new PrintWriter(System.err);

  private int minLen = Integer.MAX_VALUE;
  private boolean isFirst = false;
  private void solve(Scanner sc, PrintWriter out) {
    String s = sc.nextLine();

    int r = s.length() % 2;

    StringBuilder sb = new StringBuilder(s);
    boolean found = false;
    do {
      found = false;
      for (int i = 1; i < sb.length() - 1; ++i) {
        if (sb.charAt(i - 1) == sb.charAt(i + 1)) {
          continue;
        }
        sb.deleteCharAt(i);
        found = true;
        break;
      }
    } while (found);

    if (sb.charAt(0) == sb.charAt(sb.length() - 1)) {
      isFirst = (r == 0);
    } else {
      isFirst = (r != 0);
    }

    out.println(isFirst ? "First" : "Second");
  }
  private long P(long n, long r) {
    long res = 1;
    for (long i = n; i > n - r; --i) {
      res *= i;
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