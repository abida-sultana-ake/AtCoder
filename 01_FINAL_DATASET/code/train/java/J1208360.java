import java.util.*;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if (a-b==b-c) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
