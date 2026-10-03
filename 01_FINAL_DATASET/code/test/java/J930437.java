import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String g = sc.next();
        System.out.println(cal(g));
    }

    private static int cal(final String g) {
        char[] ch =
                g.toCharArray();
        int n = 0;
        for (char c : ch) {
            if (c == 'g') {
                n ++;
            } else {
                n --;
            }
        }
        return n <= 0 ? 0 : n/2;
    }
}
