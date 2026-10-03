import java.io.*;
import java.util.*;
 
public class Main{
	class Pair{
		public final int x;
		public final int y;
		public final int hash;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
			
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			
			this.hash = result; 
		}
		@Override
		public int hashCode() {
			return hash;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		private Main getOuterType() {
			return Main.this;
		}
		
		public Pair newPair(int i ){
			return new Pair(x + DX[i], y + DY[i]);
		}
		
	}
	
	int[] DX = {-1, 0, 1, -1, 1,  -1,  0,   1};
	int[] DY = {1,  1, 1,  0, 0,  -1, -1,  -1};
	
	public void solve(){
		int H = nextInt();
		int W = nextInt();
		int N = nextInt();
		HashSet<Pair> hash = new HashSet<>(N * 2);
		HashSet<Pair> flg = new HashSet<>(N * 2 * 8);
		
		for(int i = 0; i < N; i++){
			int a = nextInt();
			int b = nextInt();
			hash.add(new Pair(b, a));
		}
		
		long[] ans = new long[10];
		ans[0] = (long)(H - 2) * (W - 2);
		for(Pair p : hash){
			Pair np = p;
			if(!flg.contains(np) && 2 <= np.x && np.x <= (W - 1) && 2 <= np.y && np.y <= (H - 1)){
				int cnt = 0;
				if(hash.contains(np)) cnt++;
				for(int j = 0; j < 8; j++){
					if(hash.contains(np.newPair(j))) cnt++;
				}
				ans[0] --;
				ans[cnt]++;
				flg.add(np);
			}
			
			for(int i = 0; i < 8; i++){
				np = p.newPair(i);
				if(!flg.contains(np) && 2 <= np.x && np.x <= (W - 1) && 2 <= np.y && np.y <= (H - 1)){
					int cnt = 0;
					if(hash.contains(np)) cnt++;
					for(int j = 0; j < 8; j++){
						if(hash.contains(np.newPair(j))) cnt++;
					}
					ans[0] --;
					ans[cnt]++;
					flg.add(np);
				}
			}
		}
		for(int i = 0; i < 10; i++){
			out.println(ans[i]);
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