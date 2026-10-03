import java.util.*;

// ABC 43-C
// http://abc043.contest.atcoder.jp/tasks/arc059_a

public class Main {
	
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
	    
	    int n = in.nextInt();
	    int[] nums = new int[n];
	    int sum = 0;
	    
	    for (int i = 0; i < n; i++) {
	    	nums[i] = in.nextInt();
	    	sum += nums[i];
	    }
	    
	    int avg = sum / n; // Probably need to investigate avg + 1 too
	    
	    System.out.println(Math.min(cost(nums, avg), cost(nums, avg + 1)));
	}
	
	public static int cost(int[] nums, int avg) {
		int cost = 0;
		for (int i = 0; i < nums.length; i++) {
			cost += (nums[i] - avg) * (nums[i] - avg);
		}
		return cost;
	}
}
