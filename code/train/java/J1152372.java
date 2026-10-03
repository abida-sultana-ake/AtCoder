import java.util.Scanner;
public class Main{
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		String a=s.next(),b=s.next();
		char ca,cb;
		for(int i=0;i<a.length();i++) {
			ca=a.charAt(i);
			cb=b.charAt(i);
			if(!(ca==cb||(ca=='@'&&isAtcoder(cb))||(cb=='@'&&isAtcoder(ca)))) {
				System.out.println("You will lose");
				return;
			}
		}
		System.out.println("You can win");
	}

	static boolean isAtcoder(char c) {
		final char[] a = "atcoder".toCharArray();
		for(int i=0;i<a.length;i++)
			if(a[i]==c)
				return true;
		return false;
	}
}
