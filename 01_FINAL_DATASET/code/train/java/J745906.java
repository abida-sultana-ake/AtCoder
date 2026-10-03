
import java.io.*;
import java.util.*;
import java.util.function.IntPredicate;
 
public class Main{
	class Box implements Comparable<Box>{
		int h;
		int w;
		public Box(int w, int h){
			this.h = h;
			this.w = w;
		}
		
		public int compareTo(Box b){
			if(w < b.w){
				return -1;
			}else if(w > b.w){
				return 1;
			}else{
				return Integer.compare(b.h, h);
			}
		}

	}
 
	public void solve(){
		int N = nextInt();
		Box[] boxes = new Box[N];
		
		for(int i = 0; i < N; i++){
			boxes[i] = new Box(nextInt(), nextInt());
		}
		Arrays.sort(boxes);
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		int dplen = 0;
		for(int i = 0; i < N; i++){
		/*	for(int j = 0; j <= dplen; j++){
				if(j == 0 || dp[j - 1] < boxes[i].h){
					if(dp[j] > boxes[i].h) dp[j] = boxes[i].h;
					dplen = Math.max(dplen, j + 1);
				}
			}*/
			
			height = boxes[i].h;
			int idx = lowerBound(0, N, v -> dp[v] >= height);
			dp[idx] = height;
		}
		
		for(int i = 0; i < dp.length; i++){
			if(dp[i] == Integer.MAX_VALUE){
				out.println(i);
				return;
			}
		}
			
	}
	int height;

	public int lowerBound(int begin, int end, IntPredicate check){
		int l = begin - 1;
		int r = end;
		while(r - l > 1){
			int m = (r + l) / 2;
			if(check.test(m)){
				r = m;
			}else{
				l = m;
			}
		}
		return r;
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