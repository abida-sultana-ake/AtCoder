import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a > b) {
            if (a > c ) {
                output(a - b == c);
            } else output(c-a == b);
        } else if (b > c) {
            output(b-c == a);
        } else {
            output(c -b ==a );
        }
    }

    static private void output(boolean b) {
        String r = b ? "Yes" : "No";
        System.out.println(r);
    }
}
