import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // 標準入力
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            if ("a".equals(s)) {
                System.out.println(-1);
            } else {
                System.out.println("a");
            }
       } catch (IOException e) {
            e.printStackTrace();
       }
    }
}
