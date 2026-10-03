import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {

	public static void main(String[] args) {
		IO io = new IO();
		int n = io.nextInt();
		Pair[] p = new Pair[n];
		for(int i=0;i<n;i++) {
			p[i] = new Pair(io.nextInt(), io.nextInt());
		}
		Arrays.sort(p, (p1,p2) -> Integer.compare(p1.w, p2.w));
		RangeMaximumQuery rmq = new RangeMaximumQuery(100001);
		ArrayList<Query> al = new ArrayList<>();
		for(int i=0;i<n;i++) {
			al.add(new Query(p[i].h, rmq.max(0,p[i].h) + 1));
			if (i == n - 1 || p[i+1].w > p[i].w) {
				for(Query q: al) {
					if (rmq.get(q.i) < q.a) {
						rmq.set(q.i, q.a);
					}
				}
				al.clear();
			}
		}
		System.out.println(rmq.max(0, 100002));
	}

}
class Pair {
	int w,h;

	public Pair(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}
	
}
class Query {
	int i;
	long a;

	public Query(int i,long a) {
		super();
		this.i = i;
		this.a = a;
	}
	
}
class RangeMaximumQuery {
	public static final long INF = (1L<<60);
	private int size,n = 1;
	private long[] data;
	public RangeMaximumQuery(int size) {
		this.size = size;
		while(this.n<this.size) {
			this.n*=2;
		}
		data = new long[n*2-1];
		this.init();
	}

	private void init() {
		Arrays.fill(data, 0);
	}

	public void set(int i,long x) {
		i+=n-1;
		data[i] = x;
		while(i>0) {
			i=(i-1)/2;
			data[i] = Math.max(data[i*2+1],data[i*2+2]);
		}
	}

	public long get(int i) {
		return data[i+n-1];
	}

	public long max(long begin,long end) {
		return query(begin,end,0,0,n);
	}

	private long query(long a,long b,int k,int l,int r) {
		if (r<=a || b<=l) {
			return -INF;
		}
		if (a<=l && r<=b) {
			return data[k];
		}else{
			return Math.max(query(a,b,k*2+1,l,(l+r)/2),query(a,b,k*2+2,(l+r)/2,r));
		}
	}

	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(data, n-1, size+n-1));
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
