import java.util.*;

public class Main {
		static Scanner sc = new Scanner(System.in);
		
	public static void main(String[] args) {
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		String[] A = new String[N];
		String[] B = new String[M];
		for (int i = 0; i < N; i++) {
			A[i] = sc.next();
		}
		for (int i = 0; i < M; i++) {
			B[i] = sc.next();
		}
		
		for (int i = 0; i<= N - M; i++) {
			for (int j = 0; j <= N-M; j++){
				if(A[i].substring(j, j + M).equals(B[0])){
					if(submat(A, B, i, j)==1) {
						System.out.println("Yes");
						return;
					}
					
				}
			}
		}
		System.out.println("No");

	}
	static int submat(String[] a, String[] b, int i, int j){
		for (int k = 0; k < b.length; k++) {
			if(!a[i+k].substring(j,  j + b.length).equals(b[k])) {
				return 0;
			}
		}
		return 1;
	}

}
