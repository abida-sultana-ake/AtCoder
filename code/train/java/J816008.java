import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static final int MOD = 1_000_000_007;

	public static void main(String[] args) {
		int H = sc.nextInt();
		int W = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		long[] row = new long[W];
		long before = comb(H - A - 1 + B, B);
		for (int i = B; i < W; ++i) {
			row[i] = before;
			before *= H - A + i;
			before %= MOD;
			before *= inv(i + 1);
			before %= MOD;
		}
		long ans = 0;
		long after = 1;
		for (int i = W - 1; i >= B; --i) {
			ans += row[i] * after;
			ans %= MOD;
			after *= A - 1 + (W - i);
			after %= MOD;
			after *= inv(W - i);
			after %= MOD;
		}
		System.out.println(ans);
	}

	static long comb(long a, long b) {
		long ret = 1;
		for (int i = 0; i < b; ++i) {
			ret *= (a - i);
			ret %= MOD;
			ret *= inv(i + 1);
			ret %= MOD;
		}
		return ret;
	}

	static long inv(long v) {
		return pow(v, MOD - 2);
	}

	static long pow(long v, long p) {
		if (p == 0) return 1;
		if (p == 1) return v;
		long ret = pow(v, p / 2);
		ret *= ret;
		ret %= MOD;
		if (p % 2 == 1) {
			ret *= v;
			ret %= MOD;
		}
		return ret;
	}
}
