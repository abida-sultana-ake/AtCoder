import java.util.Arrays;
import java.util.Scanner;

public class Main {
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    new Main().run();
  }

  long dfs(int depth, String str) {
    if (depth == str.length() - 1) {
      debug(str);
      String[] sp = str.split("\\+");
      long sum = 0;
      for (int i = 0; i < sp.length; ++i) {
        sum += Long.parseLong(sp[i]);
      }
      return sum;
    }
    long sum = 0;
    sum += dfs(depth + 1, str);
    str = str.substring(0, depth + 1) + "+" + str.substring(depth + 1);
    sum += dfs(depth + 2, str);
    return sum;
  }

  void run() {
    String str = sc.next();

    System.out.println(dfs(0, str));
  }

  int ni() {
    return Integer.parseInt(sc.next());
  }

  void debug(Object... os) {
    System.err.println(Arrays.deepToString(os));
  }
}