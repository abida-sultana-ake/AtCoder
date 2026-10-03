import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] a = new long[n];
        long sum = 0;

        long stack = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            stack += a[i];
            if (i >= k - 1) {
                if (i >= k) {
                    stack -= a[i - k];
                }
                sum += stack;
            }
            // System.out.println(stack);
        }
        System.out.println(sum);

        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int k = sc.nextInt();
        // int[] a = new int[n];
        // long sum = 0;
        // int t = n - k + 1;

        // for (int i = 0; i < n; i++) {
        //     a[i] = sc.nextInt();
        //     sum += a[i] * Math.min(t, Math.min(i + 1, n - i));
        // }
        // System.out.println(sum);
    }
}