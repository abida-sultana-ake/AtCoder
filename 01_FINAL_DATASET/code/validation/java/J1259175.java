import java.lang.*;
import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws java.lang.Exception {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(in, out);
		out.close();
	}
}

class TaskA {
	
	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		String op = in.next();
		int x = 0, ans = x;
		
		for (int i=0; i<n; ++i) {
			if (op.charAt(i) == 'I')
				++x;
			else
				--x;
			ans = Math.max(ans, x);
		}
		
		out.println(ans);
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;
	
	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}
	
	public String next() {
		while (tokenizer==null || !tokenizer.hasMoreTokens()) {
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
}
