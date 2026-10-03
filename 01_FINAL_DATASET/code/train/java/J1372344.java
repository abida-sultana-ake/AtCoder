import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int x = n / 2;
		int y = n -x;
		System.out.println(x*y);
	}
}
