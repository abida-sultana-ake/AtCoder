import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author zhangyong
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int l, r;
            int[] arr1 = new int[n + 1], arr2 = new int[n + 1];

            for (int i = 0; i < m; i++) {
                l = in.nextInt();
                r = in.nextInt();
                if (l == 1) {
                    arr2[r] = 1;
                }
                if (r == n) {
                    arr1[l] = 1;
                }
            }
            int index = -1;
            for (int i = 2; i < n; i++) {
                if (arr1[i] == 1 && arr2[i] == 1) {
                    out.println("POSSIBLE");
                    index = 1;
                }
            }
            if (index == -1) {
                out.println("IMPOSSIBLE ");
            }
        }

    }
}

