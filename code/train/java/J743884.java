import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w_1 = sc.nextInt();
        int h_1 = sc.nextInt();
        int w_2 = sc.nextInt();
        int h_2 = sc.nextInt();

        if (sameHeightable(w_1, h_1, w_2, h_2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean sameHeightable(int w_1, int h_1, int w_2, int h_2) {
        if (w_1 == w_2 || w_1 == h_2 || h_1 == w_2 || h_1 == h_2) {
            return true;
        } else {
            return false;
        }
    }
}