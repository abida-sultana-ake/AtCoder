import java.util.Scanner;

/**
 * Created by ryosuke on 2016/06/18.
 */
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        double N = Double.parseDouble(scanner.next());
        System.out.print((int)(Math.sqrt(Math.sqrt(N))));
    }
}