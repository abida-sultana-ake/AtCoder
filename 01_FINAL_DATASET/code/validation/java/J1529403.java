import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String S1 = Main.asshuku(sc.next());
		String S2 = Main.asshuku(sc.next());
		String[] S = { S1, S2 };
		long ans = 0;
		for(int i=0; i<S1.length(); i++) {
			if(S1.charAt(i) == S2.charAt(i)) {
				if(i==0) {
					ans = 3;
				} else {
					if(S1.charAt(i-1) == S2.charAt(i-1)) {
						ans *= 2;
					} else {
						;
					}
				}
			} else {
				if(i==0) {
					ans = 6;
				} else {
					if(S1.charAt(i-1) == S2.charAt(i-1)) {
						ans *= 2;
					} else {
						ans *= 3;
					}
				}
			}
			ans = ans % 1000000007;
		}
		System.out.println(ans);
	}
	
	private static String asshuku(String s) {
		String newstr = "";
		char prechar = '?';
		for(int i=0; i<s.length(); i++) {
			if(prechar == s.charAt(i)) {
				;
			} else {
				newstr += s.charAt(i);
			}
			prechar = s.charAt(i);
		}
		return newstr;
	}

}