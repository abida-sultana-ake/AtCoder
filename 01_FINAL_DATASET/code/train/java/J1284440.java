import java.util.*;

// ABC 27-C
// http://abc027.contest.atcoder.jp/tasks/abc027_c
 
public class Main {
	
	public static void main (String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[] answer = new int[n];
		
		for (int i = 0; i < m; i++) {
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			
			answer[a]++;
			answer[b]++;
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(answer[i]);
		}
	}
	
	
}