import java.io.*;
import java.util.*;

public class Main {
  private static boolean debug = false;
  private static boolean elapsed = false;

  private static PrintWriter _err = new PrintWriter(System.err);

  private int N;
  private int M;
  private Map<Integer, List<Integer>> hint;

  private void solve(Scanner sc, PrintWriter out) {
    N = sc.nextInt(); // 2 <= N <= 16
    M = sc.nextInt(); // 1 <= M <= N(N-1)/2 <= 120

    hint = new HashMap<>();
    for (int i = 0; i < M; ++i) {
      int x = sc.nextInt() - 1;
      int y = sc.nextInt() - 1;
      List<Integer> list = hint.get(x);
      if (list == null) {
        list = new ArrayList<>();
        hint.put(x, list);
      }
      list.add(y);
    }

    long[] dp = new long[1 << N];
    dp[0] = 1; // S = φ
    for (int i = 1; i < 1 << N; ++i) {
      long sum = 0;
      for (int j = 0; j < N; ++j) {
        if ((i >> j & 1) == 1) {
          boolean last = true;
          if (hint.containsKey(j)) {
            for (Integer x : hint.get(j)) {
              if ((i >> x & 1) == 1) {
                last = false;
                break;
              }
            }
          }
          if (last) {
            sum += dp[i - (1 << j)];
          }
        }
      }
      dp[i] = sum;
    }

    out.println(dp[(1 << N) - 1]);
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