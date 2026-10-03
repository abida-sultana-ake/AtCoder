import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    new Main().run();
  }

  class Box {
    int h, w;
  }

  class BIT<T> {
    int n;
    ArrayList<T> bit;
    BiFunction<T, T, T> bif;

    BIT(int n, BiFunction<T, T, T> bif, T defaultValue) {
      this.n = n;
      bit = new ArrayList<>(n + 1);
      for (int i = 0; i < n + 1; ++i) {
        bit.add(defaultValue);
      }
      this.bif = bif;
    }

    void update(int i, T v) {
      for (int x = i; x <= n; x += x & -x) {
        bit.set(x, bif.apply(bit.get(x), v));
      }
    }

    T reduce(int i, T defaultValue) {
      T ret = defaultValue;
      for (int x = i; x > 0; x -= x & -x) {
        ret = bif.apply(ret, bit.get(x));
      }
      return ret;
    }
  }

  void run() {
    int n = ni();
    Box[] list = new Box[n];
    for (int i = 0; i < n; ++i) {
      int w = ni();
      int h = ni();
      Box b = new Box();
      b.w = w;
      b.h = h;
      list[i] = b;
    }
    Arrays.sort(list, (a, b) -> {
      if (a.h == b.h) {
        return b.w - a.w;
      } else {
        return a.h - b.h;
      }
    });
    BIT<Integer> bit = new BIT<>(100000, Integer::max, 0);
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
      dp[i] = bit.reduce(list[i - 1].w - 1, 0) + 1;
      bit.update(list[i - 1].w, dp[i]);
    }
    int max = 0;
    for (int i = 1; i <= n; ++i) {
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }

  int ni() {
    return Integer.parseInt(sc.next());
  }

  void debug(Object... os) {
    System.err.println(Arrays.deepToString(os));
  }
}