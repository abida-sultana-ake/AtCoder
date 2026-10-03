import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // 標準入力
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String x = br.readLine();
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                String tmp = s.substring(i, i + 1);
                if (!x.equals(tmp)) {
                    System.out.print(tmp);
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
           }
    }
}
