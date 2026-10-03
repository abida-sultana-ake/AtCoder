import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    long[][] dp;
    int h, w;
    int[][] a;
    int MOD = (int) 1e9 + 7;

    void solve() throws IOException {
        h = ni();
        w = ni();
        a = new int[h][];
        for (int i = 0; i < h; i++) {
            a[i] = nia(w);
        }

        dp = new long[h][w];

        long ans = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ans = (ans + rec(i, j)) % MOD;
            }
        }

        out.println(ans);
    }

    long rec(int y, int x) {
        if (dp[y][x] > 0) return dp[y][x];

        long ans = 1;
        if (y > 0 && a[y][x] > a[y - 1][x]) ans = (ans + rec(y - 1, x)) % MOD;
        if (y < h - 1 && a[y][x] > a[y + 1][x]) ans = (ans + rec(y + 1, x)) % MOD;
        if (x > 0 && a[y][x] > a[y][x - 1]) ans = (ans + rec(y, x - 1)) % MOD;
        if (x < w - 1 && a[y][x] > a[y][x + 1]) ans = (ans + rec(y, x + 1)) % MOD;

        return dp[y][x] = ans;
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

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        tok = new StringTokenizer("");
        Main main = new Main();
        main.solve();
        out.close();
    }
}