import java.io.*;
import java.util.*;

class Main{
	public void run(){
		long H = nl();
		long W = nl();
		long N = nl();
		HashMap<Long, Integer> map = new HashMap<>();
		for(long i=0;i<N;i++){
			long a = nl();
			long b = nl();
			for(long y=a-1;y<=a+1;y++){
				for(long x=b-1;x<=b+1;x++){
					if(x-1<1 || x+1>W || y-1<1 || y+1>H){
						continue;
					}
//					String key = String.format("%9d%9d", y, x);
					long key = y * 10_0000_0000L + x;
					if(map.containsKey(key)){
						map.put(key, map.get(key) + 1);
					}else{
						map.put(key, 1);
					}
				}
			}
		}
		long[] result = new long[10];

		long sum = 0;
		for(Integer i : map.values()){
			result[i]++;
			sum++;
		}
		result[0] = ((H-2) * (W-2)) - sum;

		for(int i=0;i<10;i++){
			out.println(result[i]);
		}
	}

	private static PrintWriter out;
	public static void main(String[] args){
		out = new PrintWriter(System.out);
		new Main().run();
		out.flush();
	}

	public Main(){
	}

	int ni(){
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
		return minus ? -num : num;	}

	long nl(){
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

	double nd(){
		return Double.parseDouble(next());
	}

	String next(){
		int c;
		while(!isAlNum(c = read()));
		StringBuilder build = new StringBuilder();
		build.append((char)c);
		while(isAlNum(c = read())){
			build.append((char)c);
		}
		return build.toString();
	}
	String nextLine(){
		int c;
		while(!isAlNumOrSpace(c = read()));
		StringBuilder build = new StringBuilder();
		build.append((char)c);
		while(isAlNumOrSpace(c = read())){
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
	private static boolean isAlNumOrSpace(int c){
		return isAlNum(c) || c == ' ' || c == '\t';
	}
	void debug(Object... os){
		out.println(Arrays.deepToString(os));
	}
}