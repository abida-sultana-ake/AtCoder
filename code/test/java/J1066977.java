
import java.io.*;
import java.util.*;
 
public class Main{
	
 
	int N, A, B, C, D;
	long mod = 1000000007;
	
	long[][] ncr = new long[1001][1001];
	long[][] ncr2 = new long[1001][1001];
	long[] fact = new long[1001];
	long[][] dp = new long[1001][1001];
	
	long pow(long a, long b){
        long ans = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                ans = mod(ans * a);
            }
            b >>= 1;
            a = mod(a * a);
        }
        return ans;
	}
	
	long rev(long a){
        return pow(a, mod - 2);	
	}
	
	long div(long a, long b){
		return mod(a * rev(b));
	}
	
	long c2(int num, int size){
		if(ncr2[num][size] != -1) return ncr2[num][size];
		long ans = 1;
		int nn = num;
		while(nn > 0){
			ans = mod(ans * ncr(nn, size));
			nn -= size;
		}
		return ncr2[num][size] = div(ans, fact[num / size]);
	}
	
	long ncr(int n, int r){
		if(ncr[n][r] != -1) return ncr[n][r];
		if(n == 1) return 1;
		if(r == 0 || r == n) return 1;
		return ncr[n][r] = mod(ncr(n - 1, r) + ncr(n - 1, r - 1));
	}
	
	long mod(long val){
		return val % mod;
	}
	
	long dfs(int num, int size){
		if(num == 0) return 1;
		if(size > B) return 0;
		if(dp[num][size] != -1) return dp[num][size];
		long ans = dfs(num, size + 1);
		for(int i = C; i <= D; i++){
			if(size * i <= num){
				ans = mod(ans + mod(mod(dfs(num - size * i, size + 1) * ncr(num, size * i)) * c2(size * i, size)));;
			}else{
				break;
			}
		}
		return dp[num][size] = ans;
	}
	
	public void solve(){
		N = nextInt();
		A = nextInt();
		B = nextInt();
		C = nextInt();
		D = nextInt();
		
		fact[0] = 1;
		for(int i = 1; i < fact.length; i++){
			fact[i] = mod(fact[i - 1] * i);
		}
		
		for(int i = 0; i < ncr.length; i++){
			for(int j = 0; j < ncr.length; j++){
				ncr[i][j] = -1;
				ncr2[i][j] = -1;
				dp[i][j] = -1;
			}
		}
		
		out.println(dfs(N, A));
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