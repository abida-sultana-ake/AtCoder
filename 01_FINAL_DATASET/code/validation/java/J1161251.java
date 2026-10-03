import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		ARC033ASolve system = new ARC033ASolve();
		system.main();
	}
}

class ARC033ASolve {
	
	int N;
	
	ARC033ASolve() {
		Scanner cin = new Scanner(System.in);
		this.N = cin.nextInt();
	}
	
	void main() {
		long count = 0;
		for (int i = 1; i <= N; i++) {
			count += i;
		}
		System.out.println(count);
	}
	
}
