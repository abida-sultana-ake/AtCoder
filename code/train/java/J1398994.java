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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String str = in.next();
            int len = 0;
            for (int i = str.length() / 2 - 1; i >= 0; i--) {
                if (str.substring(0, i).equals(str.substring(i, 2 * i))) {
                    len = 2 * i;
                    break;
                }
            }
            out.print(len);
        }

    }
}

