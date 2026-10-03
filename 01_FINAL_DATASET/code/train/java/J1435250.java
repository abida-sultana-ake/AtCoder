import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int N = S.length();
		for(int i = N - 2 ; i >= 0 ; i--) {
			if(check(S.substring(0, i))) {
				System.out.println(i);
				return;
			}
		}
	}

	public static boolean check(String s) {
		int N = s.length();
		for(int i = 0 ; i < N ; i++) {
			if(s.substring(0, N / 2).equals(s.substring(N / 2))) {
				return true;
			}
		}
		return false;
	}
}
