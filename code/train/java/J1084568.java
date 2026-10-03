import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	InputStream is;

	int __t__ = 1;
	int __f__ = 0;
	
	int __STACKSIZE_CHANGE_FLAG__ = __f__;
	int __FILE_DEBUG_FLAG__ = __f__;
	String __DEBUG_FILE_NAME__ = "src/C2";

	FastScanner in;
	PrintWriter out;
	
	class BIT {
		int bitA;
		int[] bit;
		
		public BIT(int maxa) { 
			bitA = maxa;
			bit = new int[bitA + 1];
		}
		
		public void update(int a, int val) {
			if (a == 0) {
				System.err.println("Caution : \"a\" in bitUpdate function is 0. It causes infinite loop");
				System.exit(1);
			}
			for (int i = a; i <= bitA; i += i & (-i)) {
				bit[i] += val;
			}
		}
		
		public int calc(int max, int min) {
			return calc(max) - calc(min - 1);
		}
		
		public int calc(int a) {
			int res = 0;
			for (int i = a; i > 0; i &= i - 1) {
				res += bit[i];
			}
			return res;
		}
		
		void debug() {
			for (int i = 1; i <= bitA; i++) {
				System.out.print(calc(i) + " ");
			}
			System.out.println();
		}
	}

	class State implements Comparable<State> {
		int range;
		int l;
		int r;

		State(int range, int l, int r) {
			this.range = range;
			this.l = l;
			this.r = r;
		}

		public int compareTo(State s) {
			return range - s.range;
		}

		public String toString() {
			return "(" + range + ", " + l + ", " + r + ")";
		}
	}
	
	public void solve() {
		int N = in.nextInt();
		int M = in.nextInt();
		int[] l = new int[N];
		int[] r = new int[N];
		State[] s = new State[N];
		for (int i = 0; i < N; i++) {
			l[i] = in.nextInt();
			r[i] = in.nextInt();
			s[i] = new State(r[i] - l[i] + 1, l[i], r[i]);
		}
		
		Arrays.sort(s);
		BIT bit = new BIT(M+10);
		for (int d = 1, i = 0; d <= M; d++) {
			while (i < N && s[i].range < d) {
				bit.update(s[i].l, 1);
				bit.update(s[i].r + 1, -1);
				i++;
			}
			int res = N - i;
			for (int j = 0; j <= M; j += d) {
				res += bit.calc(j);
			}
			out.println(res);
		}
		
		out.close();
	}
	
	public void run() {
		if (__FILE_DEBUG_FLAG__ == __t__) {
			try {
				is = new FileInputStream(__DEBUG_FILE_NAME__);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("FILE_INPUT!");
		} else {
			is = System.in;
		}
		in = new FastScanner(is);
		out = new PrintWriter(System.out);
		if (__STACKSIZE_CHANGE_FLAG__ == __t__)
			new Thread(null, new Runnable() {
				@Override
				public void run() {
					solve();
				}
			}, "main", 1 << 30).start();
		else
			solve();
	}

	public static void main(String[] args) {
		new Main().run();
	}

	public void mapDebug(long[][] a) {
		System.out.println("--------map display---------");

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%3d ", a[i][j]);
			}
			System.out.println();
		}

		System.out.println("----------------------------");
		System.out.println();
	}

	public void debug(Object... obj) {
		System.out.println(Arrays.deepToString(obj));
	}

	class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
			// stream = new FileInputStream(new File("dec.in"));

		}

		int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] nextIntArray(int n) {
			int[] array = new int[n];
			for (int i = 0; i < n; i++)
				array[i] = nextInt();

			return array;
		}

		int[][] nextIntMap(int n, int m) {
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextIntArray(m);
			}
			return map;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		long[] nextLongArray(int n) {
			long[] array = new long[n];
			for (int i = 0; i < n; i++)
				array[i] = nextLong();

			return array;
		}

		long[][] nextLongMap(int n, int m) {
			long[][] map = new long[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextLongArray(m);
			}
			return map;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		double[] nextDoubleArray(int n) {
			double[] array = new double[n];
			for (int i = 0; i < n; i++)
				array[i] = nextDouble();

			return array;
		}

		double[][] nextDoubleMap(int n, int m) {
			double[][] map = new double[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextDoubleArray(m);
			}
			return map;
		}

		String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		String[] nextStringArray(int n) {
			String[] array = new String[n];
			for (int i = 0; i < n; i++)
				array[i] = next();

			return array;
		}

		String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}
}
