import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] T = new int[N][K];
		for(int i=0; i<N; i++) {
			for(int j=0; j<K; j++) {
				T[i][j] = sc.nextInt();
			}
		}
		sc.close();
		for(int i=0; i<K; i++) {
			if(find(T, N, K, 1, T[0][i])) {
				System.out.println("Found");
				return;
			}
		}
		System.out.println("Nothing");
		return;
	}
	
	static boolean find(int[][] T, int N, int K, int times, int xor) {
		if(times == N) {
			if(xor == 0) {
				return true;
			} else {
				return false;
			}
		}
		for(int i=0; i<K; i++) {
			if(find(T, N, K, times+1, xor^T[times][i])) {
				return true;
			}
		}
		return false;
	}

}