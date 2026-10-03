import java.util.*;
import java.lang.*;

public class Main {
	static int group(int x) {
		switch (x) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 0;
			case 4:
			case 6:
			case 9:
			case 11:
				return 1;
			case 2:
				return 2;
			default:
				return -1;
		}
	}

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		System.out.println((group(x) == group(y))?"Yes":"No");
	}
}