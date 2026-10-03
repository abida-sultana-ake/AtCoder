import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long[][] a = new long[n][2];
		int add = 0;
		for (int i = 0; i < n; ++i) {
			a[i][0] = sc.nextInt() - k;
			a[i][1] = i;
			if (i > 0) {
				a[i][0] += a[i - 1][0];
			}
			if (a[i][0] >= 0) {
				++add;
			}
		}
		Arrays.sort(a, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[0], o2[0]);
			}
		});

		int[] arr = new int[n];
		int p = 0;
		for (int i = 0; i < n; ++i) {
			if (i > 0) {
				if (a[i][0] != a[i - 1][0]) {
					++p;
				}
			}
			arr[(int)a[i][1]] = p;
		}
		solve(n, arr, add);
	}

	void solve(int n, int[] arr, int add) {
		int[][] e = new int[n][2];
		for (int i = 0; i < n; ++i) {
			e[i][0] = arr[i];
			e[i][1] = i;
		}
		Arrays.sort(e, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return Integer.compare(o1[0], o2[0]);
				} else {
					return Integer.compare(o1[1], o2[1]);
				}
			}
		});
		Seg seg = new Seg(n);
		long ans = 0;
		for (int i = 0; i < n; ++i) {
			ans += seg.sum(0, e[i][1]);
			seg.set(e[i][1]);
		}
		System.out.println(ans + add);
	}

	class Seg {
		int n;
		int[] v;

		public Seg(int n) {
			this.n = 1;
			while (this.n < n) {
				this.n *= 2;
			}
			v = new int[2 * this.n - 1];
		}

		void set(int k) {
			k += n - 1;
			v[k] = 1;
			while (k > 0) {
				k = (k - 1) / 2;
				v[k] = v[2 * k + 1] + v[2 * k + 2];
			}
		}

		int sum(int a, int b) {
			return sum(a, b, 0, n, 0);
		}

		// [a,b),[l,r)
		int sum(int a, int b, int l, int r, int k) {
			if (a >= r || b <= l) {
				return 0;
			} else if (a <= l && r <= b) {
				return v[k];
			} else {
				int vl = sum(a, b, l, (l + r) / 2, 2 * k + 1);
				int vr = sum(a, b, (l + r) / 2, r, 2 * k + 2);
				return vl + vr;
			}
		}
	}

	static void tr(Object... objects) {
		System.out.println(Arrays.deepToString(objects));
	}
}