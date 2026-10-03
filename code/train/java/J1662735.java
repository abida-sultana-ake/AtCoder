import java.util.Arrays;
import java.util.Scanner;

public class Main {
	void run() {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long n = x * 2 / 11 + 1;
		if(x < 6) {
			System.out.println(1);
		}
		else if(11 * (n - 2) / 2 + 6 >= x) {
			System.out.println(n-1);
		}else {
			System.out.println(n);
		}
		sc.close();
	}

	void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
