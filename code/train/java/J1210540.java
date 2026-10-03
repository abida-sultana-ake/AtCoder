import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	long MODULO = 1_000_000_000 + 7;

	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		long[] x = new long[n];
		long[] y = new long[m];
		for (int i = 0; i < n; ++i) {
			x[i] = sc.nextLong();
		}
		for (int j = 0; j < m; ++j) {
			y[j] = sc.nextLong();
		}
		System.out.println(sum(x) * sum(y) % MODULO);
	}

	long sum(long[] arr) {
		int n = arr.length;
		long ret = 0;
		long s = 0;
		for (long v : arr) {
			s = (s + v - arr[0]) % MODULO;
		}
		for (int i = 0; i < arr.length; ++i) {
			ret = (ret + s) % MODULO;
			if (i + 1 < arr.length)
				s = (s - (n - 1) * (arr[i + 1] - arr[i]) % MODULO + MODULO) % MODULO;
			--n;
		}
		return ret;
	}

	void tr(Object... objects) {
		System.out.println(Arrays.deepToString(objects));
	}
}