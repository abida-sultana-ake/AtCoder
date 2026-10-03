import java.util.*;

public class Main{

  static int h,w;
  static int table[][];
  static int dp[][];
  static final int dx[]={0, -1, 0, 1};
  static final int dy[]={-1, 0, 1, 0};//gyaku tokei mawari
  static final int bignum=1000000000+7;
  public static void main(String args[]){

    Scanner scan = new Scanner(System.in);
    h=scan.nextInt();
    w=scan.nextInt();
    //省スペースのため
    table = new int[h+1][w+1];

    for(int ih=0;ih<h;ih++)
      for(int iw=0;iw<w;iw++)
        table[ih+1][iw+1]=scan.nextInt();

    dp = new int[h+1][w+1];

    int sum=0;
    for(int ih=0;ih<h;ih++)
      for(int iw=0;iw<w;iw++){
        sum+=backtrack(ih+1, iw+1);
        sum%=bignum;
      }
    System.out.println(sum);
  }

  public static int backtrack(int i, int j){
    if(dp[i][j] != 0)
      return dp[i][j];

    int tmp = 1;
    for(int m=0;m<4;m++){
      if(!(i+dy[m] >= 1 && i+dy[m] <= h) || !(j+dx[m] >= 1 && j+dx[m] <= w))
        continue;
      if(table[i][j] < table[i+dy[m]][j+dx[m]]){
        tmp+=(backtrack(i+dy[m], j+dx[m])%bignum);
        tmp%=bignum;
      }
    }
    return dp[i][j]=tmp;
  }
}
