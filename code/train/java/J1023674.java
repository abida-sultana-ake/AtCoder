import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {

	String s;

    public void solve() {
    	s = next();

    	//先頭と末尾の文字が同じなら最終的なsの長さは奇数
    	if(s.charAt(0) == s.charAt(s.length() - 1)){
    		//最初のsの長さが偶数なら奇数回ターンが経過しているということ
    		if(s.length() % 2 == 0){
    			out.println("First");
    		}else{
    			out.println("Second");
    		}
    	}else{
    		if(s.length() % 2 == 0){
    			out.println("Second");
    		}else{
    			out.println("First");
    		}
    	}
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