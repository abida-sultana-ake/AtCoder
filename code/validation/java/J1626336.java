import java.util.Scanner;

/**
 * http://abc034.contest.atcoder.jp/tasks/abc034_c
 */
public class Main {
	
	static final int MOD = 1000000007;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final int W = sc.nextInt();
		final int H = sc.nextInt();
		sc.close();
		
		System.out.println(getCombination((W-1)+(H-1),(H-1)));
		
	}
	
	/**
	 * 組合わせ nCr の計算
	 * @param n
	 * @param r
	 * @return
	 */
	static long getCombination(int n, int r){
		
		long[] modDp = new long[n+1];
		long[] modInvDp = new long[n+1];
		modDp[0] = 1; 
		for (int i=1; i<=n; i++) modDp[i] = getMod(modDp[i-1]*i);
		modInvDp[n] = getInverse(modDp[n]);
		for (int i=n; i>0; i--) modInvDp[i-1] = getMod(modInvDp[i]*i);
		long ans = modDp[n];
		ans = ans*modInvDp[r] % MOD;
		ans = ans*modInvDp[n-r] % MOD;
		return ans;
		
	}
	
	/**
	 * 逆元の取得
	 * @param a
	 * @return
	 */
	static long getInverse(long a) {
		return getPower(a, MOD-2);
	}
	
	/**
	 * べき上の計算
	 * @param a
	 * @param n
	 * @return
	 */
	static long getPower(long a, int n) {
		if(n == 0){
			return 1;
		}else if(n % 2 == 0){
			return getPower(getMod(a*a), n/2);
		}else{
			return getMod(a*getPower(a,n-1));
		}
	}
	
	/**
	 * 余剰の計算
	 * @param a
	 * @return
	 */
	static long getMod(long a){
		return a>=0 ? a%MOD : MOD + a%MOD;
	}
	
}