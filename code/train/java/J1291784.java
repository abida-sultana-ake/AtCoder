import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        //kが0回の場合

        //kが1回の場合
        double b = n-k; //kより大きい数字の数
        double s = k-1; //kより小さい数字の数
        double result_1 = b * s * 6;

        //kが2回の場合
        double o = n-1; //k以外の数字の数
        double result_2 = o * 3;

        //kが3回の場合
        double result_3 = 1;

        double result = (result_1 + result_2 + result_3) / Math.pow(n, 3);

        System.out.println(result);
    }
}