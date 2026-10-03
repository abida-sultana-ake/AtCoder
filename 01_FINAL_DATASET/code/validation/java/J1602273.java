import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author CodeMonk
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            int n = in.nextInt();
            int[][] arr = new int[1000][1000];
            int[][] b = new int[1000][1000];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                    b[i][j] = arr[i][j];
                }
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i][k] + arr[k][j] < arr[i][j]) {
                            arr[i][j] = arr[i][k] + arr[k][j];
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (b[i][j] != arr[i][j]) {
                        out.println(-1);
                        return;
                    }
                }
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                inner:
                for (int j = i + 1; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            if (arr[i][j] == arr[i][k] + arr[k][j]) continue inner;
                        }
                    }
                    ans += arr[i][j];
                }
            }
            out.println(ans);
        }

    }
}

