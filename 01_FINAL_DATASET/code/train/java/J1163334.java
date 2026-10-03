import java.util.*;

// UVa 11504

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		char[] c = in.next().toCharArray();
		int n = in.nextInt();
//		int m = in.nextInt();
//		int o = in.nextInt();
//		String s = in.next();
		
//		double answer = 0;

		n--;
		System.out.printf("%c%c\n", c[n / 5], c[n % 5]);
		
		
//		System.out.println(answer);
	}
}