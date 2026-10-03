import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		ABC056BSolve solve = new ABC056BSolve();
		solve.main();
	}
}

class ABC056BSolve {
	
	int W;
	int a;
	int b;
	
	ABC056BSolve() {
		Scanner cin = new Scanner(System.in);
		this.W = cin.nextInt();
		this.a = cin.nextInt();
		this.b = cin.nextInt();
	}
	
	void main() {
		int left = Math.min(a, b);
		int right = Math.max(a, b);
		int diff = right - (left + W);
		int ans = Math.max(0, diff);
		System.out.println(ans);
	}
}