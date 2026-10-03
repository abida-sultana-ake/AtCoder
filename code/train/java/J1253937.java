import java.io.IOException;
import java.io.InputStream;
import java.util.*;
 
public class Main{
	public static void main(String[] args){
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		long W = sc.nextLong();
		long wMin = sc.nextLong();
		if(wMin > W){
			System.out.println("0");
			return;
		}
		
		ArrayList<Integer> w0 = new ArrayList<Integer>();
		ArrayList<Integer> w1 = new ArrayList<Integer>();
		ArrayList<Integer> w2 = new ArrayList<Integer>();
		ArrayList<Integer> w3 = new ArrayList<Integer>();
		w0.add(sc.nextInt());
		for(int i=1; i<N; i++){
			switch((int)(sc.nextLong()-wMin)){
			case 0:
				w0.add(sc.nextInt());
				break;
			case 1:
				w1.add(sc.nextInt());
				break;
			case 2:
				w2.add(sc.nextInt());
				break;
			case 3:
				w3.add(sc.nextInt());
				break;
			}
		}
		Collections.sort(w0,Comparator.reverseOrder());
		Collections.sort(w1,Comparator.reverseOrder());
		Collections.sort(w2,Comparator.reverseOrder());
		Collections.sort(w3,Comparator.reverseOrder());
		long ans=0;
		long temp=0;
		
		for(int a=0; a<=w0.size(); a++){
			for(int b=0; b<=w1.size(); b++){
				for(int c=0; c<=w2.size(); c++){
					for(int d=0; d<=w3.size(); d++){
						temp = 0;
						if((a+b+c+d)*wMin+b+2*c+3*d <= W){
							if(a!=0){
								for(int i=0; i<a; i++){
									temp += w0.get(i);
								}
							}
							if(b!=0){
								for(int i=0; i<b; i++){
									temp += w1.get(i);
								}
							}
							if(c!=0){
								for(int i=0; i<c; i++){
									temp += w2.get(i);
								}
							}
							if(d!=0){
								for(int i=0; i<d; i++){
									temp += w3.get(i);
								}
							}
							ans = Math.max(ans, temp);
						}
					}
				}
			}
		}
		
		System.out.println(ans);
		return;
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
    public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
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
        long nl = nextLong();
        if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
        return (int) nl;
    }
    public double nextDouble() { return Double.parseDouble(next());}
}