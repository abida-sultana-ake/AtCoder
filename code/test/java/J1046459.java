import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = sc.nextInt();
        String op = sc.next();
        int b = sc.nextInt();
        if (op.equals("+")) {
            System.out.println(a+b);
        } else {
            System.out.println(a-b);
        }
    }
}
