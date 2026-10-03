import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String s = sc.next();
		int n = sc.nextInt();
		for (int i = 0;i < n;i++) {
			s = rev(s, sc.nextInt(), sc.nextInt());
		}
		System.out.println(s);
	}

	private static String rev(String s, int a, int b) {
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0,a-1));
		sb.append(new StringBuffer(s.substring(a-1,b)).reverse().toString());
		sb.append(s.substring(b,s.length()));
		return sb.toString();
	}
}
