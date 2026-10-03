import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code her
        Scanner sc = new Scanner(System.in);
        // get a integer
        int a = sc.nextInt();
        // get two integers separated with half-width break
        int b = sc.nextInt();
        int c = sc.nextInt();
        if ((a == b + c) ||
                (b == a +c) ||
                (c == a + b)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}