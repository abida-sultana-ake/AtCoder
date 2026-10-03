import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
public class Main {
	long N,S;

	public long f(long b,long n){
		if(n < b)return n;
		return f(b,n / b) + (n % b);
	}

	public void solve() {
		N = nextLong();
		S = nextLong();

		if(N == S){
			out.println(N + 1);
			return;
		}
		long ans = Long.MAX_VALUE;
		for(int i = 2;(long)i * i <= N;i++){
			long res = f(i,N);
			if(res == S){
				ans = Math.min(ans,i);
			}
		}

		for(int i = 1;(long)i * i <= N - S;i++){
			long B = (N - S) / i + 1;
			if(f(B,N) == S){
				ans = Math.min(ans,B);
			}
		}
		out.println(ans == Long.MAX_VALUE ? -1 : ans);
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