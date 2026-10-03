import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // 標準入力
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String str = br.readLine().toLowerCase();
            System.out.print(str.substring(0, 1).toUpperCase());
            System.out.println(str.substring(1, str.length()));
       } catch (IOException e) {
            e.printStackTrace();
       }
    }
}
