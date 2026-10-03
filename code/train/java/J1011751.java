
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
public class Main {
	static final long C =  1000000007;
	static final int CY = 1000000000;
	static final int INF = Integer.MAX_VALUE/2;
	StringBuilder sb;
	//セット
	class Set<F,S> {
		F f;
		S s;
		Set(F f, S s) {this.f = f;this.s = s;}
	}
	char[][] c;
	int H;
	int W;
	public void calc() {
		sb = new StringBuilder();



		IO sc = new IO();
		int xs = sc.nextInt();
		int ys = sc.nextInt();
		int xt = sc.nextInt();
		int yt = sc.nextInt();
		int n = sc.nextInt();
		int[][] data = new int[n+2][3];
		data[0][0] = xs;
		data[0][1] = ys;
		data[0][2] = 0;
		data[1][0] = xt;
		data[1][1] = yt;
		data[1][2] = 0;
		for (int i=0; i < n; i++) {
			data[i+2][0] = sc.nextInt();
			data[i+2][1] = sc.nextInt();
			data[i+2][2] = sc.nextInt();
		}

		double ans = dijkstra(0, data)[1];




		System.out.println(ans);

	}
	//ダイクストラ法
	//始点・Fがコスト、Sが行き先の辺のリスト配列
	double[] dijkstra(int r, int[][] edges) {
		double[] ret = new double[edges.length];
		//boolean[] used = new boolean[v];//使ったかどうか

		Arrays.fill(ret, Double.POSITIVE_INFINITY);
		boolean[] used = new boolean[edges.length];
		ret[r] = 0;
		while (true) {
			int nv = -1;
			for (int i=0; i < edges.length; i++) {
				if (!used[i]  && (nv == -1 || ret[i] < ret[nv])) {
					nv = i;
				}
			}
			if (nv == -1)break;
			used[nv] = true;
			//System.err.println("nv"+nv);
			//used[nv] = true;
			for (int i=0 ; i < edges.length; i++) {
				double len = Math.max(0.0,Math.hypot(edges[nv][0] - edges[i][0]
						,edges[nv][1] - edges[i][1] ) - edges[nv][2] - edges[i][2]);
				ret[i] = Math.min(ret[i], ret[nv] + len);
			}
		}
		return ret;
	}
	public static void main(String[] args) {
		Main main = new Main();
		main.calc();

	}
}
class IO extends PrintWriter {
	private final InputStream in;
	private final byte[] buffer = new byte[1024];
	private int ptr = 0;
	private int buflen = 0;

	public IO() { this(System.in);}
	public IO(InputStream source) { super(System.out); this.in = source;}
	private boolean hasNextByte() {
		if (ptr < buflen) {
			return true;
		}else{
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
	private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
	private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
	private static boolean isNewLine(int c) { return c == '\n' || c == '\r';}
	public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
	public boolean hasNextLine() { while(hasNextByte() && isNewLine(buffer[ptr])) ptr++; return hasNextByte();}
	public String next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while(isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	public char[] nextCharArray(int len) {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		char[] s = new char[len];
		int i = 0;
		int b = readByte();
		while(isPrintableChar(b)) {
			if (i == len) {
				throw new InputMismatchException();
			}
			s[i++] = (char) b;
			b = readByte();
		}
		return s;
	}
	public String nextLine() {
		if (!hasNextLine()) {
			throw new NoSuchElementException();
		}
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while(!isNewLine(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	public long nextLong() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
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
		while(true){
			if ('0' <= b && b <= '9') {
				n *= 10;
				n += b - '0';
			}else if(b == -1 || !isPrintableChar(b)){
				return minus ? -n : n;
			}else{
				throw new NumberFormatException();
			}
			b = readByte();
		}
	}
	public int nextInt() {
		long nl = nextLong();
		if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) {
			throw new NumberFormatException();
		}
		return (int) nl;
	}
	public char nextChar() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return (char) readByte();
	}
	public double nextDouble() { return Double.parseDouble(next());}
	public int[] nextIntArray(int n) { int[] a = new int[n]; for(int i=0;i<n;i++) a[i] = nextInt(); return a;}
	public long[] nextLongArray(int n) { long[] a = new long[n]; for(int i=0;i<n;i++) a[i] = nextLong(); return a;}
	public double[] nextDoubleArray(int n) { double[] a = new double[n]; for(int i=0;i<n;i++) a[i] = nextDouble(); return a;}
	public void nextIntArrays(int[]... a) { for(int i=0;i<a[0].length;i++) for(int j=0;j<a.length;j++) a[j][i] = nextInt();}
	public int[][] nextIntMatrix(int n,int m) { int[][] a = new int[n][]; for(int i=0;i<n;i++) a[i] = nextIntArray(m); return a;}
	public char[][] nextCharMap(int n,int m) { char[][] a = new char[n][]; for(int i=0;i<n;i++) a[i] = nextCharArray(m); return a;}
	public void close() { super.close(); try {in.close();} catch (IOException e) {}}
}

