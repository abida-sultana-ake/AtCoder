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
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		final Scanner sc = new Scanner(System.in);
		
		final int N = sc.nextInt();
		int[] As = new int[N];
		for(int i = 0; i < N; i++){
			As[i] = sc.nextInt();
		}
		
		int[] counts = new int[N];
		for(int i = 0; i < N; i++){
			counts[As[i]]++;
		}
		
		if(N % 2 == 0){
			for(int i = 0; i < N; i++){
				if(i % 2 == 0 && counts[i] > 0){
					System.out.println(0);
					return;
				}else if(i % 2 != 0 && counts[i] != 2){
					System.out.println(0);
					return;
				}
			}
		}else{
			for(int i = 0; i < N; i++){
				if(i % 2 != 0 && counts[i] > 0){
					System.out.println(0);
					return;
				}else if(i == 0 && counts[0] == 0){
					System.out.println(0);
					return;
				}else if(i != 0 && i % 2 == 0 && counts[i] != 2){
					System.out.println(0);
					return;
				}
			}
		}
		
		long answer = 1;
		for(int i = 0; i < N / 2; i++){
			answer *= 2;
			answer %= 1000000007;
		}
		
		System.out.println(answer);
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