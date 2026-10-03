import java.util.*;

// ARC 82-D
// https://beta.atcoder.jp/contests/arc082/tasks/arc082_b

public class Main {
	
	static int N;
	static int answer = Integer.MAX_VALUE;

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		int[] nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = in.nextInt();
		}
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			if (i + 1 == nums[i]) {
				// Not the end of the array
				if (i != N - 1) {
					swap(nums, i, i + 1);
				} else {
					swap(nums, i, i - 1);
				}
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

