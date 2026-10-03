import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // 標準入力
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            int n = Integer.parseInt(br.readLine());
            int ans1 = n / 2;
            int ans2 = n % 2;
            System.out.println(ans1 + ans2);
       } catch (IOException e) {
            e.printStackTrace();
       }
    }
}
