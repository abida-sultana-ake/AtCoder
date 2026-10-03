import java.util.Arrays;
import java.util.Scanner;

/**
 * http://abc019.contest.atcoder.jp/tasks/abc019_1
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final int N=3;
		int a[] = new int[N];
		for(int i=0; i<N; i++) a[i] = sc.nextInt();
		sc.close();
		
		Arrays.sort(a);
		System.out.println(a[N/2]);

	}

}