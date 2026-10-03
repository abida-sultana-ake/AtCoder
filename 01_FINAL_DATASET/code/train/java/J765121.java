import java.util.Scanner;

public class Main {

	void run() {
		Scanner sc = new Scanner(System.in);

		double x = sc.nextLong();

		double tmp = Math.sqrt(Math.sqrt(x));
		System.out.println((int) tmp);
	}

	public static void main(String[] args) {
		new Main().run();
	}

}
