import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Main {
	private static FastScanner sc = new FastScanner();

	public static void main(String[] args) {
		int n = sc.nextInt();
		
		int[] a = new int[3*n];
		for(int i=0; i<3*n; i++) {
			a[i] = sc.nextInt();
		}
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		
		long sum = 0;
		for(int i=0; i<n; i++) {
			que.add(a[i]);
			sum += a[i];
		}
		
		long[] r = new long[3*n];
		r[n] = sum;
		for(int i=n; i<2*n; i++) {
			que.add(a[i]);
			sum += a[i] - que.poll();
			r[i+1] = sum;
		}
		
		que = new PriorityQueue<>((x,y) -> y-x);
		
		sum = 0;
		for(int i=3*n-1; i>=2*n; i--) {
			que.add(a[i]);
			sum += a[i];
		}
		
		long[] b = new long[3*n];
		b[2*n] = sum;
		for(int i=2*n-1; i>=n; i--) {
			que.add(a[i]);
			sum += a[i] - que.poll();
			b[i] = sum;
		}
		
		long max = Long.MIN_VALUE;
		for(int i=n; i<=2*n; i++) {
			if(r[i] - b[i] > max) {
				max = r[i] - b[i];
			}
		}
		
		System.out.println(max);
	}

	static class FastScanner {
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
	        return Long.parseLong(next());
	    }
	    public int nextInt(){
	    	return Integer.parseInt(next());
	    }
	}
}
