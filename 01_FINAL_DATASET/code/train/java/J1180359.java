import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long A = sc.nextLong();
    long B = sc.nextLong();
    System.out.println(func(B) - func(A - 1));
  }
  // 0～xで禁止された数の個数
  public static long func(long x) {
    if(x == 0) {
      return 0;
    } else {
      // 桁数-1
      long digit = 0;
      // 最高桁の数字
      long num = 0;
      for(int i = 0; i <= 19; i++) {
        if(x / (long)Math.pow(10, i) > 0) {
          num = x / (long)Math.pow(10, i);
        } else {
          digit = i - 1;
          break;
        }
      }
      // 最高桁に使える数字の個数
      long use = 0;
      if(num < 4) {
        use = num + 1;
      } else if(num < 9) {
        use = num;
      } else {
        use = num - 1;
      }
      if(num == 4 || num == 9) {
        return x + 1 - use * (long)Math.pow(8, digit);
      } else {
        long e = x - num * (long)Math.pow(10, digit);
        return x + 1 - (use - 1) * (long)Math.pow(8, digit) - (e + 1 - func(e));
      }
    }
  }
}