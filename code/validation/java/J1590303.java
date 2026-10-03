import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    int W, H;
    long  MOD = 1000000007L;
    long[] dp;
    
    void solve(){
        Scanner in = new Scanner(System.in);
        W = in.nextInt();
        H = in.nextInt();
        in.close();
        dp = new long[W + H + 1];
        dp[0] = 1;
        for(int i = 1; i <= W+H; i++){
            dp[i] = dp[i - 1] * i % MOD;
        }
        long ans = dp[W+H-2] * pow(dp[W-1],MOD-2)%MOD * pow(dp[H-1],MOD-2)%MOD;
        System.out.println(ans);
    }
    
    long pow(long l, long p){
        if(p == 0) return 1;
        long a = pow(l, p/2);
        long b = a * a % MOD;
        if(p%2 != 0) b = b * l % MOD;
        return b;
    }

    //salary

    public static void main(String[] args) {
        new Main().solve();
    }
}