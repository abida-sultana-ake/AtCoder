import java.util.Scanner;

/**
 * http://abc034.contest.atcoder.jp/tasks/abc034_b
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		sc.close();
		
		int ans = n%2==0 ? n-1 : n+1 ;
		System.out.println(ans);

	}

}
