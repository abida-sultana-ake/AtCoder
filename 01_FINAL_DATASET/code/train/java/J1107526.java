import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    void solve() throws IOException {
        int n = ni();
        int ma = ni(), mb = ni();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
            b[i] = ni();
            c[i] = ni();
        }

        int[][] dp = new int[401][401];
        for (int i = 0; i < 401; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 400; j >= 0; j--) {
                for (int k = 400; k >= 0; k--) {
                    if (j + a[i] <= 400 && k + b[i] <= 400) {
                        dp[j + a[i]][k + b[i]] = Math.min(dp[j + a[i]][k + b[i]], dp[j][k] + c[i]);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE / 2;
        for (int i = 1; i * ma <= 400 && i * mb <= 400; i++) {
            ans = Math.min(ans, dp[i * ma][i * mb]);
        }
        out.println(ans == Integer.MAX_VALUE / 2 ? -1 : ans);
    }

    String ns() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine(), " ");
        }
        return tok.nextToken();
    }

    int ni() throws IOException {
        return Integer.parseInt(ns());
    }

    long nl() throws IOException {
        return Long.parseLong(ns());
    }

    double nd() throws IOException {
        return Double.parseDouble(ns());
    }

    String[] nsa(int n) throws IOException {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = ns();
        }
        return res;
    }

    int[] nia(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ni();
        }
        return res;
    }

    long[] nla(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = nl();
        }
        return res;
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        tok = new StringTokenizer("");
        Main main = new Main();
        main.solve();
        out.close();
    }
}