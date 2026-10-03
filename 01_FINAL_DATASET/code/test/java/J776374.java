import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Main {
	static final int INF = 2 << 28;
	static final long INF_L = 2L << 60;
	static final int  MOD = 1000000007;
	static final long MOD_L = 1000000007L;
	static final int[] vx = {1,0,-1,0};
	static final int[] vy = {0,1,0,-1};
	
	public static void main(String[] args) {	
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		String[] ans = {"Do","Re","Mi","Fa","So","La","Si"};
		char[] in = sc.next().toCharArray();
		char[] d  = "WBWBWWBWBWBW".toCharArray();
		IN:for(int i = 0; i < 7; i++) {
			for(int j = 0; j < d.length; j++) {
				if(in[j] != d[j]) {
					char[] x = new char[d.length];
					if(d[1] == 'B') {
						for(int k = 0; k < d.length-2; k++) {
							x[k] = d[k+2];
						}
						x[d.length-2] = 'W';
						x[d.length-1] = 'B';
					}
					else {
						for(int k = 0; k < d.length-1; k++) {
							x[k] = d[k+1];
						}
						x[d.length-1] = 'W';
					}
					d = x;
					continue IN;
				}
			}
			out.println(ans[i]);
			break;
		}
		out.flush();
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