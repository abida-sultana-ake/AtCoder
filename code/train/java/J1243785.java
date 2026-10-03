import java.util.*;

// ABC 59-C
// http://abc059.contest.atcoder.jp/tasks/arc072_a
 
public class Main {
	
	public static void main (String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);
		
		long n = in.nextLong();
		solve(n);
	}
	
	public static void solve(long n) {
		String winner = "";
		
		if (n == 1) {
			winner = "Aoki";
		} else if (n == 2 || n == 3) {
			winner = "Takahashi";
		} else {
			int numBit = sigBit(n);
			boolean isInArow = numBit % 2 == 0;
			long left = (long) 1 << numBit;
			long right = (long) 1 << (numBit + 1);
			
			long zigzag = zigzag(numBit, isInArow);
			
			if (isInArow) {
				if (left <= n && n < zigzag) {
					winner = "Takahashi";
				} else {
					winner = "Aoki";
				}
			} else {
				if (zigzag <= n && n < right) {
					winner = "Takahashi";
				} else {
					winner = "Aoki";
				}
			}
		}
		
		System.out.println(winner);
	}
	
	public static long zigzag(int numBit, boolean isInArow) {
		long returnv = 1;
		for (int i = 1; i <= numBit; i++) {
			// We can shorten this code, but to make the logic easy to understand, I leave this in redundant way.
			// If it is in A row, A always go to right and B always go to left
			if (isInArow) {
				// This is A action. Go right
				if (i % 2 == 1) {
					returnv *= 2;
					returnv++;
				}
				// This is B action. Go left
				else {
					returnv *= 2;
				}
			}
			// If it is in B row, A always go to left and B always go to right
			else {
				// This is A action. Go left
				if (i % 2 == 1) {
					returnv *= 2;
				}
				// This is B action. Go right
				else {
					returnv *= 2;
					returnv++;
				}
			}
		}
		return returnv;
	}
	
	public static int sigBit(long a) {
		int num = 0;
		while ((a >> 1) > 0) {
			a = a >> 1;
			num++;
		}
		return num;
	}
}