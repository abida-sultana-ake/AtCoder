import java.util.*;

// ARC 57-A
// http://arc057.contest.atcoder.jp/tasks/arc057_a

public class Main {
	
	public static void main (String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		
		long A = in.nextLong();
		long K = in.nextLong();
		long nichoh = new Long("2000000000000");
		
		if (K == 0) {
			System.out.println(nichoh - A);
			return;
		}
		
		long low = 0;
		long high = new Long("2000000000000");
		
		while (low <= high) {
			long mid = (low + high) / 2;
			long k = mid - 1;
			
			long money = (long) ((long) A * Math.pow(K + 1, k));
			k--;
			while (k >= 0 && money < nichoh) {
				money += (long) Math.pow(K + 1, k);
				k--;
			}
			
//			System.out.printf("low: %d, high: %d, mid: %d, money: %d\n", low, high, mid, money);
			
			if (money >= nichoh) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		System.out.println(high);
	}
	
}
