import java.util.*;

public class Main {

	static int n;
	static int answer;
	static int[][] map;
	static int[] visited;
	static int numVisited;
	
	public static void main(String[] args) {
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
		
		answer = 0;
		visited = new int[n];
		visited[0] = 1;
		numVisited = 1;
		solve(0);
		
		System.out.println(answer);
	}
	
	public static void solve(int v) {
		boolean allVisited = true;
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				allVisited = false;
				break;
			}
		}
		
		if (allVisited) {
			answer++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (map[v][i] == 1 && visited[i] == 0) {
				numVisited++;
				visited[i] = 1;
				solve(i);
				visited[i] = 0;
				numVisited--;
			}
		}
	}
}