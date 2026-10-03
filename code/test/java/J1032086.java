import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static int MOD = 1000000007;

    void solve() throws IOException {

    	int n = ni();
    	int[] t = new int[n];

    	for(int i=0; i<n; i++){
    		t[i] = ni();
    	}

    	int m = ni();

    	int[] p = new int[m];
    	int[] x = new int[m];

    	for(int i=0; i<m; i++){
    		p[i] = ni();
    		x[i] = ni();
    	}

    	int z = 0;
    	for(int i=0; i<n; i++){
    		z += t[i];
    	}

    	int[] ans = new int[m];
    	for(int i=0; i<m; i++){
    		ans[i] = z - (t[p[i]-1] - x[i]);
    		out.println(ans[i]);
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