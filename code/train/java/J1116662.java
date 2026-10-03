import java.util.Scanner;

public class Main {	
	
	private static int[] values = new int[100010];
	private static final int WOLF = 0 , SHEEP = 1;
	// o sheep both same
	// x wolf both same
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String input = scan.next() , ans = null;
		
		for (int i = 0;i < 2;i ++) {
			for (int j = 0;j < 2;j ++) {
				String temp = check(input , i , j);
				if (temp != null) {
					ans = temp;
					break;
				}
				if (ans != null)
					break;
			}	
		}
		if (ans == null)
			System.out.println(- 1);
		else
			System.out.println(ans);
		
	}
	
	private static int getValue(int current , int value , char ch) {
		
		if (current == WOLF) {
			if (ch == 'x') {
				return value;
			} else {
				return 1 - value;
			}
		} else {
			if (ch == 'o') {
				return value;
			} else {
				return 1 - value;
			}
		}
		
	}
	
	private static boolean check(int current , int left , int right , char ch) {
	
		if (current == WOLF) {
			if (ch == 'x') {
				if (left != right)
					return false;
			} else {
				if (left == right)
					return false;
			}
		} else {
			if (ch == 'o') {
				if (left != right)
					return false;
			} else {
				if (left == right)
					return false;
			}
		}
		return true;
		 
	}
	
	private static String check(String input , int value1 , int value2) {
		
		values[0] = value1;
		values[1] = value2;
		for (int i = 2;i < input.length();i ++) {
			values[i] = getValue(values[i - 1] , values[i - 2] , input.charAt(i - 1));
		}
		int length = input.length();
		for (int i = 0;i < length;i ++) {
			int left = (i == 0) ? (length - 1) : i - 1;
			int right = (i == length - 1) ? 0 : i + 1;
			char ch = input.charAt(i);
			if (!check(values[i] , values[left] , values[right] , ch)) {
				return null;
			}
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0;i < length;i ++) {
			if (values[i] == WOLF)
				builder.append("W");
			else
				builder.append("S");
		}
		return builder.toString();
		
	}
	
		
}












