import java.util.*;

// ABC 22-C
// http://abc022.contest.atcoder.jp/tasks/abc022_c
 
public class Main {

	public static void main (String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);
		
		long n = in.nextLong();
		for (int i = (int) Math.sqrt(n); i > 0; i--) {
			if (n % i == 0) {
				System.out.println(Math.max(numDigit(i), numDigit((int) (n / i))));
				break;
			}
		}
	}
	
	public static int numDigit(int n) {
		int answer = 0;
		while (n > 0) {
			answer++;
			n /= 10;
		}
		return answer;
	}
}