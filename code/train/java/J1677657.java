import java.util.Scanner;

public class Main {
	void run() {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String ans = s.replace(',' , ' ');
		System.out.println(ans);
		sc.close();
	}

	public static void main(String[] args) {
		new Main().run();
	}
}