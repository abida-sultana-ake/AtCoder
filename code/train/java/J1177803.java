import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long R = sc.nextLong();
    long C = sc.nextLong();
    long X = sc.nextLong();
    long Y = sc.nextLong();
    int D = sc.nextInt();
    int L = sc.nextInt();
    long MOD = 1000000007;
    long ans = (R - X + 1) * (C - Y + 1);
    long[][] dp = new long[901][901];
    dp[0][0] = 1;
    for(int i = 1; i < 901; i++) {
      for(int j = 0; j <= i; j++) {
        if(j == 0 || j == i) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % MOD;
        }
      }
    }
    long sum = 0;
    long sub = 0;
    // 上の辺、右の辺、下の辺、左の辺をそれぞれA,B,C,Dとおく。
    // X*Yに置く置き方
    sum = (dp[(int)(X * Y)][D + L] * dp[D + L][D]) % MOD;

    // Aに置かない置き方
    sub = (sub + dp[(int)((X - 1) * Y)][D + L] * dp[D + L][D]) % MOD;
    // Bに置かない置き方
    sub = (sub + dp[(int)(X * (Y - 1))][D + L] * dp[D + L][D]) % MOD;
    // Cに置かない置き方
    sub = (sub + dp[(int)((X - 1) * Y)][D + L] * dp[D + L][D]) % MOD;
    // Dに置かない置き方
    sub = (sub + dp[(int)(X * (Y - 1))][D + L] * dp[D + L][D]) % MOD;

    // A,Bに置かない置き方
    long t1 = (dp[(int)((X - 1) * (Y - 1))][D + L] * dp[D + L][D]) % MOD;
    if(sub >= t1) {
      sub = (sub - t1) % MOD;
    } else {
      sub = (sub - t1 + MOD) % MOD;
    }
    // A,Cに置かない置き方
    if(X > 2) {
      long t2 = (dp[(int)((X - 2) * Y)][D + L] * dp[D + L][D]) % MOD;
      if(sub >= t2) {
        sub = (sub - t2) % MOD;
      } else {
        sub = (sub - t2 + MOD) % MOD;
      }
    }
    // A,Dに置かない置き方
    long t3 = (dp[(int)((X - 1) * (Y - 1))][D + L] * dp[D + L][D]) % MOD;
    if(sub >= t3) {
      sub = (sub - t3) % MOD;
    } else {
      sub = (sub - t3 + MOD) % MOD;
    }
    // B,Cに置かない置き方
    long t4 = (dp[(int)((X - 1) * (Y - 1))][D + L] * dp[D + L][D]) % MOD;
    if(sub >= t4) {
      sub = (sub - t4) % MOD;
    } else {
      sub = (sub - t4 + MOD) % MOD;
    }
    // B,Dに置かない置き方
    if(Y > 2) {
      long t5 = (dp[(int)(X * (Y - 2))][D + L] * dp[D + L][D]) % MOD;
      if(sub >= t5) {
        sub = (sub - t5) % MOD;
      } else {
        sub = (sub - t5 + MOD) % MOD;
      }
    }
    // C,Dに置かない置き方
    long t6 = (dp[(int)((X - 1) * (Y - 1))][D + L] * dp[D + L][D]) % MOD;
    if(sub >= t6) {
      sub = (sub - t6) % MOD;
    } else {
      sub = (sub - t6 + MOD) % MOD;
    }

    // A,B,Cに置かない置き方
    if(X > 2 && Y > 1) {
      sub = (sub + dp[(int)((X - 2) * (Y - 1))][D + L] * dp[D + L][D]) % MOD;
    }
    // A,B,Dに置かない置き方
    if(X > 1 && Y > 2) {
      sub = (sub + dp[(int)((X - 1) * (Y - 2))][D + L] * dp[D + L][D]) % MOD;
    }
    // A,C,Dに置かない置き方
    if(X > 2 && Y > 1) {
      sub = (sub + dp[(int)((X - 2) * (Y - 1))][D + L] * dp[D + L][D]) % MOD;
    }
    // B,C,Dに置かない置き方
    if(X > 1 && Y > 2) {
      sub = (sub + dp[(int)((X - 1) * (Y - 2))][D + L] * dp[D + L][D]) % MOD;
    }

    // A,B,C,Dに置かない置き方
    if(X > 2 && Y > 2) {
      long t7 = (dp[(int)((X - 2) * (Y - 2))][D + L] * dp[D + L][D]) % MOD;
      if(sub >= t7) {
        sub = (sub - t7) % MOD;
      } else {
        sub = (sub - t7 + MOD) % MOD;
      }
    }

    long t8 = 0;
    if(sum >= sub) {
      t8 = (sum - sub) % MOD;
    } else {
      t8 = (sum - sub + MOD) % MOD;
    }
    ans = (ans * t8) % MOD;
    System.out.println(ans);
  }
}