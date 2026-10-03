import java.util.*;

// ABC 13-C
// http://abc013.contest.atcoder.jp/tasks/abc013_3
 
public class Main {
	
	public static void main (String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);

		long N = in.nextLong();
		long H = in.nextLong();
		
		long A = in.nextLong();
		long B = in.nextLong();
		long C = in.nextLong();
		long D = in.nextLong();
		long E = in.nextLong();
		
		long answer = Long.MAX_VALUE;
		
		for (int x = 0; x <= N; x++) {
			long y = (E*N - E*x - B*x - H) / (D + E);
			
			if (y < 0) {
				y = 0;
			}
			
			while (x + y <= N) {
				if (B*x + D*y + H - E*(N - x - y) > 0) {
					answer = Math.min(answer, A*x + C*y);
					break;
				}
				y++;
			}
			
			
//			long top = E*N - E*x - B*x - H;
//			long bottom = D + E;
//
//			long y = top / bottom;
//			if (y < 0) {
//				y = 0;
//			} else {
//				y++;
//			}
//			if (x + y <= N) {
//				answer = Math.min(answer, A*x + C*y);
//			}
		}
		System.out.println(answer);
	}
}
