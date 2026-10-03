import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int N = in.nextInt();
        System.out.println((int)Math.sqrt(Math.sqrt(N)));
    }
}
