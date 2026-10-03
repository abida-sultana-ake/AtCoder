import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

public class Main {
	private static FastScanner sc = new FastScanner();
	
	public static void main(String[] args) {
		int H = sc.nextInt();
		int W = sc.nextInt();
		
		if(H%3==0 || W%3==0) {
			System.out.println(0);
			return;
		}
		
		int min = Math.min(H, W);
		
		int[] a = {H/3, H/3+1};
		for(int i=0; i<=1; i++) {
			int s1 = a[i] * W;
			int s2;
			int s3;
			if(W%2 == 0) {
				s2 = (H - a[i]) * (W/2);
				s3 = s2;
			} else {
				s2 = (H - a[i]) * (W/2);
				s3 = (H - a[i]) * ((W/2)+1);
			}
			
			int temp = Math.max(Math.max(Math.abs(s1-s2), Math.abs(s2-s3)), Math.abs(s3-s1));
			if(temp < min) {
				min = temp;
			}
		}
		
		
		int[] b = {W/3, W/3+1};
		for(int i=0; i<=1; i++) {
			int s1 = b[i] * H;
			int s2;
			int s3;
			if(H%2 == 0) {
				s2 = (W - b[i]) * (H/2);
				s3 = s2;
			} else {
				s2 = (W - b[i]) * (H/2);
				s3 = (W - b[i]) * ((H/2)+1);
			}
			
			int temp = Math.max(Math.max(Math.abs(s1-s2), Math.abs(s2-s3)), Math.abs(s3-s1));
			if(temp < min) {
				min = temp;
			}
		}
		
		System.out.println(min);
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
