import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    void solve() throws IOException {
        n = ni();

        int m = ni();

        for (int i = 0; i < n; i++) {
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = ni() - 1;
            int b = ni() - 1;

            G.get(a).add(b);
            G.get(b).add(a);
        }

        dfs(0, 1);
        out.println(ans);
    }

    ArrayList<ArrayList<Integer>> G = new ArrayList<>();
    int ans = 0;
    int n;

    void dfs(int x, int state) {
        state |= 1 << x;

        if ((1 << n) - 1 == state) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (G.get(x).contains(i) && (state & 1 << i) == 0) {
                dfs(i, state | 1 << i);
            }
        }
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