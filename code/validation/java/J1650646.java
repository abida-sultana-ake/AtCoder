import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		new Main().solve();
	}
	
	void solve(){
		Scanner sc=new Scanner(System.in);
		char[]a=sc.next().toCharArray();
		System.out.println(a[0]-'A'+1);
	}
}
