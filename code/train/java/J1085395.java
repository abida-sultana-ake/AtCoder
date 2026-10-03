import java.util.Scanner;

/**
 * Created by zzt on 17-1-29.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long ret = (x/11)*2;
        long mod = x % 11;
        if (mod!=0)
            ret++;
        if (mod>6)
            ret++;
        System.out.println(ret);
    }
}