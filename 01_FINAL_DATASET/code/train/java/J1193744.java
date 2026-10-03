
import java.util.Scanner;

public class Main {
    public static int g(long x) {
        int res = 0;
        while (x > 0) {
            ++res;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int res = Integer.MAX_VALUE;
        for (long i = 1; i * i <= N; ++i) {
            if (N % i == 0) {
                long a = N / i;
                res = Math.min(res, Math.max(g(i), g(a)));
            }
        }
        System.out.println(res);
    }
}