import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		new Main().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] cnt = new int[1_000_00 + 2];
		for (int i = 0; i < n; ++i) {
			a[i] = sc.nextInt();
			++cnt[a[i]];
		}

		int ans = 0;
		for (int i = 0; i <= 100000; ++i) {
			ans = Math.max(ans, cnt[i] + (i > 0 ? cnt[i - 1] : 0) + cnt[i + 1]);
		}
		System.out.println(ans);
	}

	static void tr(Object... objects) {
		System.out.println(Arrays.deepToString(objects));
	}
}
