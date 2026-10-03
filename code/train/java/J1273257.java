import java.util.*;


public class Main {
	
	Scanner cin = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Main().run(); 
	}
	
	int A = 0, B = 0;
	int n;
	
	public void run() {		
		
		/*input*/
		n = cin.nextInt();
		int[] nums = new int[n];
		
		for (int i = 0; i < n; i ++) {
			nums[i] = cin.nextInt();
		}
		
		Arrays.sort(nums);
		
		if (nums[0] == nums[n - 1]) {
			System.out.println(0);
			return;
		}
		/*start*/
		
		for (int i = 0; i < n; i ++) {
			A += nums[i];
			B += nums[i] * nums[i];
		}
		
		int left = nums[0], right = nums[n - 1];
		
		
		for (int i = 0; i < 100; i ++) {
			int leftThird = (left * 2 + right) / 3;
			int rightThird = (left + right * 2) / 3;
			
			int m1 = func(leftThird);
			int m2 = func(rightThird);
			if (m1 <= m2) {
				right = rightThird;
			} else {
				left = leftThird;
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int  i = left; i <= right; i ++) {
			min = Math.min(min, func(i));
		}
		
		/*finish*/
		System.out.println(min);
	}
	
	public int func(int x) {
		
		return n * x * x - 2 * A * x + B; 
	}
}

