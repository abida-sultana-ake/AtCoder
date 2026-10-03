
import java.util.Scanner;

public class Main {

    //dp[i] = max(dp[i-1],dp[i-wi]+vi);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] array = new int[N];
        for (int i = 0; i< array.length; i++) {
            array[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i = 0 ; i < array.length; i++) {
//            System.out.println((i+1) + "," + array[i]);
            if (i + 1 == array[i]) {
                cnt++;
                if (i < array.length -1 && array[i+1] == i + 2) {
                    i++;
                }
            }

        }

        System.out.println(cnt);

        sc.close();

    }

}
