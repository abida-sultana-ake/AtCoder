import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();

		if (x % 11 == 0 || x % 11 == 6) {
			System.out.println(2 * x / 11);
		} else {
			System.out.println(2 * x / 11 + 1);
		}
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
		}
	}
}
