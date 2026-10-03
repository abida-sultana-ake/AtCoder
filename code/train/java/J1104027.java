import java.util.Scanner;

public class Main {
	
	private static boolean[][] graph = new boolean[20][20];
	private static boolean[] vis = new boolean[20];
	private static int ans = 0;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int i , j , n , m;
		n = scan.nextInt();
		m = scan.nextInt();
		for (i = 0;i < m;i ++) {
			int from = scan.nextInt() , to = scan.nextInt();
			graph[from][to] = graph[to][from] = true;
		}
		dfs(1 , n , 0);
		System.out.println(ans);
		
	}	
	
	private static void dfs(int current , int n , int tot) {
			
		vis[current] = true;
		tot ++;
		
		if (tot == n) {
			ans ++;
		} else {
			for (int i = 1;i <= n;i ++) {
				if (!vis[i] && graph[current][i]) {
					dfs(i , n , tot);
				}
			}
		}
		
		vis[current] = false;
		
	}
	
}



