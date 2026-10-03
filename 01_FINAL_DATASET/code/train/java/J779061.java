import java.util.Scanner;

public class Main {

	public static void solve() {
		long A = in.nextLong();
		long B = in.nextLong();
		long K = in.nextLong();
		long L = in.nextLong();

		long x = K / L;
		long y = K - x * L;
		
		long ans;
		if (A * y < B)
		    ans = x * B + A * y;
		else
		    ans = x * B + B;
		System.out.println(ans);
	}

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		solve();
		in.close();
	}
}