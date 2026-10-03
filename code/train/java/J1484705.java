import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	
	void solve(){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		System.out.println((n-1)*(m-1));
	}
}
