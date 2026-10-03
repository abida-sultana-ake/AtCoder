import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		ABC053A a = new ABC053A();
	}
}

class ABC053A {
	
	ABC053A() {
		Scanner cin = new Scanner(System.in);
		String str = cin.next();
		
		int left = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'A') {
				left = i;
				break;
			}
		}
		int right = str.length() - 1;
		for (int i = right; i >= 0; i--) {
			if (str.charAt(i) == 'Z') {
				right = i;
				break;
			}
		}
		
		int length = right - left + 1;
		System.out.println(length);
	}
}