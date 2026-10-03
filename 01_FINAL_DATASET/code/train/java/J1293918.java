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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String s = in.next();
            String ss = in.next();
            String ans = "";
            int i = 0, j = 0, cnt = 1;
            while (cnt != s.length() + ss.length() + 1) {
                if (cnt % 2 != 0) {
                    ans += s.charAt(i);
                    i++;
                } else {
                    ans += ss.charAt(j);
                    j++;
                }
                cnt++;
            }
            out.println(ans);
        }

    }
}

