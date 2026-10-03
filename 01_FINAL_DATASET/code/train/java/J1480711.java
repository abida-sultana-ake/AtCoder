import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0 ; i < N ; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		long ans = 1;
		//N人が偶数人か奇数人か
		if(N % 2 == 0) {
			//並び方があり得るかを検証
			for(int i = N - 1 ; i > 0 ; i -= 2) {
				if(A[i] != A[i - 1]) {
					System.out.println(0);
					return;
				}
			}
			for(int i = 0 ; i < N / 2 ; i++) {
				ans = ans * 2 % 1000000007;
			}
			System.out.println(ans);
		} else {
			//並び方があり得るかを検証
			if(A[0] != 0) {
				System.out.println(0);
				return;
			}
			for(int i = 1 ; i < N ; i += 2) {
				if(A[i] != A[i + 1]) {
					System.out.println(0);
					return;
				}
			}
			//何通りの並べ方があるか検証
			for(int i = 0 ; i < N / 2 ; i++) {
				ans = ans * 2 % 1000000007;
			}
			System.out.println(ans);
		}
	}
}
