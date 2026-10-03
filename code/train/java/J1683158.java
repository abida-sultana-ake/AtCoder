import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Queue;

class Edge {
	int to;
	long weight;

	Edge(int to, long weight) {
		this.to = to;
		this.weight = weight;
	}
}

class Node {
	int idx;
	int dfsVisited;
	ArrayList<Edge> es;
	long dist;

	Node(int idx) {
		this.idx = idx;
		es = new ArrayList<Edge>();
	}

	void edge(int to, long weight) {
		es.add(new Edge(to, weight));
	}
}

class Graph {
	int n;
	boolean directed;
	ArrayList<Node> ns;

	Graph(int n, boolean directed) {
		this.n = n;
		this.directed = directed;
		ns = new ArrayList<Node>();
		for (int i = 0; i < n; i++) {
			ns.add(new Node(i));
		}
	}

	void edge(int from, int to, long weight) {
		ns.get(from).edge(to, weight);
		if (!directed) {
			ns.get(to).edge(from, weight);
		}
	}

	void dfs(int from) {
		for (Node n : ns) {
			n.dfsVisited = 0;
		}
		dfsImpl(from);
	}

	private void dfsVisit(Node n) {
		// write code here...
	}

	private void dfsImpl(int from) {
		Node n = ns.get(from);
		if (n.dfsVisited != 0)
			return;
		n.dfsVisited = 1;
		dfsVisit(n);
		for (Edge e : n.es) {
			dfsImpl(e.to);
		}
	}

	void dijkstra1(int from) {
		for (int i = 0; i < n; i++) {
			ns.get(i).dist = Long.MAX_VALUE;
		}

		Queue<Node> q = new ArrayDeque<Node>();

		Node st = ns.get(from);
		st.dist = 0;
		q.add(st);

		while (!q.isEmpty()) {
			Node n = q.poll();
			long dist = n.dist;
			for (Edge e : n.es) {
				Node to = ns.get(e.to);
				if (to.dist > dist + 1) {
					to.dist = dist + 1;
					q.add(to);
				}
			}
		}
	}

	long treeDiameter1() {
		dijkstra1(0);
		Node n1 = ns.get(0);

		for (int i = 1; i < n; i++) {
			if (ns.get(i).dist > n1.dist)
				n1 = ns.get(i);
		}

		dijkstra1(n1.idx);

		long diam = 0;
		for (int i = 0; i < n; i++) {
			if (ns.get(i).dist > diam)
				diam = ns.get(i).dist;
		}

		return diam;
	}
}

public class Main {
	private static void solve() {
		int n = nei();
		int K = nei();
		long[][] ps = nls2(n, 2);

		ArrayList<Long> xs = new ArrayList<Long>();
		ArrayList<Long> ys = new ArrayList<Long>();
		for (int i = 0; i < n; i++) {
			xs.add(ps[i][0]);
			ys.add(ps[i][1]);
		}
		xs.sort((a, b) -> Long.signum(a - b));
		ys.sort((a, b) -> Long.signum(a - b));

		long minArea = Long.MAX_VALUE;
		for (int i = 0; i < xs.size(); i++) {
			for (int j = i + 1; j < xs.size(); j++) {
				for (int k = 0; k < ys.size(); k++) {
					for (int l = k + 1; l < ys.size(); l++) {
						long x1 = xs.get(i);
						long x2 = xs.get(j);
						long y1 = ys.get(k);
						long y2 = ys.get(l);
						if (num(n, ps, x1, y1, x2, y2) >= K) {
							long area = (y2 - y1) * (x2 - x1);
							if (area < minArea) {
								minArea = area;
							}
						}
					}
				}
			}
		}
		System.out.println(minArea);
	}

	static int num(int n, long[][] ps, long x1, long y1, long x2, long y2) {
		int num = 0;
		for (int i = 0; i < n; i++) {
			if (ps[i][0] >= x1 && ps[i][0] <= x2 && ps[i][1] >= y1 && ps[i][1] <= y2)
				num++;
		}
		return num;
	}

