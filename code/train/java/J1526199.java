import java.util.*;
import java.io.*;

public class Main {

	void solve() {
		int n = in.nextInt();
		int[] a=  new int[n];
		Map<Integer, Integer> count = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			if (!count.containsKey(a[i])) {
				count.put(a[i], 0);
			}
			count.put(a[i], count.get(a[i]) + 1);
		}
		
		List<Integer> b = new ArrayList<>();
		for (int i : count.keySet()) {
			for (int j = 0; j < count.get(i) / 2; j++) {
				b.add(i);
			}
		}
		Collections.sort(b);
		if (b.size() < 2) {
			out.println(0);
		} else {
			out.println(1L * b.get(b.size() - 2) * b.get(b.size() - 1));
		}
	}

	FastScanner in;
	PrintWriter out;

	void run() {
		in = new FastScanner();
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public String nextToken() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(nextToken());
		}

		public long nextLong() {
			return Long.parseLong(nextToken());
		}

		public double nextDouble() {
			return Double.parseDouble(nextToken());
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
