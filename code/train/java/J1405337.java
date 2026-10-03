import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	
	void solve(){
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int d=sc.nextInt();
		
		System.out.println(Math.max((a+1)*d,a*(d+1)));
	}
}
