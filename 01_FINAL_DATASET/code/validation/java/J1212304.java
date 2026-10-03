import java.util.*;
import java.awt.Point;

// ABC 15-C
// http://abc015.contest.atcoder.jp/tasks/abc015_3
 
public class Main {
	
	static int n;
	static int k;
	static int[][] nums;
	static boolean isBug = false;
	
	public static void main (String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		k = in.nextInt();
		
		nums = new int[n][k];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				nums[i][j] = in.nextInt();
			}
		}
		
		for (int i = 0; i < k; i++) {
			solve(1, nums[0][i]);
		}
		
		System.out.println(isBug ? "Found" : "Nothing");
	}
	
	public static void solve(int index, int xor) {
		if (isBug) {
			return;
		}
		if (index == n) {
			if (xor == 0) {
				isBug = true;
			}
			return;
		}
		
		for (int i = 0; i < k; i++) {
			solve(index + 1, xor ^ nums[index][i]);
		}
	}
}
