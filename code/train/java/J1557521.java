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
        A solver = new A();
        solver.solve(1, in, out);
        out.close();
    }

    static class A {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int[] cnt = new int[100_002];
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                cnt[x + 1]++;
            }

            int ans = 0;
            for (int i = 1; i < cnt.length - 1; i++) {
                int v = cnt[i - 1] + cnt[i] + cnt[i + 1];
                if (v > ans) {
                    ans = v;
                }
            }
            out.println(ans);
        }

    }
}

