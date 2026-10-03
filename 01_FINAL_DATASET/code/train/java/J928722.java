import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// get a integer
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(Main.possibleWaystoPaint(N, K));
		sc.close();
	}
	
	static int possibleWaystoPaint(int N, int K) {
		int result = K;
		for (int i = 0; i < N-1; i++)
			result *= (K-1);
		return result;
	}

}