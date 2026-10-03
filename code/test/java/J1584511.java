import java.util.Scanner;

/**
 * http://abc032.contest.atcoder.jp/tasks/abc032_a
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		
		long lcm =getLcm(a,b);
		long ans = 0;
		while(ans<n) ans+=lcm;
		
		System.out.println(ans);
		
	}
	
	static long getLcm(long a, long b){
	    return (a/getGcd(a,b))*b;
	}
	
	static long getGcd(long a, long b){
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}
	
}