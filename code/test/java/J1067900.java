import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
  private final long MOD = (long) (1e9 + 7);

  public class Combination {
    private long[] fact;
    private long[] invFact;

    public Combination(int max) {
      long[] inv = new long[max + 1];
      fact = new long[max + 1];
      invFact = new long[max + 1];
      inv[1] = 1;
      for (int i = 2; i <= max; i++) inv[i] = inv[(int) (MOD % i)] * (MOD - MOD / i) % MOD;
      fact[0] = invFact[0] = 1;
      for (int i = 1; i <= max; i++) fact[i] = fact[i - 1] * i % MOD;
      for (int i = 1; i <= max; i++) invFact[i] = invFact[i - 1] * inv[i] % MOD;
    }

    public long get(int x, int y) {
      return fact[x] * invFact[y] % MOD * invFact[x - y] % MOD;
    }
  }

  private void solve(Scanner in, PrintWriter out) {
    int N = in.nextInt();
    int A = in.nextInt();
    int B = in.nextInt();
    int C = in.nextInt();
    int D = in.nextInt();

    Combination combination = new Combination(N);

    long[][] dp = new long[N + 2][N + 2];
    dp[0][A] = 1;

    //dp[i][member] := i人を使ってmember人未満のチームで分ける方法
    for (int i = 0; i <= N; i++) {
      for (int member = A; member <= B; member++) {
        if (dp[i][member] <= 0) continue;
        dp[i][member + 1] += dp[i][member];
        dp[i][member + 1] %= MOD;

        long d = dp[i][member];
        for (int num = 1; num <= D; num++) {
          if (i + num * member > N) break;
          int remain = N - (i + (num - 1) * member);
          d *= combination.get(remain, member);
          d %= MOD;
          if (num < C) continue;
          long e = d * combination.invFact[num];
          e %= MOD;
          dp[i + num * member][member + 1] += e;
          dp[i + num * member][member + 1] %= MOD;
        }
      }
    }

    out.println(dp[N][B + 1]);

  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    new Main().solve(in, out);
    in.close();
    out.close();
  }
}
