import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Main {
	static final int INF = 2 << 28;
	static final long INF_L = 2L << 60;
	static final int  MOD = 1000000007;
	static final long MOD_L = 1000000007L;
	static final int[] vx_4 = {1,0,-1,0};
	static final int[] vy_4 = {0,1,0,-1};
	static final int[] vx_5 = {1,0,-1,0,0};
	static final int[] vy_5 = {0,1,0,-1,0};
	static final int[] vx_8 = {1,1,1,0,0,-1,-1,-1};
	static final int[] vy_8 = {1,0,-1,1,-1,1,0,-1};
	static final int[] vx_9 = {1,1,1,0,0,0,-1,-1,-1};
	static final int[] vy_9 = {1,0,-1,1,0,-1,1,0,-1};
	
	public static void main(String[] args) {	
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int N = sc.nextInt();
		int[] w = new int[N];
		int[] h = new int[N];
		Data[] data = new Data[N];
		for(int i = 0; i < N; i++) {
			w[i] = sc.nextInt();
			h[i] = sc.nextInt();
			data[i] = new Data(w[i],h[i]);
		}
		Arrays.sort(data);
		SegmentTree st1 = new SegmentTree(100001);
		for(int i = 0; i < N; i++) {
			int w1 = data[i].w;
			int h1 = data[i].h;
			st1.add(h1, Math.max(st1.get(0, h1)+1,1));
		}
		System.out.println(st1.get(0, 100001));
		
		
	}
	static class Data implements Comparable<Data>{
		int w;
		int h;
		Data(int a, int b) {
			w = a;
			h = b;
		}
		@Override
		public int compareTo(Data o) {
			if(this.w == o.w) return o.h - this.h;
			return this.w - o.w;
		}
		
	}
	
	static class SegmentTree {
		int n;
		int[] data;
		public SegmentTree(int size) {
			n = 1;
			while (n < size) {
				n <<= 1;
			}
			data = new int[n << 1];
			java.util.Arrays.fill(data, Integer.MIN_VALUE);
		}

		public int size() {
			return n;
		} 
		public int get(int i, int j) {
			return get(i, j, 0, 0, n);
		}
		int get(int i, int j, int k, int l, int r) {
			if (r <= i || j <= l) return Integer.MIN_VALUE;
			if (i <= l && r <= j) return data[k];
			else {
				int vl = get(i, j, (k << 1) + 1, l, (l + r) / 2);
				int vr = get(i, j, (k << 1) + 2, (l + r) / 2, r);
				return Math.max(vl, vr);
			}
		}

		public void add(int i, int v) {
			i += n - 1;
			data[i] = Math.max(data[i], v);
			while (i > 0) {
				i = (i - 1) / 2;
				data[i] = Math.max(data[(i << 1) + 1], data[(i << 1) + 2]);
			}
		}
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
    private void skipUnprintable() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;}
    public boolean hasNext() { skipUnprintable(); return hasNextByte();}
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while(isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    public long nextLong() {
        if (!hasNext()) throw new NoSuchElementException();
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
    	if (!hasNext()) throw new NoSuchElementException();
        int n = 0;
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
}