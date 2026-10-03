
import java.io.*;
import java.math.*;
import java.util.*;

import static java.util.Arrays.*;

public class Main {
	private static final int mod = (int)1e9+7;

	final Random random = new Random(0);
	final IOFast io = new IOFast();

	/// MAIN CODE
	public void run() throws IOException {
//		int TEST_CASE = Integer.parseInt(new String(io.nextLine()).trim());
		int TEST_CASE = 1;
		while(TEST_CASE-- != 0) {
			int n = io.nextInt();
			int m = io.nextInt();
			int[][] lr = new int[n][2];
			for (int i = 0; i < n; i++) {
				lr[i][0] = io.nextInt();
				lr[i][1] = io.nextInt() + 1;
			}
			
			Arrays.sort(lr, (a,b)->a[1]-a[0]-(b[1]-b[0]));
			Seg1 seg = new Seg1(m);
			for (int[] s : lr) {
				seg.update(s[0], s[1], 1);
			}
			int[] ans = new int[m];
			for (int i = m, j = n - 1; i > 0; i--) {
				while (j >= 0 && lr[j][1] - lr[j][0] >= i) {
					seg.update(lr[j][0], lr[j][1], -1);
					j--;
				}
				ans[i-1] = n - 1 - j;
				for (int k = 0; k <= m; k += i) {
					ans[i-1] += seg.get(k);
				}
			}
			for (int a : ans) io.out.println(a);
		}
	}
	
	static class Seg1 {
		final int n;
		final int[] seg;
		
		public Seg1(final int n) {
			this.n = Integer.highestOneBit(n) << 1;
			seg = new int[this.n << 1];
		}

		void update(int l, int r, int v) { update(l, r, v, 0, 0, n); }
		void update(int l, int r, int v, int k, int curL, int curR) {
			if(curR <= l || curL >= r) return;
			if(l <= curL && curR <= r) { seg[k] += v; return; }
			final int curM = (curL + curR) / 2;
			update(l, r, v, 2 * k + 1, curL, curM);
			update(l, r, v, 2 * k + 2, curM, curR);
		}
		
		int get(int i) {
			i += n - 1;
			int ret = seg[i];
			while(i != 0) {
				i = (i - 1) / 2;
				ret += seg[i];
			}
			return ret;
		}
	}

	static class BIT {
		final int n;
		final int[] bit;
		final int offset = 5;

		public BIT(int size) {
			n = size;
			bit = new int[n + 1 + offset * 2];
		}
		
		public void clear() { Arrays.fill(bit, 0); }

		// [i, j)
		public int sum(int i, int j) {
			return sum(j) - sum(i);
		}

		public int sum(int i) {
			i += offset;
			int res = 0;
			for (; i > 0; i -= i & -i) {
				res += bit[i];
//				while(res >= mod) res -= mod;
			}
			return res;
		}

		// 1<=i<=n
		public void add(int i, int x) {
			i += offset;
			if(i <= 0) throw new RuntimeException();
			for (; i <= n; i += i & -i) {
				bit[i] += x;
//				while(bit[i] >= mod) bit[i] -= mod;
			}
		}
	}
	
	/// TEMPLATE
	static int gcd(int n, int r) { return r == 0 ? n : gcd(r, n%r); }
	static long gcd(long n, long r) { return r == 0 ? n : gcd(r, n%r); }
	
	static <T> void swap(T[] x, int i, int j) { T t = x[i]; x[i] = x[j]; x[j] = t; }
	static void swap(int[] x, int i, int j) { int t = x[i]; x[i] = x[j]; x[j] = t; }

	void printArrayLn(int[] xs) { for(int i = 0; i < xs.length; i++) io.out.print(xs[i] + (i==xs.length-1?"\n":" ")); }
	void printArrayLn(long[] xs) { for(int i = 0; i < xs.length; i++) io.out.print(xs[i] + (i==xs.length-1?"\n":" ")); }
	
	static void dump(Object... o) { System.err.println(Arrays.deepToString(o)); } 
	
	void main() throws IOException {
		//		IOFast.setFileIO("rle-size.in", "rle-size.out");
		try { run(); }
		catch (EndOfFileRuntimeException e) { }
		io.out.flush();
	}
	public static void main(String[] args) throws IOException { new Main().main(); }
	
	static class EndOfFileRuntimeException extends RuntimeException {
		private static final long serialVersionUID = -8565341110209207657L; }

