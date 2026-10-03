import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Solver solver = new Solver();
		solver.init();
		solver.readHead(in.readLine());
		// for (; solver.hasNext();) {
		// solver.readBody(in.readLine());
		// }
		// solver.solve();
	}
}

class Solver {
	int N;
	int H;
	int W;
	int cnt;

	public void init() {
		N = 0;
		cnt = 0;
	}

	public void readHead(String str) {
		String[] strArr = str.split(" ");
		// N = Integer.parseInt(strArr[0]);
		// System.out.println(N);

		H = Integer.parseInt(strArr[0]);
		W = Integer.parseInt(strArr[1]);

		if (H % 3 == 0) {
			System.out.println("0");
			return;
		}
		if (W % 3 == 0) {
			System.out.println("0");
			return;
		}

		long l;
		long m;
		// if (H > W) {
		// l = (long) H;
		// m = (long) W;
		// } else {
		// l = (long) W;
		// m = (long) H;
		// }

		long l1;
		long m1;
		long l2;
		long m2;
		long l3;
		long m3;
		long min = Long.MAX_VALUE;

		l = (long) H;
		m = (long) W;
		// 1辺3分割
		for (int i = 1; i <= l; i++) {
			l1 = i;
			m1 = m;
			l2 = (l - l1) / 2;
			m2 = m;
			l3 = l - l1 - l2;
			m3 = m;
			// if (l1 > 0 && m1 > 0 && l2 > 0 && m2 > 0 && l3 > 0 && m3 > 0)
			min = Long.min(min, diffMaxMin(l1 * m1, l2 * m2, l3 * m3));
		}

		// 2辺２分割
		for (int i = 1; i <= l; i++) {
			l1 = i;
			m1 = m;
			l2 = l - l1;
			m2 = m / 2;
			l3 = l - l1;
			m3 = m - m2;
			// if (l1 > 0 && m1 > 0 && l2 > 0 && m2 > 0 && l3 > 0 && m3 > 0)
			min = Long.min(min, diffMaxMin(l1 * m1, l2 * m2, l3 * m3));
		}

		l = (long) W;
		m = (long) H;
		// 1辺3分割
		for (int i = 1; i <= l; i++) {
			l1 = i;
			m1 = m;
			l2 = (l - l1) / 2;
			m2 = m;
			l3 = l - l1 - l2;
			m3 = m;
			// if (l1 > 0 && m1 > 0 && l2 > 0 && m2 > 0 && l3 > 0 && m3 > 0)
			min = Long.min(min, diffMaxMin(l1 * m1, l2 * m2, l3 * m3));
		}

		// 2辺２分割
		for (int i = 1; i <= l; i++) {
			l1 = i;
			m1 = m;
			l2 = l - l1;
			m2 = m / 2;
			l3 = l - l1;
			m3 = m - m2;
			// if (l1 > 0 && m1 > 0 && l2 > 0 && m2 > 0 && l3 > 0 && m3 > 0)
			min = Long.min(min, diffMaxMin(l1 * m1, l2 * m2, l3 * m3));
		}
		System.out.println(min);

	}

	private long diffMaxMin(long s1, long s2, long s3) {
		long min = s1;
		long max = s1;
		if (min > s2)
			min = s2;
		if (max < s2)
			max = s2;
		if (min > s3)
			min = s3;
		if (max < s3)
			max = s3;
		return max - min;
	}

	public boolean hasNext() {
		return cnt < N;
	}

	public void readBody(String str) {
		// System.out.println(str);
		cnt++;
	}

	public void solve() {
	}
}
