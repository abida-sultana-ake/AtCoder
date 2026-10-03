import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            // 標準入力
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String strArr[] = br.readLine().split(" ");
            int n = Integer.parseInt(strArr[0]);
            int k = Integer.parseInt(strArr[1]);
            strArr = br.readLine().split(" ");
            int r[] = new int[n];
            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(strArr[i]);
            }
            Arrays.sort(r);
            double rate = 0;
            for (int i = n - k; i < n; i++) {
                rate = (rate + r[i]) / 2;
            }
            System.out.println(rate);
        } catch (IOException e) {
            e.printStackTrace();
           }
    }
}
