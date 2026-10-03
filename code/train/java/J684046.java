import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long R = sc.nextLong();
		long B = sc.nextLong();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		long max = Math.min(R, B)+1;
		long min = 0;
		while(min+1<max) {
			long mid = (min+max)/2;
			if(check(R, B, x, y, mid))
				min = mid;
			else
				max = mid;
		}
		
		System.out.println(min);
		sc.close();
	}
	
	static boolean check(long R, long B, int x, int y, long N) {
		if(R<N || B<N)
			return false;
		long typeA = x==1 ? N : Math.min((R-N)/(x-1), N);
		return B>=typeA && (B-typeA)/y>=N-typeA;
	}
}