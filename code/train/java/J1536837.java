import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * http://abc029.contest.atcoder.jp/tasks/abc029_c
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final int N = sc.nextInt();
		sc.close();
		
		List<String> ans = new ArrayList<>();
		dfs(N,"",ans);
		
		for(String a:ans){
			System.out.println(a);
		}

	}

	static void dfs(int n, String s, List<String> ans) {
		if(n==0){
			ans.add(s);
		}else{
			dfs(n-1, s+"a", ans);
			dfs(n-1, s+"b", ans);
			dfs(n-1, s+"c", ans);
		}
		
	}

}
