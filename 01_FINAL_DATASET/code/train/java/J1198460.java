import java.util.*;

// ABC 29-C
// http://abc029.contest.atcoder.jp/tasks/abc029_c

public class Main {

	static int sumCount = 0;
	static int[] nums;
	static int[] sums;
	
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);

	    nums = new int[5];
	    sums = new int[10];
	    
	    for (int i = 0; i < 5; i++) {
	    	nums[i] = in.nextInt();
	    }
	    solve(0, 0, 0);
	    Arrays.sort(sums);
	    System.out.println(sums[7]);
	}
	
	public static void solve(int count, int index, int sum) {
		if (count == 3) {
			sums[sumCount] = sum;
			sumCount++;
			return;
		}
		if (count > 3 || index == nums.length) {
			return;
		}
		// Don't pick it
		solve(count, index + 1, sum);
		// Pick it
		solve(count + 1, index + 1, sum + nums[index]);
	}
}
