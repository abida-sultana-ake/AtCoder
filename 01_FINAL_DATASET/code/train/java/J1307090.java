import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long s = sc.nextLong();
    long ans = -1;
    long b;
    if(s < n + 1) {
      long i;
      for(i = 1; i * i < n; i++) {
        if((n - s) % i == 0) {
          if(func(i + 1, n) == s) {
            if(ans > -1) {
              ans = Math.min(i + 1, ans);
            } else {
              ans = i + 1;
            }
          }
          if(func((n - s) / i + 1, n) == s) {
            if(ans > -1) {
              ans = Math.min((n - s) / i + 1, ans);
            } else {
              ans = (n - s) / i + 1;
            }
          }
        }
      }
      if(ans == -1 && s == n) ans = n + 1;
    }
    System.out.println(ans);
  }

  public static long func(long b, long n) {
    if(b > n) return n;
    if(b == 1) return 0;
    return func(b, n / b) + (n % b);
  }
}