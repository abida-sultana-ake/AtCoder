
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public char[] c;

	public boolean[] plus;

	public int n;

	public long sum;

	void run() {
		Scanner sc = new Scanner(System.in);

		c = sc.next().toCharArray();
		n = c.length;

		plus = new boolean[n - 1];

		long a = 0;
		for (int i = 0; i < n; i++) {
			a *= 10;
			a += c[i] - '0';
		}
		sum = a;
		for (int i = 1; i < n; i++) {
			solve(0, 0, i);
		}
		System.out.println(sum);
	}

	void solve(int i, int num, int k) {
		// 基底
		if (num == k) {
			// System.out.println("k:" + k);
			// System.out.println("plus:" + Arrays.toString(plus));
			long a = 0;
			for (int j = 0; j < n - 1; j++) {
				a += c[j] - '0';
				if (plus[j]) {
					sum += a;
					a = 0;
				} else {
					a *= 10;
				}
			}
			a += c[n - 1] - '0';
			sum += a;
			// System.out.println("sum : " + sum);
			return;
		}
		if (i == n - 1) {
			return;
		}

		plus[i] = true;
		solve(i + 1, num + 1, k);
		plus[i] = false;
		solve(i + 1, num, k);
	}

	public static void main(String[] args) {
		new Main().run();
	}

}
