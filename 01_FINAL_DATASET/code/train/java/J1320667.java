import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author acesine
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        A solver = new A();
        solver.solve(1, in, out);
        out.close();
    }

    static class A {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int[] group = new int[]{0, 2, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0};
            int x = in.nextInt(), y = in.nextInt();
            if (group[x - 1] == group[y - 1]) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }

    }
}

