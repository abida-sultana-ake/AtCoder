import java.io.*;
import java.util.*;

public class Main {
	static final int M = 1000000007;
	static int[] xy = new int[2];
	static int gcd(int a, int b) {
		if (b == 0) {
			xy[0] = 1;
			xy[1] = 0;
			return a;
		} else {
			int d = gcd(b, a % b);
			int t = xy[0] - a / b * xy[1]; xy[0] = xy[1]; xy[1] = t;
			return d;
		}
	}
	static int inv(int a) {
		gcd(a, M);
		return (xy[0] % M + M) % M;
	}
	static int[] ff, gg;
	static void init(int n) {
		ff = new int[n + 1];
		gg = new int[n + 1];
		ff[0] = gg[0] = 1;
		for (int i = 1; i <= n; i++) {
			ff[i] = (int) ((long) ff[i - 1] * i % M);
			gg[i] = (int) ((long) gg[i - 1] * inv(i) % M);
		}
	}
	static int choose(int n, int k) {
		return (int) ((long) ff[n] * gg[n - k] % M * gg[k] % M);
	}
	static int solve(int h, int w) {
		return choose(h - 1 + w - 1, h - 1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		init(h + w);
		int sum = 0;
		for (int i = 1; a + i <= h && b + i <= w; i++) {
			int w1 = solve(a + i, w + 1 - (b + i));
			int w2 = solve(h + 1 - (a + i), b + i);
			sum = (int) ((sum + (long) w1 * w2) % M);
		}
		System.out.println(sum);
	}
}
