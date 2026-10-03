import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by B1485 on 2016/05/28.
 */
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = new String(in.readLine());
        if ("T".compareTo(str.substring(str.length() - 1, str.length())) == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
