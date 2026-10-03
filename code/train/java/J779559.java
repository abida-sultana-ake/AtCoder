
import java.io.*;
import java.util.*;
 
public class Main{
	
	int N, M, S;
	ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	UnionFind uf;
	
	public void solve(){
		int N = nextInt();
		int M = nextInt();
		int S = nextInt();
		uf = new UnionFind(N + 1);
		
		for(int i = 0; i <= N; i++){
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++){
			int u = nextInt();
			int v = nextInt();
			int uu = Math.min(u, v);
			int vv = Math.max(u, v);
			list.get(uu).add(vv);
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = N; i > 0; i--){

			for(int v : list.get(i)){
				uf.union(v, i);
			}
			
			if(uf.find(S, i)){
				ans.add(i);
			}
			
		}
		
		for(int i = ans.size() - 1; i >= 0; i--){
			out.println(ans.get(i));
		}
	}
	
	class UnionFind{
		int[] tree;
		public UnionFind(int n){
			tree = new int[n];
			for(int i = 0; i < n; i++){
				tree[i] = -1;
			}
		}
		
		int root(int x){
			if(tree[x] < 0) return x;
			else return tree[x] = root(tree[x]);
		}
		
		boolean find(int x, int y){
			return root(x) == root(y);
		}
		
		int union(int x, int y){
			x = root(x);
			y = root(y);
			if(x != y){
				if(tree[x] < tree[y]){
					tree[y] += tree[x];
					tree[x] = y;
					return -tree[y];
				}else{
					tree[x] += tree[y];
					tree[y] = x;
					return -tree[x];
				}
			}
			return -tree[x];
		}
		
		int size(int x){
			return -tree[root(x)];
		}
	}

	
	private static PrintWriter out;
	public static void main(String[] args){
		out = new PrintWriter(System.out);
		new Main().solve();
		out.flush();
	}
	
	
	
	public static int nextInt(){
		int num = 0;
		String str = next();
		boolean minus = false;
		int i = 0;
		if(str.charAt(0) == '-'){
			minus = true;
			i++;
		}
		int len = str.length();
		for(;i < len; i++){
			char c = str.charAt(i);
			if(!('0' <= c && c <= '9')) throw new RuntimeException();
			num = num * 10 + (c - '0');
		}
		return minus ? -num : num;
	}
	
	public static long nextLong(){
		long num = 0;
		String str = next();
		boolean minus = false;
		int i = 0;
		if(str.charAt(0) == '-'){
			minus = true;
			i++;
		}
		int len = str.length();
		for(;i < len; i++){
			char c = str.charAt(i);
			if(!('0' <= c && c <= '9')) throw new RuntimeException();
			num = num * 10l + (c - '0');
		}
		return minus ? -num : num;
	}
	public static String next(){
		int c;
		while(!isAlNum(c = read())){}
		StringBuilder build = new StringBuilder();
		build.append((char)c);
		while(isAlNum(c = read())){
			build.append((char)c);
		}
		return build.toString();
	}
	
	
	private static byte[] inputBuffer = new byte[1024];
	private static int bufferLength = 0;
	private static int bufferIndex = 0;
	private static int read(){
		if(bufferLength < 0) throw new RuntimeException();
		if(bufferIndex >= bufferLength){
			try{
				bufferLength = System.in.read(inputBuffer);
				bufferIndex = 0;
			}catch(IOException e){
				throw new RuntimeException(e);
			}
			if(bufferLength <= 0) return (bufferLength = -1);
		}
		return inputBuffer[bufferIndex++];
	}
	
	private static boolean isAlNum(int c){
		return '!' <= c && c <= '~';
	}
}