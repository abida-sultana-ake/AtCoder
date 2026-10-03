import java.util.Scanner;

/**
 * http://abc029.contest.atcoder.jp/tasks/abc029_d
 */
public class Main {

	private final static int MAX_SIZE = 10; 
	private final static long dp[][] = new long[MAX_SIZE][10];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final long N = sc.nextLong();
		sc.close();
		
		for(int s=0; s<MAX_SIZE; s++){
			for(int d=0; d<10; d++){
				if(s==0){
					dp[s][d] = d==1 ? 1 : 0;
				}else{
					for(int bd=0; bd<10; bd++){
						dp[s][d] += dp[s-1][bd];
					}
					if(d==1) dp[s][d] += (long) Math.pow(10,s);
				}
			}
		}
		
		System.out.println(getCount(N));

	}
	
	
	private static long getCount(long targetNum){
		long count = 0;
		String numStr = String.valueOf(targetNum);
		for(int i=numStr.length()-1; i>=0; i--){
			int num = numStr.charAt(numStr.length()-i-1) - '0';
			for(int d=0; d<num; d++){
				count += dp[i][d];
			}
			if(num==1){
				if(i>0){
					count += Long.valueOf(numStr.substring(numStr.length()-i, numStr.length())) + 1;
				}else{
					count += 1;
				}
			}
		}
		return count;
	}


}