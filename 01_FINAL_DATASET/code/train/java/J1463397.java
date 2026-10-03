import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // 標準入力
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            int num = Integer.parseInt(br.readLine());
            int max = num;
            int maxCount = 0;
            for (int i = num; i > 0; i--) {
                int tmp = checkCount(i);
                if (maxCount < tmp) {
                    max = i;
                    maxCount = tmp;
                }
            }
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
           }
    }

    public static int checkCount(int num) {
        int ret = 0;
        while (true) {
            if (num % 2 == 0) {
                num = num / 2;
                ret++;
            } else {
                break;
            }
        }
        return ret;
    }
}