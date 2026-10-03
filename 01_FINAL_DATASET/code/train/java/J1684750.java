import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		long t = System.currentTimeMillis();
		new Main().run();
		System.err.println(System.currentTimeMillis() - t);
	}

	void run() {
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		int k = sc.nextInt();
		long[] x = new long[n];
		long[] y = new long[n];
		for (int i = 0; i < n; ++i) {
			x[i] = sc.nextLong();
			y[i] = sc.nextLong();
		}
		long ans = Long.MAX_VALUE;
		for (long x1 : x) {
			for (long x2 : x) {
				for (long y1 : y) {
					for (long y2 : y) {
						if (x1 >= x2 || y1 >= y2)
							continue;
						int cnt = 0;
						for (int i = 0; i < n; ++i) {
							if (x1 <= x[i] && x[i] <= x2 && y1 <= y[i] && y[i] <= y2) {
								++cnt;
							}
						}
						if (cnt >= k) {
							ans = Math.min(ans, (x2 - x1) * (y2 - y1));
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

  class Scanner {
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
				if (buflen <= 0) {
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

		private boolean isPrintableChar(int c) {
			return 33 <= c && c <= 126;
		}

		private void skipUnprintable() {
			while (hasNextByte() && !isPrintableChar(buffer[ptr]))
				ptr++;
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
	}

	static void tr(Object... objects) {
		System.out.println(Arrays.deepToString(objects));
	}

}
