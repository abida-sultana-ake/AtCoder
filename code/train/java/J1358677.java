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
            int ans = 100 * (n / 10);
            n = n % 10;
            if (n >= 7) {
                ans += 100;
            } else {
                ans += 15 * n;
            }
            System.out.println(ans);
        } catch (IOException e) {
            e.printStackTrace();
           }
    }
}
