import java.util.Scanner;

public class Main {

	static void solve() {
		String s = next();
		int[] c = new int[26];
		int n = s.length();
		for (int i = 0; i < n; i++) {
			c[s.charAt(i) - 'a']++;
		}
		int m = 0;
		for (int i = 0; i < 26; i++) {
			if ((c[i] & 1) == 1)
				m++;
		}
		if (m == 0)
			System.out.println(n);
		else
			System.out.println((n - m >> 1) / m << 1 | 1);
	}

	static int gdc(int x, int y) {
		if (x < y) {
			x ^= y;
			y ^= x;
			x ^= y;
		}
		int z = x % y;
		if (z == 0)
			return y;
		return gdc(y, z);
	}

	static int clamp(int a, int min, int max) {
		return a < min ? min : a > max ? max : a;
	}

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static long max(long a, long b) {
		return a > b ? a : b;
	}

	static long min(long a, long b) {
		return a < b ? a : b;
	}

	static Scanner in;

	static void out(String val) {
		System.out.println(val);
	}

	static void out(int val) {
		System.out.println(val);
	}

	static void out(long val) {
		System.out.println(val);
	}

	static void out(char val) {
		System.out.println(val);
	}

	static void out(float val) {
		System.out.println(val);
	}

	static void out(double val) {
		System.out.println(val);
	}

	static void out(boolean val) {
		System.out.println(val);
	}

	static String next() {
		return in.next();
	}

	static int nextInt() {
		return parseInt(in.next());
	}

	static long nextLong() {
		return parseLong(in.next());
	}

	static int parseInt(String val) {
		return Integer.parseInt(val);
	}

	static int parseInt(char val) {
		return Integer.parseInt(String.valueOf(val));
	}

	static long parseLong(String val) {
		return Long.parseLong(val);
	}

	public static void main(String[] args) {
		in = new Scanner(System.in);
		solve();
	}
}
