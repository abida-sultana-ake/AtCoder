import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static long[] x = new long[100010];
	private static long[] y = new long[100010];
	
	private static final long MOD = 1000000007;
	private static List<Long> list1 = new ArrayList<Long>() , list2 = new ArrayList<Long>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int i , j , n = scan.nextInt() , m = scan.nextInt();
		for (i = 0;i < n;i ++) {
			x[i] = scan.nextLong();
		}
		for (i = 0;i < m;i ++) {
			y[i] = scan.nextLong();
		}
		Arrays.sort(x , 0 , n);
		Arrays.sort(y , 0 , m);
	
		for (i = 0;i < n - 1;i ++) {
			long temp = x[i + 1] - x[i];
			list1.add(temp);
		}
		for (i = 0;i < m - 1;i ++) {
			long temp = y[i + 1] - y[i];
			list2.add(temp);
		}
		
		n = list1.size();
		m = list2.size();
		long value = 0 , ans = 0;
		for (i = 0;i < n;i ++) {
			long temp = ((long) (i + 1) * (long) (n - i)) % MOD;
			value = (value + (temp * list1.get(i)) % MOD) % MOD;
		}
		
		for (i = 0;i < m;i ++) {
			long temp = ((long) (i + 1) * (long) (m - i)) % MOD;
			ans = (ans + (((temp * list2.get(i)) % MOD) * value) % MOD) % MOD;
		}
		System.out.println(ans);
		
	}

} 



