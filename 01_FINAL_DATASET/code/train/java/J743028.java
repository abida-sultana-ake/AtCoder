import java.util.Scanner;

public class Main {

	static void solve() {
		int a1=nextInt();
		int a2=nextInt();
		int b1=nextInt();
		int b2=nextInt();
		System.out.println(a1==b1||a2==b2||a1==b2||a2==b1?"YES" : "NO");
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
