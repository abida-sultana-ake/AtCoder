import java.util.*;

// ABC 22-C
// http://abc022.contest.atcoder.jp/tasks/abc022_c

public class Main {

	static int n;
	static int[][] map;
	
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
	    
	    n = in.nextInt();
	    int m = in.nextInt();
	    
	    map = new int[n][n];
	    for (int i = 0; i < m; i++) {
	    	int a = in.nextInt() - 1;
	    	int b = in.nextInt() - 1;
	    	map[a][b] = 1;
	    	map[b][a] = 1;
	    }
	    
	    for (int i = 0; i < n; i++) {
	    	System.out.println(solve(i));
	    }
	}
	
	public static int solve(int start) {
		int count = 0;
		ArrayList<Integer> counted = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (map[start][i] == 1) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1 && start != j && map[start][j] == 0 && !counted.contains(j)) {
						count++;
						counted.add(j);
					}
				}
			}
		}
		return count;
	}
}
