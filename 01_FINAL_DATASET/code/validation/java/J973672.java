import java.io.*;
import java.util.*;

public class Main {
    private static boolean debug = true;
    private static boolean elapsed = true;

    private int N;
    private int T;
    private int[] A;

    private void solve(Scanner sc, PrintWriter out) {
        N = sc.nextInt();
        T = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;;
        int max = 0;
        int count = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] < min) {
                min = A[i];
            } else {
                int diff = A[i] - min;
                if (diff == max) {
                    ++count;
                } else if (diff > max) {
                    max = diff;
                    count = 1;
                }
            }
        }

        out.println(count);
    }
    /*
     * 10^10 > Integer.MAX_VALUE = 2147483647 > 10^9
     * 10^19 > Long.MAX_VALUE = 9223372036854775807L > 10^18
     */
    public static void main(String[] args) {
        long S = System.currentTimeMillis();

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().solve(sc, out);
        out.flush();

        long G = System.currentTimeMillis();
        if (elapsed) {
            System.err.println((G - S) + "ms");
        }
    }
}