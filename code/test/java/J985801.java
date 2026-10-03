import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		SumTotalSequence sumTotal = new SumTotalSequence();
		sumTotal.run();
	}
}

class SumTotalSequence {
	
	int N;
	int K;
	int[] nums;
	
	SumTotalSequence() {
		Scanner cin = new Scanner(System.in);
		this.N = cin.nextInt();
		this.K = cin.nextInt();
		this.nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = cin.nextInt();
		}
	}
	
	void run() {
		
		long sum = 0;
		long tmpSum = 0;
		
		for (int i = 0; i < N; i++) {
			if (i < K) {
				sum += nums[i];
				tmpSum += nums[i];
			} else {
				tmpSum += nums[i];
				tmpSum -= nums[i - K];
				sum += tmpSum;
			}
		}
		
		System.out.println(sum);
			
	}
	
}
