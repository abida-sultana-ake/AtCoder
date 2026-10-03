import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // 標準入力
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String n = br.readLine();
            if (n.charAt(0) == n.charAt(2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } catch (IOException e) {
            e.printStackTrace();
           }
    }
}
