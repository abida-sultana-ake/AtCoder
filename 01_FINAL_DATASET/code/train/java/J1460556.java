import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner sn, PrintWriter out) {
            int a = sn.nextInt();
            int b = sn.nextInt();
            int c = sn.nextInt();
            int min1 = Math.min(Math.min(a, b), c);
            int min2 = 0;
            if (min1 == a) {
                min2 = Math.min(c, b);
            } else if (min1 == b) {
                min2 = Math.min(a, c);
            } else if (min1 == c) {
                min2 = Math.min(a, b);
            }
            out.println(min1 + min2);

        }

    }
}

