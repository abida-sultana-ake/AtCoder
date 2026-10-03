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
		int k = in.nextInt(), s = in.nextInt();
		int x, y, z;
		int ans = 0;

		for (x=0; x<=k&&x<=s; ++x) {
			for (y=0; y<=k&&x+y<=s; ++y) {
				z = s - (x + y);
				if (z>=0 && z<=k)
					++ans;
			}
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

	public int nextInt()  {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}
}
