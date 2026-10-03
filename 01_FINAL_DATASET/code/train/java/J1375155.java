
import java.util.*;
import java.io.*;

public class Main {
	static int MAXN = 1001, mod = (int) (1e9 + 7);
	static long comb[][];

	public static void main(String[] args) {
		InputReader s = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		/*My code starts here.*/
		int n = s.nextInt();
		boolean arr[] = new boolean[n+1];
		int inp[] = new int[n+1];
		for(int i=1;i<=n;i++)
			inp[i] = s.nextInt();
		int flg=0,count=0;
		int i=1;
		while(true){
			int k = inp[i];
			if(arr[k]){
				flg = -1;
				break;
			}
			arr[i] = true;
			count++;
			if(inp[i]==2){
				break;
			}
			i = inp[i];
		}
		if(flg==-1)
			out.println("-1");
		else
			out.println(count);
		/*My code ends here.*/
		out.close();
	}

	static class Node implements Comparable<Node> {
		int num, freq, idx;

		public Node(int u, int v, int idx) {
			this.num = u;
			this.freq = v;
			this.idx = idx;
		}

		public int compareTo(Node n) {
			if (this.freq == n.freq)
				return Integer.compare(this.num, n.num);
			return Integer.compare(-this.freq, -n.freq);
		}
	}

	static void preCalcComb() {
		comb = new long[MAXN][MAXN];
		comb[0][0] = 1;
		for (int i = 1; i < MAXN; i++) {
			comb[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % mod;
			}
		}
	}

	static long PowerMod(long a, long b, long m) {
		long tempo;
		if (b == 0)
			tempo = 1;
		else if (b == 1)
			tempo = a;
		else {
			long temp = PowerMod(a, b / 2, m);
			if (b % 2 == 0)
				tempo = (temp * temp) % m;
			else
				tempo = ((temp * temp) % m) * a % m;
		}
		return tempo;
	}

	long no_of_primes(long m, long n, long k) {
		long count = 0, i, j;
		int primes[] = new int[(int) (n - m + 2)];
		if (m == 1)
			primes[0] = 1;
		for (i = 2; i <= Math.sqrt(n); i++) {
			j = (m / i);
			j *= i;
			if (j < m)
				j += i;
			for (; j <= n; j += i) {
				if (j != i)
					primes[(int) (j - m)] = 1;
			}
		}
		for (i = 0; i <= n - m; i++)
			if (primes[(int) i] == 0 && (i - 1) % k == 0)
				count++;
		return count;
	}

	static void shortestPaths(List<Edge>[] edges, int s, int[] prio, int[] pred) {
		Arrays.fill(pred, -1);
		Arrays.fill(prio, Integer.MAX_VALUE);
		prio[s] = 0;
		PriorityQueue<Long> q = new PriorityQueue<>();
		q.add((long) s);
		while (!q.isEmpty()) {
			long cur = q.remove();
			int curu = (int) cur;
			if (cur >>> 32 != prio[curu])
				continue;
			for (Edge e : edges[curu]) {
				int v = e.t;
				int nprio = prio[curu] + e.cost;
				if (prio[v] > nprio) {
					prio[v] = nprio;
					pred[v] = curu;
					q.add(((long) nprio << 32) + v);
				}
			}
		}
	}

	static class Edge {
		int t, cost;

		public Edge(int t, int cost) {
			this.t = t;
			this.cost = cost;
		}
	}

	static class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar, snumChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public String readString() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}
