import java.util.Scanner;

/**
 * http://abc007.contest.atcoder.jp/tasks/abc007_4
 */
public class Main {
	
	private final static int MAX_SIZE = 19; 
	private final static long dp[][] = new long[MAX_SIZE][10];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		sc.close();
		
		for(int s=0; s<MAX_SIZE; s++){
			for(int d=0; d<10; d++){
				if(s==0){
					dp[s][d] = d==4 || d==9 ? 1 : 0;
				}else{
					if( d==4 || d==9){
						dp[s][d] = (long) Math.pow(10,s);
					}else{
						for(int bd=0; bd<10; bd++){
							dp[s][d] += dp[s-1][bd];
						}
					}
				}
			}
			// System.out.println(s + ":" + Arrays.toString(dp[s]));
		}
		
		System.out.println(getCount(b)-getCount(a-1));

	}
	
	
	private static long getCount(long targetNum){
		long count = 0;
		String numStr = String.valueOf(targetNum);
		for(int i=numStr.length()-1; i>=0; i--){
			int num = numStr.charAt(numStr.length()-i-1) - '0';
			for(int d=0; d<num; d++){
				count += dp[i][d];
			}
			// System.out.println(num + ":" + count);
			if(num==4||num==9){
				if(i>0){
					count += Long.valueOf(numStr.substring(numStr.length()-i, numStr.length())) + 1;
				}else{
					count += 1;
				}
				break;
			}
			
		}
		return count;
	}

}
