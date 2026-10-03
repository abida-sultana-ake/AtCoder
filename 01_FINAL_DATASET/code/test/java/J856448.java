import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
	
	public static long f(long b, long n){
		if(n < b){
			return n;
		}else{
			return (n % b) + f(b, n / b);
		}
	}
	
	public static void main(String[] args) throws IOException {
		final Scanner sc = new Scanner(System.in);
		
		final int N = sc.nextInt();
		long[] xs = new long[N];
		for(int i = 0; i < N; i++){
			xs[i] = sc.nextLong();
		}
		
		final int LOG = Integer.numberOfTrailingZeros(Integer.highestOneBit(N)) + 1;
		final long L = sc.nextLong();
		
		int[][] days = new int[LOG + 1][N];
		{
			for(int start = 0; start < N; start++){
				int lower_end = start, upper_end = N;
				
				while(lower_end + 1 < upper_end){
					final int middle_end = (lower_end + upper_end) / 2;
					final long diff = xs[middle_end] - xs[start];
					
					if(diff <= L){
						lower_end = middle_end;
					}else{
						upper_end = middle_end;
					}
				}
				
				/*
				for(int i = start; i < N; i++){
					System.out.println(start + " -> " + i + " : "  + (xs[i] - xs[start]) + " : " + L + " : " + lower_end);
				}
				*/
				
				days[0][start] = lower_end;
			}
			
			
			//System.out.println(0 + " " + Arrays.toString(days[0]));
			for(int depth = 1; depth <= LOG; depth++){
				for(int start = 0; start < N; start++){
					days[depth][start] = days[depth - 1][days[depth - 1][start]];
				}
				//System.out.println(depth + " " + Arrays.toString(days[depth]));
			}
			
		}
		
		
		final int Q = sc.nextInt();
		
		for(int q = 0; q < Q; q++){	
			final int a = sc.nextInt() - 1;
			final int b = sc.nextInt() - 1;
			
			final int min = Math.min(a, b);
			final int max = Math.max(a, b);
			
			int min_day = 0, max_day = N;
			
			LOOP:
			while(min_day + 1 < max_day){
				final int middle_day = (min_day + max_day) / 2;
				
				for(int rest_day = middle_day, cnt = 0, curr_pos = min; rest_day > 0; rest_day /= 2, cnt++){
					if(rest_day % 2 == 1){
						curr_pos = days[cnt][curr_pos];
					}
					
					//System.out.println(q + " " + a + " " + b + " " + middle_day + " " + cnt + " " + curr_pos);
					
					if(curr_pos >= max){
						max_day = middle_day;
						continue LOOP;
					}
				}
				
				min_day = middle_day;
			}
			
			System.out.println(max_day);
		}
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
 
		public void close() throws IOException {
			br.close();
		}
	}
}