import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) {
		FastScannerB sc = new FastScannerB(System.in);
		
		int N = sc.nextInt();
		
		int[] order = new int[N];
		
		for(int i = 0 ; i < N ; i++) order[i] = sc.nextInt();
		
		int swaps = 0;
		
		// first find all pairs of elements that need to be swapped
		for(int i = 0 ; i < N-1 ; i++){
			if(order[i] == i+1 && order[i+1] == i+2){
				int tmp = order[i];
				order[i] = order[i+1];
				order[i+1] = tmp;
				swaps++;
			}
		}
		
		// swap the first next if needed
		if(order[0] == 1){
			int tmp = order[0];
			order[0] = order[1];
			order[1] = tmp;
			swaps++;
		}
		
		
		// swap all the rest
		for(int i = 1 ; i < N ; i++){
			
			if(order[i] == (i+1)){
				int tmp = order[i];
				order[i] = order[i-1];
				order[i-1] = tmp;
				swaps++;
			}
			
		}
		
		System.out.println(swaps);
	}
	
}

class FastScannerB {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public FastScannerB(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
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

	public int nextInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String next() {
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

	public String nextLine() {
		int c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isLineEndChar(c));
		return res.toString();
	}

	public double nextDouble() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		double res = 0;
		while (!isSpaceChar(c) && c != '.') {
			if (c == 'e' || c == 'E')
				return res * Math.pow(10, nextInt());
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		}
		if (c == '.') {
			c = read();
			double m = 1;
			while (!isSpaceChar(c)) {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				m /= 10;
				res += (c - '0') * m;
				c = read();
			}
		}
		return res * sgn;
	}

	public long nextLong() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public boolean isLineEndChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == '\n' || c == '\r' || c == -1;
	}

	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}