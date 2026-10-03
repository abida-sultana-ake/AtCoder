import java.io.*;
import java.util.*;

public class Main {

	static class SparseTable {

		private int getLog(int len) {
			return len <= 2 ? 0 : 31 - Integer.numberOfLeadingZeros(len - 1);
		}

		private /*1*/int[][] d;

		public SparseTable(/*1*/int[] a) {
			int n = getLog(a.length);
			d = new /*1*/int[n + 1][];
			d[0] = a.clone();
			for (int i = 1; i <= n; i++) {
				d[i] = new /*1*/int[a.length - (1 << i) + 1];
				for (int j = 0; j < d[i].length; j++) {
					d[i][j] = /*2*/Math.min(d[i - 1][j], d[i - 1][j + (1 << (i - 1))]);
				}
			}
		}

		public /*1*/int get(int l, int r) {
			int i = getLog(r - l);
			return /*2*/Math.min(d[i][l], d[i][r - (1 << i)]);
		}

	}
	
	SparseTable evenT, oddT;
	int[] p;
	int[] inv;
	
	
	void submit() {
		int n = nextInt();
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = nextInt() - 1;
		}
		
		inv = new int[n];
		for (int i = 0; i < n; i++) {
			inv[p[i]] = i;
		}
	
		int[] even = new int[n / 2];
		int[] odd = new int[n / 2];
		for (int i = 0; i < n; i++) {
			(i % 2 == 0 ? even : odd)[i / 2] = p[i];
		}
		
		evenT = new SparseTable(even);
		oddT = new SparseTable(odd);
		
		PriorityQueue<Segment> pq = new PriorityQueue<>();
		pq.add(makeSegment(0, n));
		
		for (int i = 0; i < n / 2; i++) {
			Segment segm = pq.poll();
			out.print((segm.value + 1) + " ");
			int posMax = inv[segm.value];
			
			int valPair;
			if (segm.l % 2 == 0) {
				valPair = oddT.get(posMax / 2, segm.r / 2);
			} else {
				valPair = evenT.get(posMax / 2 + 1, segm.r / 2 + 1);
			}
			out.print((valPair + 1) + " ");
			int posPair = inv[valPair];
			
			if (segm.l < posMax) {
				pq.add(makeSegment(segm.l, posMax));
			}
			if (posMax + 1 < posPair) {
				pq.add(makeSegment(posMax + 1, posPair));
			}
			if (posPair + 1 < segm.r) {
				pq.add(makeSegment(posPair + 1, segm.r));
			}
		}
		
		
	}
	
	Segment makeSegment(int l, int r) {
		int value;
		if (l % 2 == 0) {
			value = evenT.get(l / 2, r / 2);
		} else {
			value = oddT.get(l / 2, r / 2);
		}
		return new Segment(l, r, value);
	}
	
	static class Segment implements Comparable<Segment> {
		int l, r;
		int value;
		
		@Override
		public int compareTo(Segment o) {
			return Integer.compare(value, o.value);
		}

		public Segment(int l, int r, int value) {
			this.l = l;
			this.r = r;
			this.value = value;
		}
	}

	void preCalc() {

	}

	void stress() {

	}

	void test() {

	}

	Main() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		preCalc();
		submit();
		//stress();
		//test();
		out.close();
	}

	static final Random rng = new Random();

	static int rand(int l, int r) {
		return l + rng.nextInt(r - l + 1);
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}

	BufferedReader br;
	PrintWriter out;
	StringTokenizer st;

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return st.nextToken();
	}

	String nextString() {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}
}
