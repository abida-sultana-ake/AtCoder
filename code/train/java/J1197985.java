import java.util.Scanner;

public class Main{

	static final Scanner	s	=new Scanner(System.in);

	public static void main(String args[]){
		input();
		solve();
	}

	private static void input(){
	}

	private static void solve(){
		String in=s.next();
		int a=114514,z=-114514;
		for(int i=0;i<in.length();i++) {
			if(in.charAt(i)=='A')
				a=Math.min(a,i);
			if(in.charAt(i)=='Z')
				z=Math.max(z,i);
		}
		System.out.println(z-a+1);
	}
}
