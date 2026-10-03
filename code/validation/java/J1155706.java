import java.util.*;

public class Main {
  static long MOD = 1000000007;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long W = sc.nextLong();
    long H = sc.nextLong();
    long r1 = 1;
    long r2 = 1;
    for(int i = 0; i < H - 1; i++) {
      r1 = (r1 * (W + (long)i)) % MOD;
      r2 = (r2 * (long)(i + 1)) % MOD;
    }
    System.out.println((r1 * func(r2, MOD - 2)) % MOD);
  }

  public static long func(long x, long s) {
    if(s == 0) return 1;
    if(s % 2 == 0) {
      long t = func(x, s / 2);
      return (t * t) % MOD;
    } else {
      long t = func(x, (s - 1) / 2);
      t = (t * t) % MOD;
      return (t * x) % MOD;
    }
  }
}