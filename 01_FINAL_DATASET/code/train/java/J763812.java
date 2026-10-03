import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

public class Main {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int H = sc.nextInt();
		int W = sc.nextInt();
		char[][] map = new char[H + 2][W + 2];
		char[][] org = new char[H + 2][W + 2];
		for (int i = 1; i <= H; i++) {
			String s = sc.next();
			for (int j = 1; j <= W; j++) {
				map[i][j] = s.charAt(j - 1);
				org[i][j] = s.charAt(j - 1);
			}
		}

		int[][] d = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { -1, 0 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				if (map[i][j] == '.') {
					for (int[] v : d) {
						if (map[i + v[0]][j + v[1]] == '#')
							map[i + v[0]][j + v[1]] = '@';
					}
				}
			}
		}
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				if (map[i][j] == '@') {
					map[i][j] = '.';
				}
			}
		}

		char[][] newMap = new char[H + 2][W + 2];
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				boolean flg = false;
				for (int[] v : d) {
					flg = flg || map[i + v[0]][j + v[1]] == '#';
				}
				if (flg) {
					newMap[i][j] = '#';
				} else {
					newMap[i][j] = '.';
				}
			}
		}

		boolean ok = true;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				if (org[i][j] != newMap[i][j]) {
					ok = false;
					break;
				}
			}
		}

		System.out.println(ok ? "possible" : "impossible");
		if (ok) {
			for (int i = 1; i <= H; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 1; j <= W; j++) {
					sb.append(map[i][j]);
				}
				System.out.println(sb);
			}
		}
	}
}

class FastScanner {
	public static String debug = null;

	private final InputStream in = System.in;
	private int ptr = 0;
	private int buflen = 0;
	private byte[] buffer = new byte[1024];
	private boolean eos = false;

	private boolean hasNextByte() {
		if (ptr < buflen) {
			return true;
		} else {
			ptr = 0;
			try {
				if (debug != null) {
					buflen = debug.length();
					buffer = debug.getBytes();
					debug = "";
					eos = true;
				} else {
					buflen = in.read(buffer);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (buflen < 0) {
				eos = true;
				return false;
			} else if (buflen == 0) {
				return false;
			}
		}
		return true;
	}

	private int readByte() {
		if (hasNextByte())
			return buffer[ptr++];
		else
			return -1;
	}

	private static boolean isPrintableChar(int c) {
		return 33 <= c && c <= 126;
	}

	private void skipUnprintable() {
		while (hasNextByte() && !isPrintableChar(buffer[ptr]))
			ptr++;
	}

	public boolean isEOS() {
		return this.eos;
	}

	public boolean hasNext() {
		skipUnprintable();
		return hasNextByte();
	}

	public String next() {
		if (!hasNext())
			throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while (isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	public long nextLong() {
		if (!hasNext())
			throw new NoSuchElementException();
		long n = 0;
		boolean minus = false;
		int b = readByte();
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		if (b < '0' || '9' < b) {
			throw new NumberFormatException();
		}
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

	public int nextInt() {
		return (int) nextLong();
	}

	public long[] nextLongList(int n) {
		return nextLongTable(1, n)[0];
	}

	public int[] nextIntList(int n) {
		return nextIntTable(1, n)[0];
	}

	public long[][] nextLongTable(int n, int m) {
		long[][] ret = new long[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ret[i][j] = nextLong();
			}
		}
		return ret;
	}

	public int[][] nextIntTable(int n, int m) {
		int[][] ret = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ret[i][j] = nextInt();
			}
		}
		return ret;
	}
}