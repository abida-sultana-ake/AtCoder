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
	
	public void solve(InputReader in, PrintWriter out)  {
		int w = in.nextInt(), a = in.nextInt(), b = in.nextInt();
		
		if (b>=a && b<=a+w) {
			out.println("0");
		} else if (b+w>=a && b+w<=a+w) {
			out.println("0");
		} else {
			int x1 = Math.abs(a-b), x2 = Math.abs(a+w-b);
			int ans1 = Math.min(x1, x2);
			int y1 = Math.abs(a-b-w), y2 = Math.abs(a+w-b-w);
			int ans2 = Math.min(y1, y2);
			int ans = Math.min(ans1, ans2);
			out.println(ans);
		}
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
	
	public double nextDouble() {
		return Double.parseDouble(next());
	}
	
	public long nextLong() {
		return Long.parseLong(next());
	}
}