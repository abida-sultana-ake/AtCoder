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
	
	public static void main(String[] args) throws IOException {
		final Scanner sc = new Scanner(System.in);
		
		final int N = sc.nextInt();
		char[] same = sc.next().toCharArray();
		
		boolean[] tf = new boolean[N];
		for(int fst = 0; fst <= 1; fst++){
			LOOP:
			for(int lst = 0; lst <= 1; lst++){
				Arrays.fill(tf, false);
				tf[    0] = fst == 1;
				tf[N - 1] = lst == 1;
				
				for(int i = 0; i < N; i++){
					final boolean prev = tf[(N + i - 1) % N];
					final boolean next = tf[(N + i + 1) % N];
					
					//System.out.println(fst + " " + lst + " " + i + " " + prev + " " + same[i] + " " + next);
					if((tf[i] && same[i] == 'o') || (!tf[i] && same[i] != 'o')){
						if(i < N - 2){
							tf[i + 1] = prev;
						}else if(next != prev){
							continue LOOP;
						}
					}else{
						if(i < N - 2){
							tf[i + 1] = !prev;
						}else if(next == prev){
							continue LOOP;
						}
					}
				}
				
				for(int i = 0; i < N; i++){
					System.out.print((tf[i] ? "S" : "W"));
				}
				System.out.println();
				return;
			}
		}
		
		System.out.println(-1);
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