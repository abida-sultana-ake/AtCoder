import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class Tree {
	int n;
	Edges[] es;
	long[] dsts;

	Tree(int n) {
		this.n = n;
		es = new Edges[n];
		for (int i = 0; i < n; i++) {
			es[i] = new Edges();
		}
		dsts = new long[n];
	}

	void addEdge(int a, int b, long c) {
		es[a].e.add(new Edge(b, c));
		es[b].e.add(new Edge(a, c));
	}

	void dfs(int st) {
		for (int i = 0; i < n; i++) {
			dsts[i] = -1;
		}
		dsts[st] = 0;
		dfs2(st);
	}

	private void dfs2(int a) {
		for (Edge e : es[a].e) {
			int to = e.to;
			long cc = dsts[a] + e.c;
			if (dsts[to] == -1 || cc < dsts[to]) {
				dsts[to] = cc;
				dfs2(to);
			}
		}
	}
}

class Edges {
	ArrayList<Edge> e;

	Edges() {
		e = new ArrayList<Edge>();
	}
}

class Edge {
	int to;
	long c;

	Edge(int to, long c) {
		this.to = to;
		this.c = c;
	}
}

public class Main {
	private static void solve() {
		int n = nei();
		Tree t = new Tree(n);
		for (int i = 0; i < n - 1; i++) {
			int a = nei() - 1;
			int b = nei() - 1;
			long c = nel();
			t.addEdge(a, b, c);
		}
		int q = nei();
		int k = nei() - 1;
		t.dfs(k);
		int[][] qs = new int[q][2];
		for (int i = 0; i < q; i++) {
			qs[i][0] = nei() - 1;
			qs[i][1] = nei() - 1;
		}
		for (int i = 0; i < q; i++) {
			out(t.dsts[qs[i][0]] + t.dsts[qs[i][1]]);
		}
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

	static String nes() {
		return IO.next();
	}

	static int nei() {
		return IO.nextInt();
	}

	static long nel() {
		return IO.nextLong();
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
		solve();
		IO.flush();
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