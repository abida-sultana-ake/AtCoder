import java.io.*;
import java.util.*;

public class Main {
  private static boolean debug = false;
  private static boolean elapsed = false;

  private static PrintWriter _err = new PrintWriter(System.err);

  private void solve(Scanner sc, PrintWriter out) {
    String s = sc.nextLine();

    if (s.length() < 2) {
      out.println("-1 -1");
      return;
    }

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < 2; ++i) {
      char ch = s.charAt(i);
      Integer cnt = map.get(ch);
      if (cnt == null) {
        cnt = 0;
      }
      map.put(ch, cnt + 1);
    }
    if (s.length() == 2) {
      if (map.size() == 1) {
        out.println("1 2");
        return;
      }
    }
    for (int i = 0; i < s.length() - 2; ++i) {
      if (i > 0) {
        char old = s.charAt(i - 1);
        Integer cnt = map.get(old);
        map.put(old, cnt - 1);
      }
      char ch = s.charAt(i + 2);
      Integer cnt = map.get(ch);
      if (cnt == null) {
        cnt = 0;
      }
      map.put(ch, cnt + 1);
      if (cnt + 1 >= 2) {
        out.println((i + 1) + " " + (i + 3));
        return;
      }
    }

    out.println("-1 -1");
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