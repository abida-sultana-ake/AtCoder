import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	public static class Prize implements Comparable<Prize> {
		long weight;
		long prize;
		
		public Prize(long weight, long prize){
			this.weight = weight;
			this.prize = prize;
		}
		
		public int compareTo(Prize arg0){
			return Long.compare(arg0.prize, this.prize);
		}
		
		public String toString(){
			return this.weight + " " + this.prize;
		}
	}
	
	public static long dfs(int deep, int limit, Prize[][] prizes, long W, long curr_weight, long curr_prize){
		if(deep >= limit){
			//System.out.println(curr_weight + " " + curr_prize);
			
			if(curr_weight > W){ 
				return 0;
			}else{
				return curr_prize;
			}
		}else{
			long max_ret = dfs(deep + 1, limit, prizes, W, curr_weight, curr_prize);
			
			long weight = 0, prize = 0;
			for(int i = 0; i < prizes[deep].length; i++){
				weight += prizes[deep][i].weight;
				prize += prizes[deep][i].prize;
				
				final long next_weight = curr_weight + weight;
				if(next_weight > W){ break; }
				
				max_ret = Math.max(max_ret, dfs(deep + 1, limit, prizes, W, next_weight, prize + curr_prize));
			}
			
			return max_ret;
		}
	}
	
	public static void main(String[] args) throws IOException {
		try(Scanner sc = new Scanner(System.in)){
			final int N = sc.nextInt();
			final long W = sc.nextLong();
			
			long[] ws = new long[N];
			int[] vs = new int[N];
			
			int[] counts = new int[4];
			ws[0] = sc.nextLong();
			vs[0] = sc.nextInt();
			counts[0]++;
			
			for(int i = 1; i < N; i++){
				ws[i] = sc.nextLong();
				vs[i] = sc.nextInt();
				
				counts[(int)(ws[i] - ws[0])]++;
			}
			
			Prize[][] prizes = new Prize[4][];
			
			for(int i = 0; i < 4; i++){
				prizes[i] = new Prize[counts[i]];
				
				int count = 0;
				for(int j = 0; j < N; j++){
					if(ws[j] != ws[0] + i){ continue; }
					
					prizes[i][count++] = new Prize(ws[j], vs[j]);
				}
				
				Arrays.sort(prizes[i]);
			}
			
			//System.out.println(Arrays.deepToString(prizes));
			
			System.out.println(dfs(0, 4, prizes, W, 0, 0));
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