import java.util.*;
 
public class Main {
	
	class UnionFind{
		int [] par, rank;
		int num;
		public UnionFind(int n) {
			par = new int[n];
			rank = new int[n];
			for(int i = 0 ; i < n; i++){
				par[i] = i;
				//rank[i] = 0;
			}
			num = n;
		}
		int find(int x){
			if(par[x] == x)return x;
			else return par[x] = find(par[x]);
		}
		void unite(int x, int y){
			x = find(x);
			y = find(y);
			if(x == y) return ;
			if(rank[x] < rank[y]) par[x] = y;
			else{
				par[y] = x;
				if(rank[x] == rank[y]) rank[x]++;
			}
			num--;
		}
		boolean same(int x, int y){
			return find(x) == find(y);
		}
	}
	
	private void doit(){
		
		Scanner sc = new Scanner(System.in);
		long mod = 1000000007;
		while(sc.hasNext()){
			int N = 100000 * 2;
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			int m = sc.nextInt();
			UnionFind uf = new UnionFind(n);
			for(int i = 0; i < k; i++){
				
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				uf.unite(a, b);
			}
			UnionFind uf2 = new UnionFind(n);
			for(int j = 0; j < m; j++){
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				uf2.unite(a,b);
			}
			
			TreeMap<Long, Integer> count = new TreeMap<>();
			for(int i=0;i< n;i++){
				long res = (long) uf.find(i) * N + uf2.find(i);
				if(! count.containsKey(res)){
					count.put(res, 1);
				}
				else{
					count.put(res, count.get(res) + 1);
				}
			}
			
			StringBuilder ans = new StringBuilder();
			for(int i =0;i<n;i++){
				int res = count.get((long) uf.find(i) * N + uf2.find(i));
				ans.append(" " + res);
			}
			System.out.println(ans.substring(1));
			
		}
 
	}
 
	private void debug(Object... o) {
		System.out.println("debug = " + Arrays.deepToString(o));
	}
 
	public static void main(String[] args) {
		new Main().doit();
	}
 
}