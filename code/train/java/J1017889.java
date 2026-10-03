import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    void solve() throws IOException {
        String s = ns();

        int idx = s.length();
        while (idx > 0) {
            if (idx - 7 >= 0 && s.substring(idx - 7, idx).equals("dreamer")) {
                idx -= 7;
            } else if (idx - 5 >= 0 && s.substring(idx - 5, idx).equals("dream")) {
                idx -= 5;
            } else if (idx - 5 >= 0 && s.substring(idx - 5, idx).equals("erase")) {
                idx -= 5;
            } else if (idx - 6 >= 0 && s.substring(idx - 6, idx).equals("eraser")) {
                idx -= 6;
            } else {
                break;
            }
        }

        if (idx == 0) {
            out.println("YES");
        } else {
            out.println("NO");
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

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        tok = new StringTokenizer("");
        Main main = new Main();
        main.solve();
        out.close();
    }
}