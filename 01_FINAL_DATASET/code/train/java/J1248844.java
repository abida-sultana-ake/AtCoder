import java.util.Scanner;

public class Main {
	void run() {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int sum = 0;
		for (int i = 0;; i++) {
			sum += i;
			if (n <= sum) {
				System.out.println(i);
				return;
			}
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
