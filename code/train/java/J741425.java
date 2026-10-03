import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;


public class Main {
	public static void main(String[] args) throws Exception{
		FastScanner fs = new FastScanner();
		int l = fs.nextInt2();
		int x = fs.nextInt2();
		int y = fs.nextInt2();
		int s = fs.nextInt2();
		int d = fs.nextInt2();
		double result;
		if (y <= x){
			result = (double)((d - s + l) % l) /(x + y);
		} else {
			if (s > d){
				result = (double)(s - d) / (y - x);
				if ((double)(d - s + l) / (x + y) < result){
					result = (double)(d - s + l) / (x + y);
				}
			} else {
				result = (double)(l - d + s) / (y - x);
				if ((double)(d - s)/(y + x) < result){
					result = (double)(d - s)/(y + x);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(result);
		System.out.println(sb.toString());
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

