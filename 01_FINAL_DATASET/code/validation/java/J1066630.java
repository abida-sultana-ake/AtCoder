import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static Scanner sc;

	public static void main(String[] args) {
		Main instance = new Main();
		sc = instance.new Scanner();
		instance.solve();
	}

	private void solve() {
		try {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();

			int ab = a*b;
			int cd = c*d;

			System.out.println(Math.max(ab, cd));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class Scanner {
		String[] s;
		int i;
		BufferedReader br;
		String regex = " ";

		public Scanner() {
			s = new String[0];
			i = 0;
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		@Override
		protected void finalize() throws Throwable {
			try {
				super.finalize();
			} finally {
				destruction();
			}
		}

		private void destruction() throws IOException {
			if (br != null)
				br.close();
		}

		public String next() throws IOException {
			if (i < s.length)
				return s[i++];
			String st = br.readLine();
			while (st == "")
				st = br.readLine();
			s = st.split(regex, 0);
			i = 0;
			return s[i++];
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public Long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		public Double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}
	}
}