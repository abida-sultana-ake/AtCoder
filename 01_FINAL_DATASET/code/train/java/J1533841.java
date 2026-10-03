import java.util.Scanner;

/**
 * http://abc027.contest.atcoder.jp/tasks/abc027_c
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final long N = sc.nextLong()+1;
		sc.close();
		long current = 2;
		long r = 1;
		String ans="Aoki";
		while(current<N){
			r *= 4;
			current += r;
			if(current>=N){
				ans = "Takahashi";
				break;
			}
			current += r;
			if(current>=N){
				ans = "Aoki";
				break;
			}
		}
		System.out.println(ans);
	}

}
