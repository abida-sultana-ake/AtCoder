import java.util.*;

public class Main {
	public static void main(String[] args) {
		int N = NI();
		int W = NI();
		int item[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			item[i][0] = NI();
			item[i][1] = NI();
		}
		Arrays.sort(item, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
		int id[] = new int[5];
		int pop = 1;
		for (int i = 1; i < N; i++) {
			if (item[i][0] != item[i-1][0]) {
				id[pop++] = i;
			}
		}
		id[pop++] = N;
		id = Arrays.copyOf(id, pop);
		long ans = search(item, id, 0, W);
		System.out.println(ans);
	}

	private static long search(int[][] item, int[] id, int k, int W) {
		if (k == id.length - 1) return 0;
		int sum = 0;
		int sumw = 0;
		long ans = search(item, id, k + 1, W);
		for (int i = id[k]; i < id[k + 1]; i++) {
			sumw += item[i][0];
			if (sumw <= W) {
				sum += item[i][1];
				ans = Math.max(sum + search(item, id, k + 1, W - sumw), ans);
			} else {
				break;
			}
		}
		
		return ans;
	}

	static int NI() {
		try {
			int c = System.in.read(), r = 0;
			for (; c != '-' && (c < '0' || '9' < c);) {
				c = System.in.read();
			}
			if (c == '-')
				return -NI();
			for (; '0' <= c && c <= '9'; c = System.in.read()) {
				r = r * 10 + c - '0';
			}
			return r;
		} catch (Exception e) {
			return -1;
		}
	}

	static String next() {
		try {
			StringBuilder res = new StringBuilder("");
			int c = System.in.read();
			while (Character.isWhitespace(c))
				c = System.in.read();
			do {
				res.append((char) c);
			} while (!Character.isWhitespace(c = System.in.read()));
			return res.toString();
		} catch (Exception e) {
			return null;
		}
	}
}
