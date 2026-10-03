import java.util.Scanner;

/**
 * Created by sonetsuyoshi on 2015/12/21.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int n = (b - 1) / a + 1;
        System.out.println(n);
    }
}