import java.util.*;

// UVa 11504

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int a = in.nextInt();
		
		System.out.println(a % 2 == 0 ? a - 1 : a + 1);
	}
}