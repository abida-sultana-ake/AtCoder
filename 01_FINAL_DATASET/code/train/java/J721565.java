import java.util.Scanner;

class Main{
  static int[][] arr;
  static int[][] dp;
  static int input1,input2;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    input1 = scan.nextInt();
    input2 = scan.nextInt();

    arr = new int[input1][input2];
    dp = new int[input1][input2];

    for(int i = 0; i < input1; i++) {
      for(int j = 0; j < input2; j++) {
        arr[i][j] = scan.nextInt();
      }
    }

    long ans = 0;
    for(int i = 0; i < input1; i++) {
      for(int j = 0; j < input2; j++) {
        ans += calc(i,j);
      }
    }

    System.out.println(ans%1000000007L);
  }

  static int calc(int i, int j) {
    if(dp[i][j]>0) return dp[i][j];
    long ans = 0;
    if(i>0 && arr[i][j]<arr[i-1][j]) {
      if(dp[i-1][j]<=0) dp[i-1][j] = calc(i-1,j);
      ans += dp[i-1][j];
    }
    if(j>0 && arr[i][j]<arr[i][j-1]) {
      if(dp[i][j-1]<=0) dp[i][j-1] = calc(i,j-1);
      ans += dp[i][j-1];
    }
    if(i<input1-1 && arr[i][j]<arr[i+1][j]) {
      if(dp[i+1][j]<=0) dp[i+1][j] = calc(i+1,j);
      ans += dp[i+1][j];
    }
    if(j<input2-1 && arr[i][j]<arr[i][j+1]) {
      if(dp[i][j+1]<=0) dp[i][j+1] = calc(i,j+1);
      ans += dp[i][j+1];
    }
    ans++;
    dp[i][j] = (int)(ans%1000000007L);
    return dp[i][j];
  }
}
