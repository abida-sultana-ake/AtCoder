import java.util.*;

public class Main {
  static int N;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    dfs("");
  }

  public static void dfs(String s) {
    if(s.length() == N) {
      System.out.println(s);
    } else {
      dfs(s + "a");
      dfs(s + "b");
      dfs(s + "c");
    }
  }
}