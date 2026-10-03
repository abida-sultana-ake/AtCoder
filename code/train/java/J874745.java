
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		solve(s);
		s.close();
	}

	public static void solve(Scanner s) {
		int n = s.nextInt();
		int l = s.nextInt();
		String[] str = new String[n];

		for (int i = 0; i < n; i++) {
			str[i] = s.next();
		}

		Arrays.sort(str);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(str[i]);
		}

		System.out.println(sb.toString());
	}
}
