import java.util.Scanner;

/**
 * http://abc006.contest.atcoder.jp/tasks/abc006_1
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		boolean ans = N%3==0;
		System.out.println(ans ? "YES":"NO");

	}

}