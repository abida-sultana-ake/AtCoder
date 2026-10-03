import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int h = scan.nextInt();

        System.out.println(String.valueOf((a+b)*h/2));


    }
}
