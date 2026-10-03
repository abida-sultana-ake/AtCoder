import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Solver solver = new Solver();
		solver.init();
		solver.readHead(in.readLine());
		for (; solver.hasNext();) {
			solver.readBody(in.readLine());
		}
	}
}

class Solver {
	int N;
	int cnt;

	public void init() {
		N = 0;
		cnt = 0;
	}

	public void readHead(String str) {
		String[] strArr = str.split(" ");
		N = Integer.parseInt(strArr[0]);
		// System.out.println(N);
	}

	public boolean hasNext() {
		return cnt < 1;
		// return cnt < N;
	}

	public void readBody(String str) {
		// System.out.println(str);
		String[] strArr = str.split(" ");
		HashSet<Integer> cols = new HashSet<Integer>();
		int master = 0;
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(strArr[i]);
			int c = -1;
			// •レート 1-399：灰色
			if (a >= 1 && a <= 399)
				c = 1;
			// •レート 400-799：茶色
			if (a >= 400 && a <= 799)
				c = 2;
			// •レート 800-1199：緑色
			if (a >= 800 && a <= 1199)
				c = 3;
			// •レート 1200-1599：水色
			if (a >= 1200 && a <= 1599)
				c = 4;
			// •レート 1600-1999：青色
			if (a >= 1600 && a <= 1999)
				c = 5;
			// •レート 2000-2399：黄色
			if (a >= 2000 && a <= 2399)
				c = 6;
			// •レート 2400-2799：橙色
			if (a >= 2400 && a <= 2799)
				c = 7;
			// •レート 2800-3199：赤色
			if (a >= 2800 && a <= 3199)
				c = 8;
			if (a >= 3200)
				master++;
			if (c >= 1 && c <= 8)
				cols.add(c);
		}
		int min = cols.size();
		int max = cols.size();
		if (master > 0) {
			if (min == 0)
				min = 1;
			max += master;
			// if (max > 8)
			// max = 8;
		}
		System.out.println(min + " " + max);
		cnt++;
	}
}
