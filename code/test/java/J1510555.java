import java.util.*;

public class Main {
	ArrayList<ArrayList<Edge>> pass;
	long [] close;
	
	class Edge implements Comparable<Edge>{
		int from,to, cost;
		public Edge(int from, int to, int cost) {
			this.from = from; this.to = to; this.cost = cost;
		}
		public int compareTo(Edge o) {
			if(this.cost < o.cost)return -1;
			if(this.cost > o.cost)return 1;
			return 0;
		}
	}
	
	void dfs(int now, int prev, long value){
		close[now] = value;
		
		for(Edge e: pass.get(now)){
			if(e.to == prev) continue;
			dfs(e.to, now, value + e.cost);
		}
	}
	
	private void doit(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			pass = new ArrayList<>();
			for(int i = 0; i < n; i++){
				pass.add(new ArrayList<>());
			}
		
			
			for(int i =0; i < n-1; i++){
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1; 
				int c = sc.nextInt();
				pass.get(a).add(new Edge(a, b, c));
				pass.get(b).add(new Edge(b, a, c));
			}
			int q = sc.nextInt();
			int start = sc.nextInt() -1;
			
			close = new long[n];
			Arrays.fill(close, Long.MAX_VALUE);
			dfs(start, -1, 0);
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < q; i++){
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				sb.append(close[x] + close[y] + "\n");
			}
			System.out.print(sb.toString());
		}

	}


	private void debug(Object... o) {
		System.out.println("debug = " + Arrays.deepToString(o));
	}

	public static void main(String[] args) {
		new Main().doit();
	}

}
