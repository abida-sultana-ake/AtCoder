import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		final int W = sc.nextInt();
		final int H = sc.nextInt();
		sc.close();
//		long[][] path = new long[H+1][W+1];
//		for(int i=1; i<H+1; i++) {
//			for(int j=1; j<W+1; j++) {
//				if(i==1&&j==1) {
//					path[i][j] = 1;
//				} else {
//					path[i][j] = (path[i-1][j] + path[i][j-1])%1000000007;
//				}
//			}
//		}
		System.out.println(modcomb(W+H-2, Math.min(H-1, W-1), 1000000007));
	}

	static long modcomb(long n, long k, long mod) {
		if(k==1) {
			return n;
		}
		
		long ans = 1;
		for(long i=n; i>=n-k+1; i--) {
			ans = (ans * i)%mod;
		}
		for(long i=k; 0<i; i--) {
			ans = (ans * modpow(i, mod-2, mod)) % mod;
		}
		return ans;
	}
	
	static long modpow(long a, long b, long mod) {
		if(b==0) return 1;
		if(b%2==0) {
			long d = modpow(a, b/2, mod);
			return (d*d)%mod;
		} else {
			return (a*modpow(a, b-1, mod))%mod;
		}
	}
}