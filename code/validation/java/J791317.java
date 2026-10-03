import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {
	int N, M;
	ArrayList<Integer>[] down;

	public void solve() {
		N = nextInt();
		M = nextInt();

		down = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			down[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int x = nextInt() - 1;
			int y = nextInt() - 1;
			down[x].add(y);
		}


		long[] dp = new long[1 << N];


		dp[(1 << N) - 1] = 1;

		//ウサギの集合
		for(int i = (1 << N) - 1;i >= 0;i--){

			//ウサギの集合iの中で最後に到着したウサギj
			for(int j = 0;j < N;j++){
				//ウサギの集合iの中にウサギjが含まれない場合
				if((i >> j & 1 )== 0)continue;

				boolean ok = true;

				//ウサギ集合iの中でウサギj一番最後に到着することができるかどうか検証
				for(int k = 0;k < N;k++){
					//ウサギの集合iの中にウサギkが含まれない場合
					if((i >> k & 1) == 0)continue;

					//ウサギkよりウサギjが後から到着する場合
					if(down[k].contains(j)){
						ok = false;
						break;
					}

				}

				//ウサギjが一番最後に到着することが可能な場合
				if(ok){
					dp[i ^ (1 << j)] += dp[i];
				}
			}
		}

		out.println(dp[0]);

	}

	public static void main(String[] args) {
		out.flush();
		new Main().solve();
		out.close();
	}

	/* Input */
	private static final InputStream in = System.in;
	private static final PrintWriter out = new PrintWriter(System.out);
	private final byte[] buffer = new byte[2048];
	private int p = 0;
	private int buflen = 0;

	private boolean hasNextByte() {
		if (p < buflen)
			return true;
		p = 0;
		try {
			buflen = in.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (buflen <= 0)
			return false;
		return true;
	}

	public boolean hasNext() {
		while (hasNextByte() && !isPrint(buffer[p])) {
			p++;
		}
		return hasNextByte();
	}

	private boolean isPrint(int ch) {
		if (ch >= '!' && ch <= '~')
			return true;
		return false;
	}

	private int nextByte() {
		if (!hasNextByte())
			return -1;
		return buffer[p++];
	}

	public String next() {
		if (!hasNext())
			throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = -1;
		while (isPrint((b = nextByte()))) {
			sb.appendCodePoint(b);
		}
		return sb.toString();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}
}