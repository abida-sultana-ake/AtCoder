import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // 標準入力
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            int y  = Integer.parseInt(br.readLine());
            if (y % 4 == 0) {
                if (y % 100 == 0) {
                    if (y % 400 == 0) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                } else {
                    System.out.println("YES");
                }
            } else {
                System.out.println("NO");
            }
       } catch (IOException e) {
            e.printStackTrace();
        }
    }
}