import java.io.*;
import java.util.*;

public class Main {
    public static PrintWriter out;
    public static FastScanner in;

    private void solve(){
        int n = in.nextInt();
        int ma = in.nextInt();
        int mb = in.nextInt();

        int[][] dp = new int[401][401];
        for(int i=0;i<=400;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        for(int i=0;i<n;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            for(int j=400-a;j>=0;j--){
                for(int k=400-b;k>=0;k--){
                    if(dp[j][k]!=Integer.MAX_VALUE){
                        dp[j+a][k+b] = Math.min(dp[j+a][k+b],dp[j][k]+c);
                    }
                }
            }
        }
        int mn = Integer.MAX_VALUE;
        for(int i=0;i<=400;i++){
            for(int j=0;j<=400;j++){
                if(dp[i][j]!=Integer.MAX_VALUE){
                    int g = gcd(i,j);
                    if(g == 0) continue;
                    if(i/g == ma && j/g == mb){
                        mn = Math.min(mn,dp[i][j]);
                    }
                }
            }
        }
        if(mn == Integer.MAX_VALUE) out.print(-1);
        else out.print(mn);
    }

    private int gcd(int a ,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    private void runIO() {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        solve();
        out.close();
    }
    private static class FastScanner {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        private FastScanner() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            if (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private String nextLine() {
            String ret = "";
            try {
                ret = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        new Main().runIO();
    }
}
