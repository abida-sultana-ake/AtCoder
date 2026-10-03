
import java.io.*;
import java.util.*;
 
public class Main{
	int N;
	int[][] A;
	
	class Pair{
		int u, v, d;
		public Pair(int u, int v, int d){
			this.u = u;
			this.v = v;
			this.d = d;
		}
	}
	public void solve(){
		N = nextInt();
		A = new int[N][N];
		long[][] ans = new long[N][N];
		Pair[] pair = new Pair[N * (N + 1) / 2];
		int idx = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				A[i][j] = nextInt();
				if(i < j){
					pair[idx++] = new Pair(i, j, A[i][j]);
				}
				if(i == j) ans[i][j] = 0;
				else ans[i][j] = Integer.MAX_VALUE;
			}
		}
		Arrays.sort(pair, 0, idx, (a, b) -> Integer.compare(a.d, b.d));
		long sum = 0;
		for(int i = 0; i < idx; i++){
			Pair p = pair[i];
			if(ans[p.u][p.v] == p.d){
				continue;
			} else if(ans[p.u][p.v] < p.d){
				sum = -1;
				break;
			}
			sum += p.d;
			ans[p.u][p.v] = p.d;
			ans[p.v][p.u] = p.d;
			for(int j = 0; j < N; j++){
				for(int k = 0; k < N; k++){
					ans[j][k] = Math.min(ans[j][k], ans[j][p.u] + p.d + ans[p.v][k]);
					ans[k][j] = Math.min(ans[k][j], ans[k][p.v] + p.d + ans[p.u][j]);
				}
			}
		}
		boolean flg = true;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				flg &= ans[i][j] == A[i][j];
			}
		}
		if(flg){
			out.println(sum);
		}else{
			out.println(-1);
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