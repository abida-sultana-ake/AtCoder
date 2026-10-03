import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
	int H,W,A,B;
	int MOD = (int)1e9 + 7;
	long[] nCk,modInv;

	public long modpow(long x,long y){
		if(y == 0)return 1;
		else if(y == 1)return x;
		else if(y % 2 == 0){
			long z = modpow(x,y / 2) % MOD;
			return z * z % MOD;
		}else{
			return modpow(x,y - 1) * x % MOD;
		}
	}

	public void solve() {
		H = nextInt();
		W = nextInt();
		A = nextInt();
		B = nextInt();


		nCk = new long[H + W];
		modInv = new long[H + W];
		nCk[0] = 1;
		modInv[0] = 1;

		for(int i = 1;i < H + W;i++){
			nCk[i] = nCk[i - 1] * i % MOD;
			modInv[i] = modpow(nCk[i],MOD - 2) % MOD;
		}


		long ans = 0;
		for(int i = 0;i < H - A;i++){

			int n1 = B - 1 + i;
			int k1 = i;

			long comb1 = nCk[n1] * modInv[k1] % MOD * modInv[n1 - k1] % MOD;

			int n2 = W - B - 1 + H - 1 - i;
			int k2 = W - B - 1;

			long comb2 = nCk[n2] * modInv[k2] % MOD * modInv[n2 - k2] % MOD;

			ans += comb1 * comb2 % MOD;
			ans %= MOD;

		}
		out.println(ans);
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