	static
	public class IOFast {
		private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		private PrintWriter out = new PrintWriter(System.out);

		void setFileIn(String ins) throws IOException { in.close(); in = new BufferedReader(new FileReader(ins)); }
		void setFileOut(String outs) throws IOException { out.flush(); out.close(); out = new PrintWriter(new FileWriter(outs)); }
		void setFileIO(String ins, String outs) throws IOException { setFileIn(ins); setFileOut(outs); }

		private static int pos, readLen;
		private static final char[] buffer = new char[1024 * 8];
		private static char[] str = new char[500*8*2];
		private static boolean[] isDigit = new boolean[256];
		private static boolean[] isSpace = new boolean[256];
		private static boolean[] isLineSep = new boolean[256];

		static { for(int i = 0; i < 10; i++) { isDigit['0' + i] = true; } isDigit['-'] = true; isSpace[' '] = isSpace['\r'] = isSpace['\n'] = isSpace['\t'] = true; isLineSep['\r'] = isLineSep['\n'] = true; }
		public int read() throws IOException { if(pos >= readLen) { pos = 0; readLen = in.read(buffer); if(readLen <= 0) { throw new EndOfFileRuntimeException(); } } return buffer[pos++]; }
		public int nextInt() throws IOException { int len = 0; str[len++] = nextChar(); len = reads(len, isSpace); int i = 0; int ret = 0; if(str[0] == '-') { i = 1; } for(; i < len; i++) ret = ret * 10 + str[i] - '0'; if(str[0] == '-') { ret = -ret; } return ret; }
		public long nextLong() throws IOException { int len = 0; str[len++] = nextChar(); len = reads(len, isSpace); int i = 0; long ret = 0; if(str[0] == '-') { i = 1; } for(; i < len; i++) ret = ret * 10 + str[i] - '0'; if(str[0] == '-') { ret = -ret; } return ret; }
		public char nextChar() throws IOException { while(true) { final int c = read(); if(!isSpace[c]) { return (char)c; } } }
		int reads(int len, boolean[] accept) throws IOException { try { while(true) { final int c = read(); if(accept[c]) { break; } if(str.length == len) { char[] rep = new char[str.length * 3 / 2]; System.arraycopy(str, 0, rep, 0, str.length); str = rep; } str[len++] = (char)c; } } catch(EndOfFileRuntimeException e) { ; } return len; }
		int reads(char[] cs, int len, boolean[] accept) throws IOException { try { while(true) { final int c = read(); if(accept[c]) { break; } cs[len++] = (char)c; } } catch(EndOfFileRuntimeException e) { ; } return len; }
		public char[] nextLine() throws IOException { int len = 0; str[len++] = nextChar(); len = reads(len, isLineSep); try { if(str[len-1] == '\r') { len--; read(); } } catch(EndOfFileRuntimeException e) { ; } return Arrays.copyOf(str, len); }
		public String nextString() throws IOException { return new String(next()); }
		public char[] next() throws IOException { int len = 0; str[len++] = nextChar(); len = reads(len, isSpace); return Arrays.copyOf(str, len); }
//		public int next(char[] cs) throws IOException { int len = 0; cs[len++] = nextChar(); len = reads(cs, len, isSpace); return len; }
		public double nextDouble() throws IOException { return Double.parseDouble(nextString()); }
		public long[] nextLongArray(final int n) throws IOException { final long[] res = new long[n]; for(int i = 0; i < n; i++) { res[i] = nextLong(); } return res; }
		public int[] nextIntArray(final int n) throws IOException { final int[] res = new int[n]; for(int i = 0; i < n; i++) { res[i] = nextInt(); } return res; }
		public int[][] nextIntArray2D(final int n, final int k) throws IOException { final int[][] res = new int[n][]; for(int i = 0; i < n; i++) { res[i] = nextIntArray(k); } return res; }
		public int[][] nextIntArray2DWithIndex(final int n, final int k) throws IOException { final int[][] res = new int[n][k+1]; for(int i = 0; i < n; i++) { for(int j = 0; j < k; j++) { res[i][j] = nextInt(); } res[i][k] = i; } return res; }
		public double[] nextDoubleArray(final int n) throws IOException { final double[] res = new double[n]; for(int i = 0; i < n; i++) { res[i] = nextDouble(); } return res; }
	}
}
