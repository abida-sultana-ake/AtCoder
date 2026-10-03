import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class Main {
	InputStream is;

	int __t__ = 1;
	int __f__ = 0;
	int __FILE_DEBUG_FLAG__ = __f__;
	String __DEBUG_FILE_NAME__ = "src/C1";

	FastScanner in;
	PrintWriter out;
	
	/* -----------Dijkstra---------- */
	public class Edge {
		int to;
		int c;

		Edge(int to, int c) {
			this.to = to;
			this.c = c;
		}
	}

	public class Dijkstra {
		protected final static double INF = 1e13;
				
		class State implements Comparable<State> {
			int n;
			
			State(int n) {
				this.n = n;
			}

			public int compareTo(State s) {
				return Double.compare(res.minCost[n], res.minCost[s.n]);
			}
		}
		
		DijkstraResult res;
		
		Dijkstra() {}
		
		/**
		 * This function is for Fixed Graph.
		 * The second Variable "edge" should be fixed graph which is prepared by called method.
		 * @param start root node.
		 * @param edge fixed edges.
		 * @return dijkstra result.
		 */
		DijkstraResult doit(int start, double[][] edge) {
			int n = edge.length;
			res = new DijkstraResult(n);
			Arrays.fill(res.minCost, Dijkstra.INF);
			
			PriorityQueue<State> pq = new PriorityQueue<State>();
			pq.add(new State(start));
			res.minCost[start] = 0;
			res.path[start] = start;
			
			while (!pq.isEmpty()) {
				State s = pq.poll();
				for (int i = 0; i < n; i++) {
					if (res.minCost[i] > res.minCost[s.n] + edge[s.n][i]) {
						res.minCost[i] = res.minCost[s.n] + edge[s.n][i];
						res.path[i] = s.n;
						pq.add(new State(i));
					}
				}
			}
			
			return res;
		}
	}

	/**
	 * it contains minCost and path from start node to each nodes.
	 * @author hiro116s
	 *
	 */
	class DijkstraResult {
		double[] minCost;
		int[] path;
		
		DijkstraResult(int n) {
			minCost = new double[n];
			path = new int[n];
		}
	}
	/*-------------end--------------*/
	
	public void solve() {
		int xs = in.nextInt(), ys = in.nextInt(), xt = in.nextInt(), yt = in.nextInt();
		int N = in.nextInt();
		int[] x = new int[N+1];
		int[] y = new int[N+1];
		int[] r = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			r[i] = in.nextInt();
		}
		
		// src : 0, dst : N + 1
		double[][] dist = new double[N+2][N+2];
		for (int i = 0; i < N+2; i++) {
			Arrays.fill(dist[i], Dijkstra.INF);
			dist[i][i] = 0;
		}
		for (int i = 1; i <= N; i++) {
			dist[0][i]   = dist[i][0]   = calcDist(xs, ys, 0, x[i], y[i], r[i]);
			dist[N+1][i] = dist[i][N+1] = calcDist(xt, yt, 0, x[i], y[i], r[i]);
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				dist[i][j] = calcDist(x[i], y[i], r[i], x[j], y[j], r[j]);
			}
		}
		
		Dijkstra dijkstra = new Dijkstra();
		double res = Math.min(dijkstra.doit(0, dist).minCost[N+1], calcDist(xs, ys, xt, yt));
				
		System.out.println(res);
		
	}

	double calcDist(double x1, double y1, double x2, double y2) {
		double dx = x1 - x2;
		double dy = y1 - y2;
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	private double calcDist(int xs, int ys, int rs, int xt, int yt, int rt) {
		double dist = calcDist(xs, ys, xt, yt);
		return Math.max(dist - rs - rt, 0);
	}

	public void run() {
		if (__FILE_DEBUG_FLAG__ == __t__) {
			try {
				is = new FileInputStream(__DEBUG_FILE_NAME__);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("FILE_INPUT!");
		} else {
			is = System.in;
		}
		in = new FastScanner(is);
		out = new PrintWriter(System.out);

		Thread t = new Thread(null, new Runnable() {

			@Override
			public void run() {
				solve();
			}
		}, "lul", 1 << 30);
		t.start();
	}

	public static void main(String[] args) {
		new Main().run();
	}

	public void mapDebug(int[][] a) {
		System.out.println("--------map display---------");

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%3d ", a[i][j]);
			}
			System.out.println();
		}

		System.out.println("----------------------------");
		System.out.println();
	}

	public void debug(Object... obj) {
		System.out.println(Arrays.deepToString(obj));
	}

	class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
			// stream = new FileInputStream(new File("dec.in"));

		}

		int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] nextIntArray(int n) {
			int[] array = new int[n];
			for (int i = 0; i < n; i++)
				array[i] = nextInt();

			return array;
		}

		int[][] nextIntMap(int n, int m) {
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextIntArray(m);
			}
			return map;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		long[] nextLongArray(int n) {
			long[] array = new long[n];
			for (int i = 0; i < n; i++)
				array[i] = nextLong();

			return array;
		}

		long[][] nextLongMap(int n, int m) {
			long[][] map = new long[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextLongArray(m);
			}
			return map;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		double[] nextDoubleArray(int n) {
			double[] array = new double[n];
			for (int i = 0; i < n; i++)
				array[i] = nextDouble();

			return array;
		}

		double[][] nextDoubleMap(int n, int m) {
			double[][] map = new double[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextDoubleArray(m);
			}
			return map;
		}

		String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		String[] nextStringArray(int n) {
			String[] array = new String[n];
			for (int i = 0; i < n; i++)
				array[i] = next();

			return array;
		}

		String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}
}
