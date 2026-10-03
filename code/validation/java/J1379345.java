import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Weichao Luo
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
            final long mod = (long) 1e9 + 7;
            int n = in.nextInt();
            int m = in.nextInt();
            if (n < m) {
                int t = m;
                m = n;
                n = t;
            }
            if (n - m >= 2) {
                out.println(0);
                return;
            }
            if (n == m + 1) {
                long ret = 1;
                for (int i = 1; i <= m; i++) {
                    ret = ret * i % mod * i % mod;
                }
                ret = ret * n % mod;
                out.println(ret);
            } else {
                long ret = 2;
                for (int i = 1; i <= n; i++)
                    ret = ret * i % mod * i % mod;
                out.println(ret);
            }

        }

    }
}

