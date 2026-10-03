import java.util.*;


/**
 * Created by santa on 2016/10/16.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {

            a[i] = scanner.nextInt();

        }
        Arrays.sort(a);
        System.out.println(a[N-1] - a[0]);

    }// mainMethod




} // MainClass
