import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = solve(N);
		System.out.println(ans);
		sc.close();
	}

	private int solve(int n) {
		return (int)(Math.sqrt(Math.sqrt(n)));
	}

}
