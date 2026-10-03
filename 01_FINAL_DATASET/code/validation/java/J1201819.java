import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		ARC006ASolve solve = new ARC006ASolve();
		solve.main();
	}
}

class ARC006ASolve {
	
	int N;
	int[] E;
	int B;
	int[] L;
	
	ARC006ASolve() {
		Scanner cin = new Scanner(System.in);
		this.N = 6;
		this.E = new int[N];
		for (int i = 0; i < N; i++) {
			E[i] = cin.nextInt();
		}
		this.B = cin.nextInt();
		this.L = new int[N];
		for (int i = 0; i < N; i++) {
			this.L[i] = cin.nextInt();
		}
	}
	
	void main() {
		int[] nums = new int[10];
		for (int i = 0; i < N; i++) {
			nums[E[i]]++;
		}
		for (int i = 0; i < N; i++) {
			nums[L[i]]++;
		}
		
		int count = 0;
		for (int i = 0; i < 10; i++) {
			if (nums[i] == 2) {
				count++;
			}
		}
		if (count == 5 && nums[B] == 1) {
			System.out.println(2);
		} else if (count == 6) {
			System.out.println(1);
		} else if (count == 5) {
			System.out.println(3);
		} else if (count == 4) {
			System.out.println(4);
		} else if (count == 3) {
			System.out.println(5);
		} else {
			System.out.println(0);
		}
		
	}
}
