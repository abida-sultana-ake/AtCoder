import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		ARC010ASolve solve = new ARC010ASolve();
		solve.main();
	}
}

class ARC010ASolve {
	
	int N;
	int M;
	int A;
	int B;
	int[] c;
	
	ARC010ASolve() {
		Scanner cin = new Scanner(System.in);
		this.N = cin.nextInt();
		this.M = cin.nextInt();
		this.A = cin.nextInt();
		this.B = cin.nextInt();
		this.c = new int[M];
		for (int i = 0; i < M; i++) {
			c[i] = cin.nextInt();
		}
	}
	
	void main() {
		for (int i = 0; i < M; i++) {
			if (N <= A) {
				N += B;
			}
			N -= c[i];
			if (N < 0) {
				System.out.println(i + 1);
				return;
			}
		}
		System.out.println("complete");
	}
}
