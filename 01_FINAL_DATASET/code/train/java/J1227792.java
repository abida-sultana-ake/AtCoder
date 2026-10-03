import java.util.*;

// ABC 32-D
// http://abc032.contest.atcoder.jp/tasks/abc032_d
 
public class Main {
	
	public static void main (String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		if (n * 4 < m || m < 2 * n) {
			System.out.println("-1 -1 -1");
		} else {
			int a = 0, b = 0, c = 0; // a: 大人, b: 老人, c: 赤ちゃん
			int X = 4 * n - m;
			int Y = X / 2;
			int Z = (X + 1) / 2;
			
			System.out.printf("%d %d %d\n", Y, X % 2 == 0 ? 0 : 1, n - Z);
		}
	}
}