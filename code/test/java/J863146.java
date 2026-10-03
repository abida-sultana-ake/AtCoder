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
    	int N = ni();
    	int A = ni();
    	int[] x = nia(N);

    	long[][][] dp = new long[N+1][N+1][50*N+1];
    	dp[0][0][0] = 1;

    	for (int i=1; i<=N; i++) {
    		for (int j=0; j<=i; j++) {
    			for (int k=0; k<=50*N; k++) {
    				if (j != 0 && k + x[i-1] <= 50*N) {
    					dp[i][j][k+x[i-1]] += dp[i-1][j-1][k];
    				}
    				dp[i][j][k] += dp[i-1][j][k];
    			}
    		}
    	}

    	long sum = 0;
    	for (int i=1; i<=N; i++) {
    		sum += dp[N][i][i*A];
    	}
    	out.println(sum);
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