	static int[] lis(int[] s) {
		int n = s.length;
		int[] dp = new int[n];
		int[] ids = new int[n];
		int[] pids = new int[n];
		dp[0] = s[0];
		int len = 1;
		int lidx = 0;
		for (int i = 1; i < n; i++) {
			int idx = bs(s[i], dp, 0, len);
			dp[idx] = s[i];
			ids[idx] = i;
			if (idx == len) {
				lidx = i;
				len++;
			}
			if (idx > 0)
				pids[i] = ids[idx - 1];
		}
		int[] lis = new int[len];
		lis[len - 1] = s[lidx];
		for (int i = len - 1; i >= 0; i--) {
			lis[i] = s[lidx];
			lidx = pids[lidx];
		}
		return lis;
	}

	static int bs(int a, int[] as, int from, int num) {
		int min = from;
		int max = from + num - 1;
		while (min < max) {
			int mid = min + max >> 1;
			if (as[mid] < a)
				min = mid + 1;
			else if (as[mid] > a)
				max = mid;
			else
				return mid;
		}
		return as[min] < a ? min + 1 : min;
	}

	static int gcd(int x, int y) {
		x = (x ^ x >> 31) - (x >> 31);
		y = (y ^ y >> 31) - (y >> 31);
		if (x < y) {
			x ^= y;
			y ^= x;
			x ^= y;
		}
		int z = x % y;
		if (z == 0)
			return y;
		return gcd(y, z);
	}

	static long gcd(long x, long y) {
		x = (x ^ x >> 63) - (x >> 63);
		y = (y ^ y >> 63) - (y >> 63);
		if (x < y) {
			x ^= y;
			y ^= x;
			x ^= y;
		}
		long z = x % y;
		if (z == 0)
			return y;
		return gcd(y, z);
	}

	static int lcm(int x, int y) {
		x = (x ^ x >> 31) - (x >> 31);
		y = (y ^ y >> 31) - (y >> 31);
		return x / gcd(x, y) * y;
	}

	static long lcm(long x, long y) {
		x = (x ^ x >> 63) - (x >> 63);
		y = (y ^ y >> 63) - (y >> 63);
		return x / gcd(x, y) * y;
	}

	static int abs(int x) {
		return x < 0 ? -x : x;
	}

	static long abs(long x) {
		return x < 0 ? -x : x;
	}

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static long min(long a, long b) {
		return a < b ? a : b;
	}

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	static long max(long a, long b) {
		return a > b ? a : b;
	}

	static int clamp(int a, int min, int max) {
		return a < min ? min : a > max ? max : a;
	}

	static long clamp(long a, long min, long max) {
		return a < min ? min : a > max ? max : a;
	}

	static void out(String val) {
		IO.out(val);
	}

	static void out(Object val) {
		IO.out(String.valueOf(val));
	}

	static void out(int val) {
		IO.out(String.valueOf(val));
	}

	static void out(long val) {
		IO.out(String.valueOf(val));
	}

	static void out(char val) {
		IO.out(String.valueOf(val));
	}

	static void out(float val) {
		IO.out(String.valueOf(val));
	}

	static void out(double val) {
		IO.out(String.valueOf(val));
	}

	static void out(boolean val) {
		IO.out(String.valueOf(val));
	}

	static void kil(String val) {
		IO.out(val);
		IO.flush();
		System.exit(0);
	}

	static void kil(Object val) {
		IO.out(String.valueOf(val));
		IO.flush();
		System.exit(0);
	}

	static void kil(int val) {
		IO.out(String.valueOf(val));
		IO.flush();
		System.exit(0);
	}

	static void kil(long val) {
		IO.out(String.valueOf(val));
		IO.flush();
		System.exit(0);
	}

