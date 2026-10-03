import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://abc021.contest.atcoder.jp/tasks/abc021_a
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final int N = sc.nextInt();
		sc.close();
		
		String binary = Integer.toBinaryString(N);
		
		List<Integer> ans = new ArrayList<Integer>();
		for(int i=0; i<=3; i++){
			if(binary.length()<i+1) continue;
			if(binary.charAt(binary.length()-i-1)=='1'){
				ans.add((int)Math.pow(2, i));
			}
		}
		
		System.out.println(ans.size());
		for(int a:ans) System.out.println(a);

	}

}