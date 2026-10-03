import java.io.*;
import java.util.*;

public class Main {

	private static Scanner sc;
	private static Printer pr;

	private static void solve() {
		char[] s = sc.next().toCharArray();
		char[] t = sc.next().toCharArray();

		int ns = s.length;
		int nt = t.length;

		char[] st = new char[ns + 1];
		char[] tt = new char[nt + 1];
		for (int i = 0; i < ns; i++) {
			st[i + 1] = tr(st[i], s[i]);
		}
		for (int i = 0; i < nt; i++) {
			tt[i + 1] = tr(tt[i], t[i]);
		}

		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();

//			pr.printf("%c %c %c\n", st[a - 1], st[b], rtr(st[a - 1], st[b]));
//			pr.printf("%c %c %c\n", tt[c - 1], tt[d], rtr(tt[c - 1], tt[d]));

			if (rtr(st[a - 1], st[b]) == rtr(tt[c - 1], tt[d])) {
				pr.println("YES");
			} else {
				pr.println("NO");
			}
		}
	}

	private static char tr(char a, char b) {
		if (a == 'A' && b == 'A') {
			return 'B';
		} else if (a == 'A' && b == 'B') {
			return 0;
		} else if (a == 'A' && b == 0) {
			return 'A';
		} else if (a == 'B' && b == 'A') {
			return 0;
		} else if (a == 'B' && b == 'B') {
			return 'A';
		} else if (a == 'B' && b == 0) {
			return 'B';
		} else if (a == 0 && b == 'A') {
			return 'A';
		} else if (a == 0 && b == 'B') {
			return 'B';
		} else {
			return 0;
		}
	}

	private static char rtr(char a, char b) {
		if (a == 'A' && b == 'A') {
			return 0;
		} else if (a == 'A' && b == 'B') {
			return 'A';
		} else if (a == 'A' && b == 0) {
			return 'B';
		} else if (a == 'B' && b == 'A') {
			return 'B';
		} else if (a == 'B' && b == 'B') {
			return 0;
		} else if (a == 'B' && b == 0) {
			return 'A';
		} else if (a == 0 && b == 'A') {
			return 'A';
		} else if (a == 0 && b == 'B') {
			return 'B';
		} else {
			return 0;
		}
	}

	// ---------------------------------------------------
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		pr = new Printer(System.out);

		solve();

		pr.close();
		sc.close();
	}

	@SuppressWarnings("unused")
	private static class Scanner {
		BufferedReader br;

		Scanner (InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		private boolean isPrintable(int ch) {
			return ch >= '!' && ch <= '~';
		}

		private boolean isCRLF(int ch) {
			return ch == '\n' || ch == '\r' || ch == -1;
		}

		private int nextPrintable() {
			try {
				int ch;
				while (!isPrintable(ch = br.read())) {
					if (ch == -1) {
						throw new NoSuchElementException();
					}
				}

				return ch;
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		String next() {
			try {
				int ch = nextPrintable();
				StringBuilder sb = new StringBuilder();
				do {
					sb.appendCodePoint(ch);
				} while (isPrintable(ch = br.read()));

				return sb.toString();
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		int nextInt() {
			try {
				// parseInt from Integer.parseInt()
				boolean negative = false;
				int res = 0;
				int limit = -Integer.MAX_VALUE;
				int radix = 10;

				int fc = nextPrintable();
				if (fc < '0') {
					if (fc == '-') {
						negative = true;
						limit = Integer.MIN_VALUE;
					} else if (fc != '+') {
						throw new NumberFormatException();
					}
					fc = br.read();
				}
				int multmin = limit / radix;

				int ch = fc;
				do {
					int digit = ch - '0';
					if (digit < 0 || digit >= radix) {
						throw new NumberFormatException();
					}
					if (res < multmin) {
						throw new NumberFormatException();
					}
					res *= radix;
					if (res < limit + digit) {
						throw new NumberFormatException();
					}
					res -= digit;

				} while (isPrintable(ch = br.read()));

				return negative ? res : -res;
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		long nextLong() {
			try {
				// parseLong from Long.parseLong()
				boolean negative = false;
				long res = 0;
				long limit = -Long.MAX_VALUE;
				int radix = 10;

				int fc = nextPrintable();
				if (fc < '0') {
					if (fc == '-') {
						negative = true;
						limit = Long.MIN_VALUE;
					} else if (fc != '+') {
						throw new NumberFormatException();
					}
					fc = br.read();
				}
				long multmin = limit / radix;

				int ch = fc;
				do {
					int digit = ch - '0';
					if (digit < 0 || digit >= radix) {
						throw new NumberFormatException();
					}
					if (res < multmin) {
						throw new NumberFormatException();
					}
					res *= radix;
					if (res < limit + digit) {
						throw new NumberFormatException();
					}
					res -= digit;

				} while (isPrintable(ch = br.read()));

				return negative ? res : -res;
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		float nextFloat() {
			return Float.parseFloat(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			try {
				int ch;
				while (isCRLF(ch = br.read())) {
					if (ch == -1) {
						throw new NoSuchElementException();
					}
				}
				StringBuilder sb = new StringBuilder();
				do {
					sb.appendCodePoint(ch);
				} while (!isCRLF(ch = br.read()));

				return sb.toString();
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		void close() {
			try {
				br.close();
			} catch (IOException e) {
//				throw new NoSuchElementException();
			}
		}
	}

	private static class Printer extends PrintWriter {
		Printer(PrintStream out) {
			super(out);
		}
	}
}
