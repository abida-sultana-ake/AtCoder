import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	void solve(){
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		System.out.println(x/10+x%10);
	}
}
