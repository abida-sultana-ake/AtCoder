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
		final int M = sc.nextInt();
		
		char[][] board = new char[N][];
		char[][] template = new char[M][];
		
		for(int i = 0; i < N; i++){
			board[i] = sc.next().toCharArray();
		}
		for(int i = 0; i < M; i++){
			template[i] = sc.next().toCharArray();
		}
		
		for(int oy = 0; oy <= (N - M); oy++){
			for(int ox = 0; ox <= (N - M); ox++){
				boolean ok = true;
				
				LOOP:
				for(int dy = 0; dy < M; dy++){
					for(int dx = 0; dx < M; dx++){
						if(board[oy + dy][ox + dx] != template[dy][dx]){
							ok = false;
							break LOOP;
						}
					}
				}
				
				if(ok){
					System.out.println("Yes");
					return;
				}
			}
		}
		
		System.out.println("No");
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