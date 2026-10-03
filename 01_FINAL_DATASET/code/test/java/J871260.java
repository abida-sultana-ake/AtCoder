import java.util.Scanner;

public class Main {
	void run() {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		System.out.println(w * (h - 1) + (w - 1) * h);
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
