import java.util.Scanner;

public class Main {
	
	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			String s1 = sc.next().toUpperCase().substring(0, 1);
			String s2 = sc.next().toUpperCase().substring(0, 1);
			String s3 = sc.next().toUpperCase().substring(0, 1);
			System.out.println(s1 + s2 + s3);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
