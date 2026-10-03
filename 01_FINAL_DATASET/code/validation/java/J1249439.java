import java.util.*;

public class Main {
	public static void main(String[] args) {
		int N = NI();
		int T = NI();
		long t[] = new long[N+1];
		for (int i = 0; i < N; i++) {
			t[i] = NI();
		}
		t[N] = 1L << 45;
		long ans = 0;
		long st = t[0];
		for (int i = 1; i <= N; i++) {
			if (t[i-1] + T < t[i]) {
				ans += T + t[i - 1] - st;
				st = t[i];
			}
		}
		System.out.println(ans);
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
