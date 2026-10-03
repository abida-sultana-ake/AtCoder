import java.util.Scanner;

/**
 * Created by User on 2017/02/07.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int max = 0;
        int x = 0;
        String s = scn.next();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                x++;
                if (x > max) {
                   max = x;
                }
            } else {
                x--;
            }
        }
        System.out.println(max);
    }
}
