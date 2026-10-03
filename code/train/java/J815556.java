import java.util.Scanner;

public class Main {
	public static int MAXN = 200000;
	public static long MOD = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int i1 = h - 1 - a;
		int j1 = b;
		long ans = 0;

		while(i1 >= 0 && j1 < w) {
			int i2 = h - 1 - i1;
			int j2 = w - 1 - j1;
			ans += comb(i1+j1,i1) * comb(i2+j2,i2) % MOD;
			if (ans >= MOD) ans -= MOD;
			i1 -= 1;
			j1 += 1;
		}
		
		System.out.println(ans);
	}
	
	static long[] fact = factorialArray(MAXN, MOD);
	static long[] factInv = factorialInverseArray(MAXN, MOD, inverseArray(MAXN, MOD));
	public static long comb(int n,int r) {
		return fact[n] * factInv[r] % MOD * factInv[n-r] % MOD;
	}
	
	public static long[] inverseArray(int maxN,long modP) {
		long[] inv = new long[maxN+1];
		inv[1] = 1;
		for(int i=2;i<=maxN;i++) {
			inv[i] = modP - (modP / i) * inv[(int) (modP%i)] % modP;
		}
		return inv;
	}
	public static long[] factorialArray(int maxN,long mod) {
		long[] fact = new long[maxN+1];
		fact[0] = 1 % mod;
		for(int i=1;i<=maxN;i++) {
			fact[i] = fact[i-1] * i % mod;
		}
		return fact;
	}
	public static long[] factorialInverseArray(int maxN,long modP,long[] inverseArray) {
		long[] factInv = new long[maxN+1];
		factInv[0] = 1;
		for(int i=1;i<=maxN;i++) {
			factInv[i] = factInv[i-1] * inverseArray[i] % modP;
		}
		return factInv;
	}
}
