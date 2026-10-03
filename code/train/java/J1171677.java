import java.util.*;

/* 階乗の素因数分解の仕方。参考: https://youtu.be/28IanD3lXGg */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
	
		// find prime factor
		int[] primeFactor = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			int x = i;
			while (1 < x) {
				for (int j = 2; j <= x; j++) {
					if (x % j == 0) {
						primeFactor[j]++;
						x /= j;
						break;
					}
				}
			}
		}
		
		long count = 1;
		for (int i = 2; i <= n; i++) {
			count *= (primeFactor[i] + 1);
			count %= 1000000007;
		}
		System.out.println(count);
	}
	
}