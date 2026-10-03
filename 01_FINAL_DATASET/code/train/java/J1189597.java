import java.util.*;

public class Main {

	static Scanner	s	= new Scanner(System.in);

	public static void main(String __[]) {
		input();
		solve();
	}

	private static int a,b,c,k,child,man;
	private static void input() {
		a=s.nextInt();
		b=s.nextInt();
		c=s.nextInt();
		k=s.nextInt();
		child=s.nextInt();
		man=s.nextInt();
	}
	private static void solve() {
		if(child+man>=k)
			System.out.println(child*(a-c)+man*(b-c));
		else
			System.out.println(child*a+man*b);
	}
}
