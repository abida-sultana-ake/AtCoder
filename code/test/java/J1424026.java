import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author G. Guarnieri
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
            long[] accumulated = new long[n];
            for (int i = 0; i < n; i++) {
                long previous = (i > 0) ? accumulated[i - 1] : 0L;
                accumulated[i] = previous + in.nextLong();
            }
            long min = Long.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                long newTotal = Math.abs(2 * accumulated[i] - accumulated[n - 1]);
                min = min < newTotal ? min : newTotal;
            }

            out.println(min);
        }

    }
}