	static void kil(char val) {
		IO.out(String.valueOf(val));
		IO.flush();
		System.exit(0);
	}

	static void kil(float val) {
		IO.out(String.valueOf(val));
		IO.flush();
		System.exit(0);
	}

	static void kil(double val) {
		IO.out(String.valueOf(val));
		IO.flush();
		System.exit(0);
	}

	static void kil(boolean val) {
		IO.out(String.valueOf(val));
		IO.flush();
		System.exit(0);
	}

	static String nes() {
		return IO.next();
	}

	static int nei() {
		return IO.nextInt();
	}

	static long nel() {
		return IO.nextLong();
	}

	static String[] nss(int n) {
		String[] as = new String[n];
		for (int i = 0; i < n; i++) {
			as[i] = IO.next();
		}
		return as;
	}

	static int[] nis(int n) {
		int[] as = new int[n];
		for (int i = 0; i < n; i++) {
			as[i] = IO.nextInt();
		}
		return as;
	}

	static long[] nls(int n) {
		long[] as = new long[n];
		for (int i = 0; i < n; i++) {
			as[i] = IO.nextLong();
		}
		return as;
	}

	static String[][] nss2(int n, int m) {
		String[][] as = new String[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				as[i][j] = IO.next();
			}
		}
		return as;
	}

	static int[][] nis2(int n, int m) {
		int[][] as = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				as[i][j] = IO.nextInt();
			}
		}
		return as;
	}

	static long[][] nls2(int n, int m) {
		long[][] as = new long[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				as[i][j] = IO.nextLong();
			}
		}
		return as;
	}

	static int parseInt(String val) {
		return Integer.parseInt(val);
	}

	static int parseInt(char val) {
		return Integer.parseInt(String.valueOf(val));
	}

	static long parseLong(String val) {
		return Long.parseLong(val);
	}

	public static void main(String[] args) {
		try {
			solve();
			IO.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

final class IO {
	private static final InputStream in = System.in;
	private static final PrintWriter out = new PrintWriter(System.out, false);
	private static final byte[] buffer = new byte[1024];
	private static int ptr = 0;
	private static int len = 0;

	private static boolean hasNextByte() {
		if (ptr < len)
			return true;
		ptr = 0;
		try {
			len = in.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return len > 0;
	}

	private static int readByte() {
		if (hasNextByte())
			return buffer[ptr++];
		else
			return -1;
	}

	static boolean hasNext() {
		byte c;
		while (hasNextByte() && ((c = buffer[ptr]) < '!' || c > '~'))
			ptr++;
		return hasNextByte();
	}

	static String next() {
		if (!hasNext())
			throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while (b >= '!' && b <= '~') {
			sb.append((char) b);
			b = readByte();
		}
		return sb.toString();
	}

	static long nextLong() {
		if (!hasNext())
			throw new NoSuchElementException();
		long n = 0;
		int sign = 1;
		int b = readByte();
		if (b == '-') {
			sign = -1;
			b = readByte();
		}
		if (b < '0' || '9' < b)
			throw new NumberFormatException();
		while (true) {
			if ('0' <= b && b <= '9')
				n = n * 10 + b - '0';
			else if (b == -1 || b < '!' || b > '~')
				return n * sign;
			else
				throw new NumberFormatException();
			b = readByte();
		}
	}

	static int nextInt() {
		if (!hasNext())
			throw new NoSuchElementException();
		int n = 0;
		int sign = 1;
		int b = readByte();
		if (b == '-') {
			sign = -1;
			b = readByte();
		}
		if (b < '0' || '9' < b)
			throw new NumberFormatException();
		while (true) {
			if ('0' <= b && b <= '9')
				n = n * 10 + b - '0';
			else if (b == -1 || b < '!' || b > '~')
				return n * sign;
			else
				throw new NumberFormatException();
			b = readByte();
		}
	}

	static void out(String val) {
		out.println(val);
	}

	static void flush() {
		out.flush();
	}
}