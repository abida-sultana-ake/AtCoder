import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.lang.Integer;
import java.lang.StringBuilder;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long max = 1000000007;

        long power = 1;
        for (int i = 1; i <= N; i++) {
            power *= i;
            power %= max;
        }

        System.out.println(power);
    }
}