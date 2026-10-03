import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

public class Main {
	// test

	static FastScanner sc = new FastScanner();
	
	static int MOD = 1000000007;
	static int H, W;
	static int[][] a, dp;
	
	public static void main(String[] args) {
		H = sc.nextInt2();
		W = sc.nextInt2();
		a = new int[H + 2][W + 2];
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				a[i][j] = sc.nextInt2();
			}
		}
		
		int sum = 0;
		dp = new int[H + 2][W + 2];
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				sum += dp(i, j);
				sum %= MOD;
			}
		}
		
		System.out.println(sum);
	}
	
	static int dp(int i, int j) {
		if (dp[i][j] > 0) return dp[i][j];
		int result = 1;
		int aij = a[i][j];
		if (aij < a[i - 1][j]) result = (result + dp(i - 1, j)) % MOD;
		if (aij < a[i + 1][j]) result = (result + dp(i + 1, j)) % MOD;
		if (aij < a[i][j - 1]) result = (result + dp(i, j - 1)) % MOD;
		if (aij < a[i][j + 1]) result = (result + dp(i, j + 1)) % MOD;
		return dp[i][j] = result;
	}
}

class FastScanner {
	private final InputStream in = System.in;
	private final byte[] buffer = new byte[1024];
	private int ptr = 0;
	private int buflen = 0;
	
	private boolean hasNextByte() {
		if (ptr < buflen) {
			return true;
		} else {
			ptr = 0;
			try {
				buflen = in.read(buffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (buflen <= 0) { return false; }
		}
		return true;
	}
	
	private int readByte() {
		if (hasNextByte()) {
			return buffer[ptr++];
		} else {
			return -1;
		}
	}
	
	private static boolean isPrintableChar(int c) {
		return '!' <= c && c <= '~';
	}
	
	private void skipUnprintable() {
		while (hasNextByte() && !isPrintableChar(buffer[ptr])) {
			ptr++;
		}
	}
	
	public boolean hasNext() {
		skipUnprintable();
		return hasNextByte();
	}
	
	public String next() {
		if (!hasNext()) { throw new NoSuchElementException(); }
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while (isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	public int nextInt2() {
		return Integer.parseInt(next());
	}
	
	public int nextInt() {
		if (!hasNext()) { throw new NoSuchElementException(); }
		int n = 0;
		boolean minus = false;
		int b = readByte();
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		if (b < '0' || '9' < b) { throw new NumberFormatException(); }
		while (true) {
			if ('0' <= b && b <= '9') {
				n *= 10;
				n += b - '0';
			} else if (b == -1 || !isPrintableChar(b)) {
				return minus ? -n : n;
			} else {
				throw new NumberFormatException();
			}
			b = readByte();
		}
	}
	
}