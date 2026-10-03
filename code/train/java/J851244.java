import java.util.Scanner;

public class Main {
	long MOD = 1_000_000_000 + 7;
	long[] pow, rev;

	long pow(long n, int k) {
		if (k == 0) {
			return 1;
		}
		if (k % 2 == 0) {
			long t = pow(n, k / 2);
			t %= MOD;
			return t * t % MOD;
		} else {
			long t = pow(n, (k - 1) / 2);
			t %= MOD;
			t *= t;
			t %= MOD;
			return t * n % MOD;
		}
	}

	long combi(int n, int k) {
//		System.out.println("in combi: " + n + " " + k);
		long ret = 1;
		ret *= pow[n];
		ret *= rev[k];
		ret %= MOD;
		ret *= rev[n - k];
		return ret % MOD;
	}

	void run() {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int hh = sc.nextInt();
		int ww = sc.nextInt();

		pow = new long[h + w + 1];
		rev = new long[h + w + 1];
		pow[0] = 1;
		rev[0] = 1;
		for (int i = 1; i < h + w + 1; i++) {
			pow[i] = pow[i - 1] * i;
			pow[i] %= MOD;
			rev[i] = pow(pow[i], (int) MOD - 2);
		}

//		System.out.println(Arrays.toString(pow));
//		System.out.println(Arrays.toString(rev));

		long ans = 0;
		for (int i = 1; i <= w - ww; i++) {
			long tmp1 = combi(ww - 1 + i + h - hh - 1, h - hh - 1);
			long tmp2 = combi(w - ww - i + hh - 1, hh - 1);
//			System.out.println(tmp1 + " " + tmp2);
			ans += tmp1 * tmp2;
			ans %= MOD;
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
