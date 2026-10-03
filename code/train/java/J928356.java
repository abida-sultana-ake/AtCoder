import java.util.Scanner;

public class Main {
	private static Main instance = new Main();
	
	private Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		instance.solve();
	}
	
	private void solve() {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		long answer = (long)(k * Math.pow(k-1, n-1));
		System.out.printf("%d", answer);
	}
}
