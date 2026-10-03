import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = sc.nextInt();
		}
		sc.close();
		int ans = 0;
		for(int i=0; i<N-1; i++) {
			if(i+1 == p[i]) {
				swap(p, i, i+1);
				ans++;
			}
		}
		if(p[N-1] == N) ans++;
		System.out.println(ans);
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}