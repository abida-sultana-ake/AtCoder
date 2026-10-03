import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	final long MODULO = 1_000_000_000 + 7;

	public void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] a = new long[n];
		PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				return -Long.compare(o1, o2);
			}
		});
		for (int i = 0; i < n; ++i) {
			a[i] = sc.nextLong();
			pq.add(a[i]);
		}
		long ans = 0;
		long w = 0;
		while (pq.peek() + w > n - 1) {
			long v = pq.poll() + w;
			long d = (v - (n - 1) + n - 1) / n;
			ans += d;
			v = v - d * n - w;
			v -= d;
			w += d;
			pq.add(v);
		}
		System.out.println(ans);
	}

	long f(long[] a, long k) {
		int n = a.length;
		long s = 0;
		for (int i = 0; i < n; ++i) {
			if (a[i] + k <= n - 1) {
				continue;
			} else {
				long res = a[i] + k - (n - 1);
				s += (res + n) / (n + 1);
			}
		}
		return k - s;

	}

	static void tr(Object... objects) {
		System.out.println(Arrays.deepToString(objects));
	}
}
