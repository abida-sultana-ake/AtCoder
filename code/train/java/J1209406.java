import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {

	public static long MOD = 1000000007;
	public static void main(String[] args) {
		IO io = new IO();
		int n = io.nextInt();
		int m = io.nextInt();
		int[] x2 = io.nextIntArray(n);
		int[] y2 = io.nextIntArray(m);
		Arrays.sort(x2);
		Arrays.sort(y2);
		n--;
		m--;
		int[] x = new int[n];
		int[] y = new int[m];
		for(int i=0;i<n;i++) {
			x[i] = x2[i+1] - x2[i];
		}
		for(int i=0;i<m;i++) {
			y[i] = y2[i+1] - y2[i]; 
		}
		long xsum = 0;
		for(int i=0;i<n;i++) {
			long w = (long) (i + 1) * (n - i) % MOD;
			xsum += x[i] * w % MOD;
			if (xsum >= MOD) {
				xsum -= MOD;
			}
		}
		long ysum = 0;
		for(int i=0;i<m;i++) {
			long w = (long) (i + 1) * (m - i) % MOD;
			ysum += y[i] * w % MOD;
			if (ysum >= MOD) {
				ysum -= MOD;
			}
		}
		System.out.println(xsum * ysum % MOD);
	}
	
	public static void test() {
		int n = 5;
		int m = 7;
		int[][] count = new int[n][m];
		for(int i1=0;i1<n;i1++) {
			for(int i2=i1;i2<n;i2++) {
				for(int j1=0;j1<m;j1++) {
					for(int j2=j1;j2<m;j2++) {
						for(int i=i1;i<=i2;i++) {
							for(int j=j1;j<=j2;j++) {
								count[i][j]++;
							}
						}
					}
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(count[i]));
		}
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

