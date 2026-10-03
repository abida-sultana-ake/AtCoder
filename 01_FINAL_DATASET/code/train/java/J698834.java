import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

	int N,A,B,C;
	BigInteger a,b,n;
	BigInteger[] c;
	BigInteger MOD = new BigInteger(String.valueOf(((int)1e9 + 7)));

	public void solve() {
		N = nextInt();
		A = nextInt();
		B = nextInt();
		a = new BigInteger(String.valueOf(A));
		c = new BigInteger[N];
		n = new BigInteger(String.valueOf(N));

		for(int i = 0;i < N;i++){
			C = nextInt();
			c[i] = new BigInteger(String.valueOf(C));
		}
		Arrays.sort(c);

		//A = 1は何倍しても値が変化しない
		//A = 1なのにwhile(B > 0)を回すとB <= 1e9なので間に合わない
		if(A == 1){
			for(int i = 0;i < N;i++){
				out.println(c[i]);
			}
			return;
		}

		while(B > 0){
			BigInteger tmp = c[0].multiply(a);

			//c[0] * A >= c[N - 1]になると周期的になる
			if(tmp.compareTo(c[N - 1]) >= 0){
				break;
			}
			c[0] = tmp;

			Arrays.sort(c);
			B--;
		}

		b = new BigInteger(String.valueOf(B));
		//div = 周期の回数
		BigInteger div = b.divide(n);
		//remain = 周期からあぶれた分
		int remain = b.remainder(n).intValue();

		for(int i = 0;i < N;i++){
			if(i < remain){
				c[i] = c[i].multiply(a.modPow(div.add(BigInteger.ONE), MOD));
			}else{
				c[i] = c[i].multiply(a.modPow(div,MOD));
			}
		}

		for(int i = remain;i < N;i++){
			out.println(c[i].mod(MOD));
		}
		for(int i = 0;i < remain;i++){
			out.println(c[i].mod(MOD));
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