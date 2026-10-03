import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
/**
 * Built using CHelper plug-in Actual solution is at the top
 */
public class Main {
	public final static double MAX_T = 1000000;
	public final static double MIN_T = 0;
	public static int s = 0;
 
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
 
	static class TaskC {
 
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int m = in.nextInt();
			out.println((n - 1) * (m - 1));	
		}
 
	}
 
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
 
		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}
 
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
 
		public int nextInt() {
			return Integer.parseInt(next());
		}
 
		public long nextLong() {
			return Long.parseLong(next());
		}
 
		public double nextFloat() {
			return Double.parseDouble(next());
		}
 
		public double nextDouble() {
			return Double.parseDouble(next());
		}
 
	}
}
