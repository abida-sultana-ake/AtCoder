import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader sr = new BufferedReader(new InputStreamReader(System.in));
    Display display1 = new Display(sr.readLine());
    Display display2 = new Display(sr.readLine());
    if(display1.check(display2)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
  
  static class Display {
    private final int width;
    private final int height;
    public Display(String input) {
      String[] value = input.split(" ");
      if(value.length != 2) {
        throw new IllegalArgumentException();
      }
      width = Integer.parseInt(value[0]);
      height = Integer.parseInt(value[1]);
    }
    
    public boolean check(Display another) {
      return this.width  == another.width  ||
             this.width  == another.height ||
             this.height == another.width  ||
             this.height == another.height;
    }
  }
}