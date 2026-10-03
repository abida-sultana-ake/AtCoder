import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
	static int INF = (int)1e9 + 7;
	int H, W;
	int[][] a;
	int[] dx = { 0, 0, 1, -1 };
	int[] dy = { 1, -1, 0, 0 };
	long[][] cost;
	boolean[][] used;
	public boolean check(int x, int y) {
		if (x < 0 || x >= W || y < 0 || y >= H)
			return false;
		return true;
	}

	public long dfs(int y,int x){
		if(cost[y][x] != -1){
			return cost[y][x];
		}
		cost[y][x] = 1;
		for(int i = 0;i < 4;i++){
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if(check(nx,ny) && a[ny][nx] > a[y][x] && !used[ny][nx]){
				used[ny][nx] = true;
				cost[y][x] += dfs(ny,nx) % INF;
				cost[y][x] %= INF;
				used[ny][nx] = false;
			}
		}

		return cost[y][x] %= INF;
	}

	public void solve() {
		H = nextInt();
		W = nextInt();
		a = new int[H][W];
		used = new boolean[H][W];
		cost = new long[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				a[i][j] = nextInt();
			}
		}

		for(int i = 0;i < H;i++){
			for(int j = 0;j < W;j++){
				cost[i][j] = -1;
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				used[i][j] = true;
				dfs(i,j);
				used[i][j] = false;
			}
		}
		long ans = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				ans += cost[i][j];
				ans %= INF;
			}
		}
		out.println(ans);
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