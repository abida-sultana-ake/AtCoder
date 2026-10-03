import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int minimum = Math.min(adjust(a-b),adjust(b-a));
        System.out.println(minimum);
    }

    private static int adjust(int n) {
        if (n < 0) {
            return n + 10;
        } else {
            return n;
        }
    }
}
