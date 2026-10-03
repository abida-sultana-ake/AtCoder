import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		final Scanner sc = new Scanner(System.in);
		
		final int H = sc.nextInt();
		final int W = sc.nextInt();
		
		System.out.println(((H - 1) * W) + (H * (W - 1)));
		
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
 
		public void close() throws IOException {
			br.close();
		}
	}
}