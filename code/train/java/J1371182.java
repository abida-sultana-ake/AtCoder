import java.util.Scanner;

class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        long a = in.nextLong(), b = in.nextLong(), x = in.nextLong();
        long sum = 0;
        System.out.println(b / x - a / x + (a % x == 0 ? 1 : 0));
    }
}
