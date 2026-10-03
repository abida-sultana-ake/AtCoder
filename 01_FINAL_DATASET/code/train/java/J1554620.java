import java.util.*;

public class Main {
    
    static int N;
    static int[] widths;
    static int[] values;
    static int[][][] dp;

  public static void main(String[] args) {
   
      Scanner sc = new Scanner(System.in);          
      
      int W = sc.nextInt();
      N = sc.nextInt();
      int K = sc.nextInt();
      
      widths = new int[N];
      values = new int[N];
      
      for(int i = 0;i < N;i++){
          widths[i] = sc.nextInt();
          values[i] = sc.nextInt();          
      }
             
      dp = new int[N+1][K+1][W+1];
      
      for(int i = 0;i < dp.length;i++){
          for(int j = 0;j < dp[1].length;j++){
             for(int k = 0;k < dp[i][j].length;k++){
                 dp[i][j][k] = -1;
             }   
          }          
      }
      
      System.out.println(dfs(0,K,W));

  }  
  
  private static int dfs(int now,int nokoriNum,int nokoriWidth){
       
      if(dp[now][nokoriNum][nokoriWidth] != -1){
          return dp[now][nokoriNum][nokoriWidth];
      }
      
      int result;
      
      if(now == N || nokoriNum == 0){
          result = 0;
      }else if(nokoriWidth < widths[now]){
          result = dfs(now + 1,nokoriNum,nokoriWidth);
      }else{
          result = Math.max(dfs(now+1,nokoriNum - 1,nokoriWidth - widths[now]) + values[now]
                           ,dfs(now+1,nokoriNum,nokoriWidth));
      }      
      
      dp[now][nokoriNum][nokoriWidth] = result;
      return result;      
      
  }  
  
}