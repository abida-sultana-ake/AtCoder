import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

	int N,Q,K;
	ArrayList<Edge>[] graph;

	class Edge{
		int b;
		long c;
		public Edge(int b,long c){
			this.b = b;
			this.c = c;
		}
	}

	@SuppressWarnings("unchecked")
	public void solve(){
		N = nextInt();
		graph = new ArrayList[N];
		for(int i = 0;i < N;i++){
			graph[i] = new ArrayList<>();
		}

		for(int i = 0;i < N-1;i++){
			int a = nextInt()-1;
			int b = nextInt()-1;
			int c = nextInt();
			graph[a].add(new Edge(b,c));
			graph[b].add(new Edge(a,c));
		}

		Q = nextInt();
		K = nextInt()-1;

		ArrayDeque<Edge> q = new ArrayDeque<Edge>();
		long[] dis = new long[N];
		Arrays.fill(dis, -1);
		q.add(new Edge(K,0));

		while(q.size() > 0){

			Edge e = q.poll();

			if(dis[e.b] != -1)continue;
			dis[e.b] = e.c;
			for(Edge next : graph[e.b]){
				if(dis[next.b] != -1)continue;
				q.add(new Edge(next.b,e.c + next.c));
			}

		}

		for(int i = 0;i < Q;i++){
			int x = nextInt()-1;
			int y = nextInt()-1;

			out.println(dis[x] +dis[y]);
		}
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