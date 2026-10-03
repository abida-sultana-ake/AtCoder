import java.io.*;
import java.util.*;

public class Main {
  private static boolean debug = false;
  private static boolean elapsed = true;

  private static PrintWriter _err = new PrintWriter(System.err);

  private static class Point implements Comparable<Point> {
    int a;
    int b;
    public Point(int a, int b) {
      this.a = a;
      this.b = b;
    }
    public int hashCode() {
      int hashCode = 17;
      hashCode = hashCode * 31 + a;
      hashCode = hashCode * 31 + b;
      return hashCode;
    }
    public boolean equals(Object o) {
      if (o instanceof Point) {
        Point that = (Point)o;
        return this.a == that.a && this.b == that.b;
      }
      return false;
    }
    public int compareTo(Point that) {
      int r = this.a - that.a;
      if (r != 0) {
        return r;
      }
      r = this.b - that.b;
      return r;
    }
    public String toString() {
      return "(" + a + ", " + b + ")";
    }
  }
  private static class Square3x3 {
    int a;
    int b;
    int cnt;
    public Square3x3(int a, int b) {
      this.a = a;
      this.b = b;
    }
    public boolean contains(Point that) {
      return (this.a - 1 <= that.a && that.a <= this.a + 1 && this.b - 1 <= that.b && that.b <= this.b + 1);
    }
    public int hashCode() {
      int hashCode = 17;
      hashCode = hashCode * 31 + a;
      hashCode = hashCode * 31 + b;
      return hashCode;
    }
    public boolean equals(Object o) {
      if (o instanceof Square3x3) {
        Square3x3 that = (Square3x3)o;
        return this.a == that.a && this.b == that.b;
      }
      return false;
    }
    public String toString() {
      return String.valueOf("(" + a + ", " + b + ", " + cnt + ")");
    }
  }
  private void solve(Scanner sc, PrintWriter out) {
    long H = sc.nextInt();
    long W = sc.nextInt();
    int N = sc.nextInt();

    int M = 10; // 0 <= j <= 9

    long[] count = new long[M];

    count[0] = (H - 2) * (W - 2);

    Map<Point, Square3x3> map = new TreeMap<>();
    for (int i = 0; i < N; ++i) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      Point p = new Point(a, b);
      for (int x = p.a - 1; x <= p.a + 1; ++x) {
        if (x < 2 || x > H - 1) {
          continue;
        }
        for (int y = p.b - 1; y <= p.b + 1; ++y) {
          if (y < 2 || y > W - 1) {
            continue;
          }
          Point q = new Point(x, y);
          Square3x3 sq = map.get(q);
          if (sq == null) {
            sq = new Square3x3(x, y);
            map.put(q, sq);
          }
          ++sq.cnt;
        }
      }
    }

    for (Square3x3 sq : map.values()) {
      --count[0];
      ++count[sq.cnt];
    }

    for (int i = 0; i < M; ++i) {
      out.println(count[i]);
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