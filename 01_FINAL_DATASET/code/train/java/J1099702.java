import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		D052 d = new D052();
		d.main();
		
	}
}

class D052 {
	
	int N;
	long A;
	long B;
	long[] X;
	
	D052() {
		Scanner cin = new Scanner(System.in);
		this.N = cin.nextInt();
		this.A = cin.nextInt();
		this.B = cin.nextInt();
		this.X = new long[N];
		for (int i = 0; i < N; i++) {
			X[i] = cin.nextInt();
		}
	}
	
	void main() {
		
		long fati = 0;
		for (int i = 0; i < N - 1; i++) {
			long dist = X[i + 1] - X[i];
			long tmp = Math.min(dist*A, B);
			fati += tmp;
		}
		System.out.println(fati);
	}
	
}