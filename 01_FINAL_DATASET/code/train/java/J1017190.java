import java.io.*;
import java.util.*;

public class Main {
  private static boolean debug = false;
  private static boolean elapsed = false;

  private static PrintWriter _err = new PrintWriter(System.err);

  private void solve(Scanner sc, PrintWriter out) {
    StringBuilder sA = new StringBuilder(sc.nextLine());
    StringBuilder sB = new StringBuilder(sc.nextLine());
    StringBuilder sC = new StringBuilder(sc.nextLine());

    Map<Character, StringBuilder> map = new HashMap<>();
    map.put('a', sA);
    map.put('b', sB);
    map.put('c', sC);

    char ch = 'a';
    while (true) {
      StringBuilder sb = map.get(ch);
      if (sb == null) {
        throw new RuntimeException(ch + ": Invalid input");
      }
      if (sb.length() == 0) {
        break;
      }
      ch = sb.charAt(0);
      sb.deleteCharAt(0);
    }
    out.println(Character.toUpperCase(ch));
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