
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Main m = new Main();
	m.answer();
    }

    private Scanner scan = new Scanner(System.in);
    private static final long MOD = 1_000_000_007L;
    private final int W;
    private final int H;
    private final long[] dp;

    public Main() {
	W = Integer.parseInt(scan.next());
	H = Integer.parseInt(scan.next());

	dp = new long[W+H+1];
	dp[0] = 1;
	int iMax = W + H;
	for (int i = 1; i <= iMax; i++) {
	    dp[i] = dp[i-1] * i % MOD;
	}

	scan.close();
    }

    public final void answer() {
	long ans = fact(W+H-2) * infact(W-1) % MOD * infact(H-1) % MOD;
	System.out.println(ans);
    }

    private final long pow(long x, long y) {
	if(y == 0) return 1;
	
	long x2 = pow(x, y/2);
	long ret = x2 * x2 % MOD;
	if(y%2 != 0) ret = ret * x % MOD;
	return ret;
    }

    private final long fact(int n) {
	return dp[n];
    }

    private final long infact(int n) {
	return pow(fact(n), MOD-2);
    }
}
