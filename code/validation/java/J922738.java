import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    new Main().run();
  }

  void run() {
    System.out.println(IntStream.rangeClosed(1, ni()).reduce(0, (a, b) -> a + b));
  }

  int ni() {
    return Integer.parseInt(sc.next());
  }

  void debug(Object... os) {
    System.err.println(Arrays.deepToString(os));
  }
}