import java.util.Scanner;

/**
 *
 * @author Cummin 2016.07.03
 */
public class Main{

    static long A, B, C;

    public static void main(String[] args) {
        // データの読み込み
        Scanner sc = new Scanner(System.in);
        //
        A = sc.nextLong();
        B = sc.nextLong();
        C = sc.nextLong();
        long X = 1000000007L;

        System.out.println((((A % X) * (B % X)) % X * (C % X) % X));

    }

}
