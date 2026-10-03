import java.util.*;


public class Main {
	int n;
	boolean [][]  pass;
	int ans;
	int [] low, pre;
	int ind;
	
	private void dfs(int now,int prev){
//		debug(now, prev);
		pre[now] = ind;
		low[now] = ind;
		ind++;
		
		
		for(int i = 0; i < n; i++){
			if(i == prev) continue;
			if(pass[now][i] == false) continue;
			
			if(pre[i] != -1){
				low[now] = Math.min(low[now], low[i]);
				continue;
			};

			dfs(i, now);
			low[now] = Math.min(low[now], low[i]);
			if(pre[i] == low[i]){
				ans++;
			}
		}
	}
	
	
	private void doit(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			n = sc.nextInt();
			int m = sc.nextInt();
			pass = new boolean[n][n];
			for(int i = 0; i < m; i++){
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				pass[a][b] = true;
				pass[b][a] = true;
			}
			ans = 0;
			ind = 1;
			low = new int[n];
			pre = new int[n];
			Arrays.fill(pre, -1);
			pre[0] = 0;
			low[0] = 0;
			
			dfs(0, -1);
			
			System.out.println(ans);
		}
	}



	private void debug(Object... o) {
		System.out.println("debug = " + Arrays.deepToString(o));
	}

	public static void main(String[] args) {
		new Main().doit();
	}

}
