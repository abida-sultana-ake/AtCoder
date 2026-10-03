
import java.io.*;
import java.util.*;

 
public class Main{
	
	long R, B, x, y;
 
	public void solve(){
		R = nextLong();
		B = nextLong();
		x = nextLong();
		y = nextLong();
		
		out.println(upperBound(0, Math.max(R, B),v ->{
			long r = R - v;
			if(r < 0) return false;
			long b = B - v;
			if(b < 0) return false;
			
			if((r / (x - 1)) + (b /(y - 1)) - v < 0) return false;
			
			return true;
		}));
	}
	
	public interface LongChecker{
		public boolean check(long v);
	}
	
	public long upperBound(long begin, long end, LongChecker check){
		long l = begin - 1;
		long r = end;
		while(r - l > 1){
			long m = (r + l) / 2;
			if(check.check(m)){
				l = m;
			}else{
				r = m;
			}
		}
		return l;
	}
	
	private static PrintWriter out;
	public static void main(String[] args){
		out = new PrintWriter(System.out);
		new Main().solve();
		out.flush();
	}
	
	
	
	public static int nextInt(){
		int num = 0;
		String str = next();
		boolean minus = false;
		int i = 0;
		if(str.charAt(0) == '-'){
			minus = true;
			i++;
		}
		int len = str.length();
		for(;i < len; i++){
			char c = str.charAt(i);
			if(!('0' <= c && c <= '9')) throw new RuntimeException();
			num = num * 10 + (c - '0');
		}
		return minus ? -num : num;
	}
	
	public static long nextLong(){
		long num = 0;
		String str = next();
		boolean minus = false;
		int i = 0;
		if(str.charAt(0) == '-'){
			minus = true;
			i++;
		}
		int len = str.length();
		for(;i < len; i++){
			char c = str.charAt(i);
			if(!('0' <= c && c <= '9')) throw new RuntimeException();
			num = num * 10l + (c - '0');
		}
		return minus ? -num : num;
	}
	public static String next(){
		int c;
		while(!isAlNum(c = read())){}
		StringBuilder build = new StringBuilder();
		build.append((char)c);
		while(isAlNum(c = read())){
			build.append((char)c);
		}
		return build.toString();
	}
	
	
	private static byte[] inputBuffer = new byte[1024];
	private static int bufferLength = 0;
	private static int bufferIndex = 0;
	private static int read(){
		if(bufferLength < 0) throw new RuntimeException();
		if(bufferIndex >= bufferLength){
			try{
				bufferLength = System.in.read(inputBuffer);
				bufferIndex = 0;
			}catch(IOException e){
				throw new RuntimeException(e);
			}
			if(bufferLength <= 0) return (bufferLength = -1);
		}
		return inputBuffer[bufferIndex++];
	}
	
	private static boolean isAlNum(int c){
		return '!' <= c && c <= '~';
	}
}