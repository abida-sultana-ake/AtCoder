import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int ans = solve(A, B, C);
		System.out.println(ans);
		sc.close();
	}

	private int solve(int A, int B, int C) {
		int res = 2 * (A * B + B * C + C * A);
		return res;
	}

}
