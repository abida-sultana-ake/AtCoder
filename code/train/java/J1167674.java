import java.util.Scanner;

/**
 * Created by zzt on 17-3-18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int i = 1;
        int sum = 0;
        while (sum<x) {
            sum += i++;
        }
        System.out.println(i-1);
    }
}