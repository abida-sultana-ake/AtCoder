import java.util.*;
import java.lang.*;


class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
       // int[][] seats = new int[N][2];
        int seats = 0;
        for (int i = 0; i < N; i++) {
            int l1 = in.nextInt();
            int r1 = in.nextInt();
            seats += r1-l1+1;
        }
        System.out.println(seats);
    }
}