import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String X = sc.next();
    String ans = "NO";
    if(choku(X)) ans = "YES";
    System.out.println(ans);
  }

  public static boolean choku(String s) {
    boolean ans = false;
    if(s.equals("")) {
      ans = true;
    } else {
      if(s.charAt(s.length() - 1) == 'o' || s.charAt(s.length() - 1) == 'k' || s.charAt(s.length() - 1) == 'u') {
        ans = choku(s.substring(0, s.length() - 1));
      } else {
        if(s.length() >= 2 && s.charAt(s.length() - 2) == 'c' && s.charAt(s.length() - 1) == 'h') ans = choku(s.substring(0, s.length() - 2));
      }
    }
    return ans;
  }
}