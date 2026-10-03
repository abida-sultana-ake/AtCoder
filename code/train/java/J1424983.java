import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {

	int N;
	ArrayList<Integer>[] graph;

	@SuppressWarnings("unchecked")
	public void solve() {
		N = nextInt();

		graph = new ArrayList[N];
		for(int i = 0;i < N;i++){
			graph[i] = new ArrayList<>();
		}

		for(int i = 0;i < N-1;i++){
			int a = nextInt()-1;
			int b = nextInt()-1;

			graph[a].add(b);
			graph[b].add(a);
		}

		int[][] color = new int[N][2];
		for(int i = 0;i < N;i++){
			color[i][0] = Integer.MAX_VALUE;
			color[i][1] = Integer.MAX_VALUE;
		}

		bfs(0,color);
		bfs(1,color);

		int count = 0;

		for(int i = 0;i < N;i++){
			if(color[i][0] <= color[i][1]){
				count++;
			}
		}

		out.println(count > N - count ? "Fennec" : "Snuke");
	}

	private void bfs(int ind,int[][] color){
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();

		if(ind == 0){
			q.add(new int[]{0,0});
		}else{
			q.add(new int[]{N-1,0});
		}

		boolean[] used = new boolean[N];

		while(q.size() > 0){

			int[] d = q.poll();

			int now = d[0];
			int time = d[1];
			if(used[now])continue;
			used[now] = true;
			color[now][ind] = time;

			for(int next : graph[now]){
				if(used[next])continue;
				q.add(new int[]{next,time + 1});
			}
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