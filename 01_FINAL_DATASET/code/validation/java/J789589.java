
import java.io.*;
import java.util.*;

public class Main {
	
	int N;
	int M;
	int[][] comp;
	long[] memo;
	public void solve(){
		N = nextInt();
		M = nextInt();
		comp = new int[N][N];
		for(int i = 0; i < M; i++){
			int x = nextInt() - 1;
			int y = nextInt() - 1;
			comp[x][y] = -1;
			comp[y][x] = 1;
		}
		int mask = 1;
		for(int i = 1; i < N; i++){
			mask = (mask << 1) + 1;
		}
		memo = new long[mask + 1];
		Arrays.fill(memo, -1);
		out.println(recur(mask));
	}
	
	public long recur(int bit){
		if(bit == 0){
			return 1;
		}
		if(memo[bit] != -1){
			return memo[bit];
		}
		long ans = 0;
		for(int i = 0; i < N; i++){
			if(get(bit, i)){
				boolean flg = true;
				for(int j = 0; j < N; j++){
					if(get(bit, j) && comp[i][j] > 0){
						flg = false;
						break;
					}
				}
				if(flg){
					ans += recur(unset(bit, i));
				}
			}
		}
		return memo[bit] = ans;
		/*
		
		int idx = 0;
		while(idx < N && !get(bit, idx)){
			idx ++;
		}
		
		int fast = 0;
		int slow = 0;
		ArrayList<Integer> sameIdx = new ArrayList<>();
		int cnt = 0;
		for(int i = 0; i < N; i++){
			if(idx == i) continue;
			if(get(bit, i)){
				if(comp[i][idx] == -1){
					fast = set(fast, i);
				}else if(comp[idx][i] == -1){
					slow = set(slow, i);
				}else{
					sameIdx.add(i);
					cnt++;
				}
			}
		}
		long ans = 0;
		if(cnt == 0){
			ans = (recur(fast) * recur(slow));
		}else{
			int max = 1 << cnt;
			for(int i = 0; i < max; i++){
				int ff = 0;
				int ss = 0;
				for(int j = 0; j < cnt; j++){
					if(get(i, j)){
						ff = set(ff, sameIdx.get(j));
					}else{
						ss = set(ss, sameIdx.get(j));
					}
				}
				
				ans = (ans + recur(ff | fast) * recur(ss | slow));
			}
		}
		return ans;
		*/
	}
	
	public boolean get(int bit, int idx){
		return (bit & (1 << idx)) != 0;
	}
	
	public int set(int bit, int idx){
		return bit | (1 << idx);
	}
	
	public int unset(int bit, int idx){
		return bit & ~(1 << idx);
	}
	
	private static PrintWriter out;

	public static void main(String[] args) {
		out = new PrintWriter(System.out);
		new Main().solve();
		out.flush();
	}

	public static int nextInt() {
		int num = 0;
		String str = next();
		boolean minus = false;
		int i = 0;
		if (str.charAt(0) == '-') {
			minus = true;
			i++;
		}
		int len = str.length();
		for (; i < len; i++) {
			char c = str.charAt(i);
			if (!('0' <= c && c <= '9'))
				throw new RuntimeException();
			num = num * 10 + (c - '0');
		}
		return minus ? -num : num;
	}

	public static long nextLong() {
		long num = 0;
		String str = next();
		boolean minus = false;
		int i = 0;
		if (str.charAt(0) == '-') {
			minus = true;
			i++;
		}
		int len = str.length();
		for (; i < len; i++) {
			char c = str.charAt(i);
			if (!('0' <= c && c <= '9'))
				throw new RuntimeException();
			num = num * 10l + (c - '0');
		}
		return minus ? -num : num;
	}

	public static String next() {
		int c;
		while (!isAlNum(c = read())) {
		}
		StringBuilder build = new StringBuilder();
		build.append((char) c);
		while (isAlNum(c = read())) {
			build.append((char) c);
		}
		return build.toString();
	}

	private static byte[] inputBuffer = new byte[1024];
	private static int bufferLength = 0;
	private static int bufferIndex = 0;

	private static int read() {
		if (bufferLength < 0)
			throw new RuntimeException();
		if (bufferIndex >= bufferLength) {
			try {
				bufferLength = System.in.read(inputBuffer);
				bufferIndex = 0;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			if (bufferLength <= 0)
				return (bufferLength = -1);
		}
		return inputBuffer[bufferIndex++];
	}

	private static boolean isAlNum(int c) {
		return '!' <= c && c <= '~';
	}
}