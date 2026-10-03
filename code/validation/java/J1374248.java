
import java.util.Scanner;

public class Main {
	
	static int BASE = 1000000007;
	int N,M;

	private void solve() {
		// input

		Scanner io = new Scanner(System.in);
		N = io.nextInt();
		M = io.nextInt();
		int pat = (Math.abs(N-M)>1)? 0 : 
					(Math.abs(N-M)==1)? 1 : 2; 

		System.out.println((fuc(N)*fuc(M)*pat)%BASE);
	}
	
	private long fuc(long n){
		long ans = 1;
		for(long i=n;i>0;i--){
			ans = (ans * i)%BASE;
		}
		return ans;
	}

	public static void main(String[] args) {
		new Main().solve();
	}
}