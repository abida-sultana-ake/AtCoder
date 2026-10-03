import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * http://abc019.contest.atcoder.jp/tasks/abc019_3
 */
public class Main {

	static Set<Integer> dp = new HashSet<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final int N = sc.nextInt();
		int[] a = new int[N];
		for(int i=0; i<N; i++) a[i] = sc.nextInt();
		sc.close();
		
		Arrays.sort(a);
		int ans = 0;
		for(int i=0; i<N; i++){
			if(check(a[i])){
				ans++;
			}
			dp.add(a[i]);
		}
		
		System.out.println(ans);

	}
	
	static boolean check(int n){
		if(dp.contains(n)){
			return false;
		}else{
			if(n%2==0){
				return check(n/2);
			}else{
				return true;
			}
		}
	}

}