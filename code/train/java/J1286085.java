import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
	int N,M;
	Edge[] edges;
	long[] costs;

	private class Edge{
		int from,to;
		long cost;
		public Edge(int from,int to,long cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	public long bellman_ford(){
		for(int i = 0;i < N;i++){
			for(int j = 0;j < M;j++){
				Edge e = edges[j];
				if(costs[e.to] > costs[e.from]+e.cost){
					costs[e.to] = costs[e.from]+e.cost;
				}

			}
		}
		return costs[N-1];
	}

	public void solve() {
		N = nextInt();
		M = nextInt();

		edges = new Edge[M];

		for(int i = 0;i < M;i++){
			int a = nextInt()-1;
			int b = nextInt()-1;
			int c = nextInt();
			edges[i] = new Edge(a,b,-c);
		}
		costs = new long[N];
		Arrays.fill(costs,Long.MAX_VALUE/2);
		costs[0] = 0;
		long ans1 = bellman_ford();
		long ans2 = bellman_ford();

		if(ans1 != ans2)out.println("inf");
		else out.println(-ans1);
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