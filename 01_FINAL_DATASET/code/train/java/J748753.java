import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
 
public class Main {
	static int INF = (int)1e9 + 7;
	int N;
	P[] ps;
	
	private class P implements Comparable<P>{
 
		int w,h;
 
		public P(int w,int h){
			this.w = w;
			this.h = h;
		}
 
		public int compareTo(P other){
			if(this.w < other.w ){
				return -1;
			}else if(this.w > other.w){
				return 1;
			}
			
			if(this.h < other.h){
				return -1;
			}else if(this.h > other.h){
				return 1;
			}
			
			return 0;
		}
	}
 
	public void solve() {
		N = nextInt();
		ps = new P[N];
		for(int i = 0;i < N;i++){
			int W = nextInt();
			int H = nextInt();
			
			ps[i] = new P(W,-H);
		}
		
		Arrays.sort(ps);
		
		int[] dp = new int[N];
		Arrays.fill(dp,INF);
		
		for(int i = 0;i < N;i++){
			int left = -1;
			int right = N - 1;
			while(right - left > 1){
				int mid = ((left + right) >>> 1);
				if(dp[mid] < -ps[i].h){
					left = mid;
				}else{
					right = mid;
				}
			}
			dp[right] = -ps[i].h;
		}
		
		int l = -1,r = N;
		while(r - l > 1){
			int m = ((l + r) >>> 1);
			if(dp[m] < INF){
				l = m;
			}else{
				r = m;
			}
		}
		out.println(r);
	}
 
	public static void main(String[] args) {
		out.flush();
		new Main().solve();
		out.close();
	}
 
	/* Input */
	private static final InputStream in = System.in;
	private static final PrintWriter out = new PrintWriter(System.out);
	private final byte[] buffer = new byte[2048];
	private int p = 0;
	private int buflen = 0;
 
	private boolean hasNextByte() {
		if (p < buflen)
			return true;
		p = 0;
		try {
			buflen = in.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (buflen <= 0)
			return false;
		return true;
	}
 
	public boolean hasNext() {
		while (hasNextByte() && !isPrint(buffer[p])) {
			p++;
		}
		return hasNextByte();
	}
 
	private boolean isPrint(int ch) {
		if (ch >= '!' && ch <= '~')
			return true;
		return false;
	}
 
	private int nextByte() {
		if (!hasNextByte())
			return -1;
		return buffer[p++];
	}
 
	public String next() {
		if (!hasNext())
			throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = -1;
		while (isPrint((b = nextByte()))) {
			sb.appendCodePoint(b);
		}
		return sb.toString();
	}
 
	public int nextInt() {
		return Integer.parseInt(next());
	}
 
	public long nextLong() {
		return Long.parseLong(next());
	}
 
	public double nextDouble() {
		return Double.parseDouble(next());
	}
}