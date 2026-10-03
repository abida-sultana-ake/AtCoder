import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    new Main().run();
  }

  class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int a, int b) {
      x = a;
      y = b;
    }

    @Override
    public int compareTo(Point o) {
      if (o.x == x) {
        return y - o.y;
      } else {
        return x - o.x;
      }
    }

    @Override
    public int hashCode() {
      return Integer.hashCode(x) ^ Integer.hashCode(y);
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o.getClass() != this.getClass()) {
        return false;
      }
      Point p = (Point) o;
      if (x == p.x) if (y == p.y) return true;
      return false;
    }
  }

  void run() {
    int h = ni();
    int w = ni();
    int n = ni();
    HashMap<Point, Integer> map = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      int a = ni();
      int b = ni();
      for (int x = 0; x < 3; ++x) {
        for (int y = 0; y < 3; ++y) {
          int ny = a - y;
          int nx = b - x;
          if (nx < 1 || w - 2 < nx || ny < 1 || h - 2 < ny) {
            continue;
          }
          Point p = new Point(nx, ny);
          if (map.containsKey(p)) {
            map.put(p, map.get(p) + 1);
          } else {
            map.put(p, 1);
          }
        }
      }
    }
    long cnt = 0;
    long[] ans = new long[10];
    for (Point ite : map.keySet()) {
//      debug(ite.x, ite.y, map.get(ite));
      int sub = map.get(ite);
      ++cnt;
      ++ans[sub];
    }
    ans[0] = (long) (w - 2) * (long) (h - 2) - cnt;
    LongStream.of(ans).forEach(System.out::println);
  }

  int ni() {
    return Integer.parseInt(sc.next());
  }

  void debug(Object... os) {
    System.err.println(Arrays.deepToString(os));
  }
}