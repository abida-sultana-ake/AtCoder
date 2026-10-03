import java.util.*;
import java.io.*;

public class Main {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer stok;

    String nextToken() throws IOException {
        while (stok == null || !stok.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null) {
                return null;
            }
            stok = new StringTokenizer(s);
        }
        return stok.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    char nextChar() throws IOException {
        return (char) (br.read());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }

    void solve() throws IOException {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        if (a==b) out.println(c);
        if (a==c) out.println(b);
        if (c==b) out.println(a);

    }

    void run() throws IOException {
        // br = new BufferedReader(new FileReader("dragons.in"));
        //out = new PrintWriter("dragons.out");
        // br = new BufferedReader(new FileReader("input.txt"));
        // out = new PrintWriter("output.txt");
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        br.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        // Locale.setDefault(Locale.US);
        new Main().run();
    }
}