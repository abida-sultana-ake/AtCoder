import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {

	static final int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static final int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);

		int q = 8;
		boolean flag = false;
		boolean[][] board = new boolean[8][8];
		loop: for (int i = 0; i < 8; i++) {
			char[] c = sc.next().toCharArray();
			for (int j = 0; j < 8; j++) {
				if (c[j] == 'Q') {
					if (koreOkerukana(i * 8 + j, board)) {
						board[i][j] = true;
						q--;
					} else {
						flag = true;
						break loop;
					}
				}
			}
		}

		if (flag || !dfs(0, q, board)) {
			out.println("No Answer");
		} else {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j]) out.print('Q');
					else out.print('.');
				}
				out.println();
			}
		}

		out.flush();
	}

	static boolean dfs(int n, int m, boolean[][] board) {
		if (m == 0) return true;
		if (n == 64) return false;
		if (koreOkerukana(n, board)) {
			board[n / 8][n % 8] = true;
			if (dfs(n + 1, m - 1, board)) return true;
			board[n / 8][n % 8] = false;
		}
		return dfs(n + 1, m, board);
	}

	static boolean koreOkerukana(int n, boolean[][] board) {
		int x = n % 8;
		int y = n / 8;
		for (int i = 0; i < 8; i++) {
			int _x = x, _y = y;
			while (0 <= _x && _x < 8 && 0 <= _y && _y < 8) {
				if (board[_y][_x]) return false;
				_x += dx[i];
				_y += dy[i];
			}
		}
		return true;
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

	private byte readByte() {
		if (hasNextByte()) {
			return buffer[ptr++];
		} else {
			return -1;
		}
	}

	private boolean isPrintableChar(int c) {
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
		byte b = readByte();
		while (isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	public int nextInt() {
		if (!hasNext()) { throw new NoSuchElementException(); }
		int n = 0;
		boolean minus = false;
		byte b = readByte();
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

	public long nextLong() {
		if (!hasNext()) { throw new NoSuchElementException(); }
		long n = 0;
		boolean minus = false;
		byte b = readByte();
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