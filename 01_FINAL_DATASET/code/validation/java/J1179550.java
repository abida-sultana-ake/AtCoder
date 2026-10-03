import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] c = new int[N];
    for(int i = 0; i < N; i++) {
      c[i] = sc.nextInt();
    }
    // dp[i]はインデックスiを右端とした単調増加部分列の長さの最大値
    int[] dp = new int[N];
    dp[0] = 1;
    for(int i = 1; i < N; i++) {
      int length = 1;
      for(int j = 0; j < i; j++) {
        if(c[j] < c[i]) {
          length = Math.max(length, dp[j] + 1);
        }
      }
      dp[i] = length;
    }
    int maxLength = 0;
    for(int i = 0; i < N; i++) {
      maxLength = Math.max(maxLength, dp[i]);
    }
    System.out.println(N - maxLength);
  }
}