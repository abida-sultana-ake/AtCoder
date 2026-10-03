import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	HashMap<List<Long>, Long> f = new HashMap<>();
	int N;
	long W;
	long[] w, v;

	void run() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		W = sc.nextLong();
		w = new long[N];
		v = new long[N];
		for (int i = 0; i < N; ++i) {
			w[i] = sc.nextLong();
			v[i] = sc.nextLong();
		}
		System.out.println(func(W, 0));
	}

	long func(long ww, int num) {
		if (ww < 0)
			return -Long.MAX_VALUE / 16;
		if (num == N)
			return 0;
		if (f.containsKey(Arrays.asList(ww, (long) num)))
			return f.get(Arrays.asList(ww, (long) num));
		long ret = Math.max(func(ww - w[num], num + 1) + v[num], func(ww, num + 1));
		f.put(Arrays.asList(ww, (long) num), ret);
		return ret;
	}

	void tr(Object... objects) {
		System.out.println(Arrays.deepToString(objects));
	}
}