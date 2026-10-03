import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.text.Segment;

public class Main {
	
	public static final long INF = Long.MAX_VALUE / 2 - 1;
	
	public static void main(String[] args) throws IOException {
		try(Scanner sc = new Scanner(System.in)){
			final int N = sc.nextInt();
			
			long[][] in_adj = new long[N][N];
			long[][] wf_adj = new long[N][N];
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					in_adj[i][j] = wf_adj[i][j] = sc.nextLong();
				}	
			}
			
			int[][] nexts = new int[N][N];
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					nexts[i][j] = j;
				}
			}
			
			for(int k = 0; k < N; k++){
				for(int i = 0; i < N; i++){
					for(int j = 0; j < N; j++){
						if(wf_adj[i][j] >= wf_adj[i][k] + wf_adj[k][j]){
							if(i != k && j != k){
								nexts[i][j] = nexts[i][k];
							}
							wf_adj[i][j] = wf_adj[i][k] + wf_adj[k][j];
						}
					}
				}
			}
			
			long answer = 0;
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(in_adj[i][j] != wf_adj[i][j]){
						System.out.println(-1);
						return;
					}
				}
			}
			
			for(int i = 0; i < N; i++){
				for(int j = i + 1; j < N; j++){
					//System.out.println(i + " " + j + " " + nexts[i][j]);
					
					if(nexts[i][j] == j){
						answer += wf_adj[i][j];
					}
				}
			}
			
			System.out.println(answer);
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