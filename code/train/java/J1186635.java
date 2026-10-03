import java.util.Scanner;

public class Main {
    private static int countDigits(long x) {
        int result = 0;
        while (x > 0) {
            result++;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int result = Integer.MAX_VALUE;
        for (long i = 1; i * i <= n; i++) {
            if (n % i > 0) {
                continue;
            }
            result = Math.min(result, Math.max(countDigits(i), countDigits(n / i)));
        }
        System.out.println(result);
    }
}