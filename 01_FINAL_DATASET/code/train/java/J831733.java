import java.util.*;


public class Main {
  static final long MOD = 1000000007;
  static int H, W, A, B;
  static long[] fact, ifact;

  public static long modInv(long n) {
    return (euqlidNormal(MOD, n)[1] + MOD) % MOD;
  }

  public static long[] euqlidNormal(long a, long b) {
    long ret[] = new long[2];
    long q = a / b;
    long r = a % b;
    if(r == 1) {
      ret[0] = 1;
      ret[1] = -q;
    } else {
      long[] rec = euqlidNormal(b, r);
      ret[0] = rec[1];
      ret[1] = rec[0] - q * rec[1];
    }
    return ret;
  }

  public static long path(int h, int w) {
    long l = fact[h + w - 2];
    l = (l * ifact[h - 1]) % MOD;
    l = (l * ifact[w - 1]) % MOD;
    return l;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    H = sc.nextInt();
    W = sc.nextInt();
    A = sc.nextInt();
    B = sc.nextInt();

    fact = new long[H + W + 1];
    ifact = new long[H + W + 1];
    fact[0] = 1;
    fact[1] = 1;
    ifact[0] = 1;
    ifact[1] = 1;
    for(int i = 2; i <= H + W; i++) {
      fact[i] = i * fact[i - 1] % MOD;
      ifact[i] = modInv(fact[i]);
    }

    long n = 0;
    for(int i = 1; i <= H - A; i++) {
      n += (path(i, B) * path(H - i + 1, W - B)) % MOD;
      n %= MOD;
    }

    System.out.println(n);
  }
}
