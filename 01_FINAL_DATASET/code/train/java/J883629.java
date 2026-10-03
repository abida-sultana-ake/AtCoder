import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int top = scan.nextInt();
        int bottom = scan.nextInt();
        int hight = scan.nextInt();
        check_input(top);
        check_input(bottom);
        check_input(hight);
        System.out.println((top + bottom) * hight / 2);
    }
    public static void check_input(int num) {
        if(num < 1 || num > 100) {
            System.exit(-1);
        }
    }
}