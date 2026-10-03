import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            char[] c = in.next().toCharArray();
            int n = c.length;

            int len = 1;
            int[] st = new int[n + 1];
            st[0] = n;
            boolean[] u = new boolean[26];
            int left = 26;
            int[][] first = new int[26][n + 1];
            for (int j = 0; j < 26; j++) {
                first[j][n] = n;
            }
            for (int i = n - 1; i >= 0; i--) {
                int v = c[i] - 'a';
                if (!u[v]) {
                    u[v] = true;
                    left--;
                }
                for (int j = 0; j < 26; j++) {
                    first[j][i] = first[j][i + 1];
                }
                first[v][i] = i;
                if (left == 0) {
                    st[len] = i;
                    len++;
                    Arrays.fill(u, false);
                    left = 26;
                }
            }
            StringBuilder ans = new StringBuilder();
            int p = 0;
            for (int i = len - 1; i >= 0; i--) {
                for (int j = 0; j < 26; j++) {
                    if (first[j][p] >= st[i]) {
                        p = first[j][p] + 1;
                        ans.append((char) ('a' + j));
                        break;
                    }
                }
            }
            out.println(ans);
        }

    }
}

