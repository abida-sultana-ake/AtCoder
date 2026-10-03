import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskE solver = new TaskE();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskE {
		public void solve(int testNumber, FastScanner in, PrintWriter out) {
			List<Integer>[] positions = new List[26];
			for (int i = 0; i < positions.length; i++) {
				positions[i] = new ArrayList<>();
			}
			char[] s = in.next().toCharArray();
			int n = s.length;
			for (int i = 0; i < n; i++) {
				s[i] -= 'a';
				positions[s[i]].add(i);
			}
			for (int i = 0; i < positions.length; i++) {
				positions[i].add(n);
			}

			int[] maxLen = new int[n + 1];
			maxLen[n] = 1;
			for (int i = n - 1; i >= 0; i--) {
				int j = findMax(positions, i);
				if (j == n) {
					maxLen[i] = 1;
				} else {
					maxLen[i] = maxLen[j + 1] + 1;
				}
			}

			char[] ans = new char[maxLen[0]];
			int pos = 0;
			for (int i = 0; i < ans.length; i++) {
				for (int c = 0; c < 26; c++) {
					ans[i] = (char) (c + 'a');
					int k = Collections.binarySearch(positions[c], pos);
					if (k < 0) {
						k = ~k;
					}
					int npos = positions[c].get(k);
					if (npos == n && i == ans.length - 1) {
						break;
					}
					if (maxLen[npos + 1] == ans.length - i - 1) {
						pos = npos + 1;
						break;
					}
				}
			}
			out.println(new String(ans));
		}

		private int findMax(List<Integer>[] positions, int i) {
			int res = 0;
			for (int c = 0; c < 26; c++) {
				int k = Collections.binarySearch(positions[c], i);
				if (k < 0) {
					k = ~k;
				}
				res = Math.max(res, positions[c].get(k));
			}
			return res;
		}

	}

	static class FastScanner {
		private BufferedReader in;
		private StringTokenizer st;

		public FastScanner(InputStream stream) {
			in = new BufferedReader(new InputStreamReader(stream));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(in.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

	}
}

