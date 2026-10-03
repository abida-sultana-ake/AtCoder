import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * http://abc026.contest.atcoder.jp/tasks/abc026_c
 */
public class Main {
	
	static Map<Integer,Set<Integer>> rel = new HashMap<>();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final int N = sc.nextInt();
		for(int i=1; i<=N; i++) rel.put(i, new HashSet<>());
		for(int i=2; i<=N; i++) rel.get(sc.nextInt()).add(i);
		sc.close();
		
		System.out.println(dfs(1));

	}

	 static int dfs(int id) {
		if(rel.get(id).isEmpty()){
			return 1;
		}
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i: rel.get(id)){
			int s = dfs(i);
			max = Math.max(max, s);
			min = Math.min(min, s);	
		}
		return max+min+1;
	}

}