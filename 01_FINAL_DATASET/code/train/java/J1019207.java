import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    new Main().c();

  }

  private void c() {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {

      String s = in.nextLine();

      System.out.println(solve(s));
    }
  }

  private String solve(String s) {

    int index = s.length();

    while (index > 0) {
      if (s.regionMatches(index - 7, "dreamer", 0, 7)) {
        index -= 7;
      } else if (s.regionMatches(index - 6, "eraser", 0, 6)) {
        index -= 6;
      } else if (s.regionMatches(index - 5, "dream", 0, 5) || s.regionMatches(index - 5, "erase", 0, 5)) {
        index -= 5;
      } else {
        return "NO";
      }
    }

    return "YES";
  }
}
