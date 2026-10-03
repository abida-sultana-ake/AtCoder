import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static long gcd(long a, long b){
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) throws IOException {
		final Scanner sc = new Scanner(System.in);
		
		final int N = sc.nextInt();
		final long Ma = sc.nextLong();
		final long Mb = sc.nextLong();
		
		int[] as = new int[N];
		int[] bs = new int[N];
		int[] cs = new int[N];
		for(int i = 0; i < N; i++){
			final int a = sc.nextInt();
			final int b = sc.nextInt();
			final int c = sc.nextInt();
			
			as[i] = a;
			bs[i] = b;
			cs[i] = c;
		}
		
		final int max = 10 * N;
		int[][] DP = new int[max + 1][max + 1];
		int[][] nextDP = new int[max + 1][max + 1];
		for(int i = 0; i <= max; i++){
			for(int j = 0; j <= max; j++){
				DP[i][j] =-1;
			}
		}
		DP[0][0] = 0;
		
		for(int curr = 0; curr < N; curr++){
			for(int i = 0; i <= max; i++){
				for(int j = 0; j <= max; j++){
					nextDP[i][j] = DP[i][j];
				}
			}
			
			final int a = as[curr];
			final int b = bs[curr];
			final int c = cs[curr];

			for(int i = 0; i <= (max - a); i++){
				for(int j = 0; j <= (max - b); j++){
					if(DP[i][j] < 0){ continue; }
					
					final int next_a = i + a;
					final int next_b = j + b;
					final int next_money = DP[i][j] + c;
					
					if(nextDP[next_a][next_b] < 0){
						nextDP[next_a][next_b] = next_money;
					}else{
						nextDP[next_a][next_b] = Math.min(nextDP[next_a][next_b], next_money);
					}
				}
			}
			
			{
				int[][] tmp = DP;
				DP = nextDP;
				nextDP = tmp;
			}
		}
		//System.out.println(Arrays.deepToString(DP));
		
		boolean found = false;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= max; i++){
			for(int j = 0; j <= max; j++){
				if(Ma * j != Mb * i){ continue; }
				if(DP[i][j] <= 0){ continue; }
				
				found = true;
				min = Math.min(min, DP[i][j]);
			}
		}
		
		System.out.println(found ? min : "-1");
	}
	
	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;
 
		public Scanner(InputStream is) throws IOException {
			br = new BufferedReader(new InputStreamReader(is));
		}
 
		private void getLine() throws IOException {
			while (!hasNext()) {
				tok = new StringTokenizer(br.readLine());
			}
		}
 
		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}
 
		public String next() throws IOException {
			getLine();
			return tok.nextToken();
		}
 
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
 
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
		
		public int[] nextIntArray(int n) throws IOException {
			final int[] ret = new int[n];
			for(int i = 0; i < n; i++){
				ret[i] = this.nextInt();
			}
			return ret;
		}
		
		public long[] nextLongArray(int n) throws IOException {
			final long[] ret = new long[n];
			for(int i = 0; i < n; i++){
				ret[i] = this.nextLong();
			}
			return ret;
		}
 
		public void close() throws IOException {
			br.close();
		}
	}
}