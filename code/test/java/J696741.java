import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	
	static int[] primes40 = {2,3,5,7,11,13,17,19,23,29,
			31,37,41,43,47,53,59,61,67,71,
			73,79,83,89,97,101,103,107,109,113,
			127,131,137,139,149,151,157,163,167,173};
	
	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) {
		// 入力
		final int k;	
		try(Scanner scan = new Scanner(System.in)) {
			k = scan.nextInt();	// 1≦K≦40
		}
		
		
		// 再帰した回数がkとなる。
		/* k = 40となる値の組を考えればそこから互除法をすればできる。
		 * フィボナッチ数列? 
		 * 0 1 2 3 5 8 13 21 34
		 * 隣り合う項が2倍以上に開くことない。
		 */
		int result1 = 0;
		int result2 = 1;
		
		for (int i = 0; i < k; i++){
			int temp = result1 + result2;
			result1 = result2;
			result2 = temp;
		}
		
		out.println(result1 + " " + result2);
		out.flush();
		
	}

}