import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}
	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			long R = sc.nextLong();
			long B = sc.nextLong();
			long x = sc.nextLong();
			long y = sc.nextLong();
			
			long lo = 0;
			long hi = R + B + 1;
			while (hi - lo > 1) {
				long m = (hi + lo) / 2;
				if (possible(R, B, x, y, m)) {
					lo = m;
				} else {
					hi = m;
				}
			}
			System.out.println(lo);
		}
	}
	
	boolean possible(long R, long B, long x, long y, long K) {
		R -= K;
		B -= K;
		if (R < 0 || B < 0) return false;
		return R / (x - 1) + B / (y - 1) >= K;
	}
}
