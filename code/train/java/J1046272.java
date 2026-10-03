import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		MonotonicIncrease mi = new MonotonicIncrease();
		mi.exec();
	}
}
 
class MonotonicIncrease {
	
	int N;
	int[] a;
	
	MonotonicIncrease() {
		Scanner cin = new Scanner(System.in);
		this.N = cin.nextInt();
		this.a = new int[N];
		for (int i = 0; i < N; i++) {
			this.a[i] = cin.nextInt();
		}
	}
	
	void exec() {
		
		long ans = 0;
		long count = 0;
		
		int l = 0;
		int r = 0;
		while (l != N - 1 && r != N) {
			
			int prev = 0;
			while (r != N && prev < a[r]) {
				prev = a[r];
				r++;
				count++;
			}
			
			ans += count;
			while (l != r) {
				count--;
				ans += count;
				l++;
			}
		}
		
		if (r != N) {
			ans++;
		}
		System.out.println(ans);
	}
}