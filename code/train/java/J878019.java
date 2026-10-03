
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	InputStream is;

	int __t__ = 1;
	int __f__ = 0;
	int __FILE_DEBUG_FLAG__ = __f__;
	String __DEBUG_FILE_NAME__ = "src/C4";

	FastScanner in;
	PrintWriter out;
	
	class Edge {
		int to;
		int company;

		Edge(int to, int cost) {
			this.to = to;
			this.company = cost;
		}
	}
	
	class State implements Comparable<State> {
		int id;
		int cost;

		State(int id, int cost) {
			this.id = id;
			this.cost = cost;
		}

		public int compareTo(State s) {
			return cost - s.cost;
		}

		public String toString() {
			return "(" + id + ", " + cost + ")";
		}
	}
	
	class State2 implements Comparable<State2> {
		int id;
		int cost;
		int company;

		State2(int id, int cost, int company) {
			this.id = id;
			this.cost = cost;
			this.company = company;
		}

		public int compareTo(State2 s) {
			return cost - s.cost;
		}

		public String toString() {
			return "(" + id + ", " + cost + ", " + company + ")";
		}
	}
	
	int INF = 1000000000;
	int[] dijkstra(ArrayList<Edge>[] g, int s) {
		int n = g.length;
		int[] minCost = new int[n];
		Arrays.fill(minCost, INF);
		minCost[s] = 0;
		
		HashSet<Integer>[] companies = new HashSet[n];
		for (int i = 0; i < n; i++) {
			companies[i] = new HashSet<>();
		}
 
		PriorityQueue<State> pq = new PriorityQueue<>();
		pq.add(new State(s, 0));
		
		while (!pq.isEmpty()) {
			State ns = pq.poll();
			if (minCost[ns.id] < ns.cost) continue;
			
			for (Edge e : g[ns.id]) {
				int nid = e.to;
				int ncompany = e.company;
				int ncost = ns.cost;
				if (!companies[ns.id].contains(ncompany)) ncost++;
				
				if (minCost[nid] > ncost) {
					minCost[nid] = ncost;
					pq.add(new State(nid, ncost));
					companies[nid].clear();
				}
				if (minCost[nid] == ncost) {
					companies[nid].add(ncompany);
				}
			}
		}
		return minCost;
	}
	int[] dijkstra2(ArrayList<Edge>[] g, int s) {
		int n = g.length;
		int[] minCost = new int[n];
		Arrays.fill(minCost, INF);
		minCost[s] = 0;
		
		HashSet<Integer>[] companies = new HashSet[n];
		for (int i = 0; i < n; i++) {
			companies[i] = new HashSet<>();
		}

		PriorityQueue<State> pq = new PriorityQueue<>();
		pq.add(new State(s, 0));
		
		Queue<State2> bfsQueue = new LinkedList<>();
		
		while (!pq.isEmpty()) {
			State ns = pq.poll();
			if (minCost[ns.id] < ns.cost) continue;
			
			for (Edge e : g[ns.id]) {
				int nid = e.to;
				int ncompany = e.company;
				int ncost = ns.cost;
				if (!companies[ns.id].contains(ncompany)) ncost++;
				
				if (minCost[nid] > ncost) {
					minCost[nid] = ncost;
					pq.add(new State(nid, ncost));
					bfsQueue.add(new State2(nid, ncost, ncompany));
					companies[nid].clear();
				}
				if (minCost[nid] == ncost) {
					companies[nid].add(ncompany);
				}
			}
			
			while (!bfsQueue.isEmpty()) {
				State2 nns = bfsQueue.poll();
				
				for (Edge e : g[nns.id]) {
					int nid = e.to;
					int ncompany = e.company;
					int ncost = nns.cost;
					if (ncompany != nns.company) continue;
					if (companies[nid].contains(ncompany)) continue;

					if (minCost[nid] > ncost) {
						minCost[nid] = ncost;
						companies[nid].clear();
					}
					if (minCost[nid] == ncost) {
						companies[nid].add(ncompany);
						bfsQueue.add(new State2(nid, ncost, ncompany));
					}
				}
			}
		}
		return minCost;
	}
	
	public void solve() {
		int n = in.nextInt(), m = in.nextInt();
		ArrayList<Edge>[] g = new ArrayList[n];
		for (int i = 0; i < n; i++)
			g[i] = new ArrayList<Edge>();
		
		for (int i = 0; i < m; i++) {
			int p = in.nextInt() - 1, q = in.nextInt() - 1, c = in.nextInt();
			g[p].add(new Edge(q, c));
			g[q].add(new Edge(p, c));
		}
		
		int[] cost = dijkstra(g, 0);
		int[] cost2 = dijkstra2(g, 0);
		int res = Math.min(cost[n-1], cost2[n-1]);
		System.out.println(res == INF ? -1 : res);
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
			//stream = new FileInputStream(new File("dec.in"));

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


