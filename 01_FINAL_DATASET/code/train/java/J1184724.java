import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final long MAX = 10000000000l;
    public static void main(String[] args) {
        try {
            // 標準入力
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            long n = Long.parseLong(br.readLine());
            long min = digit(n);
            for (long i = 1; i * i <= n; i++) {
                if (n % i != 0) {
                    continue;
                }
                long j = n / i;
                long temp = 0;
                if (digit(i) > digit(j)) {
                    temp = digit(i);
                } else {
                    temp = digit(j);
                }
                if (min > temp) {
                    min = temp;
                }
            }
            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int digit(long num) {
        return String.valueOf(num).length();
    }
}