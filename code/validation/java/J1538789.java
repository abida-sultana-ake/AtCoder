import java.io.*;
import java.util.*;

public class Main {
	private static final boolean local = false;
	private static BufferedReader br;
	private static StringTokenizer st;
	private static PrintWriter output;
	//char c = line.nextToken().charAt(0);

	private static void openFile() throws IOException {
		if (local) {
			String inp = "C:/Users/ztrong/Desktop/AndroidStudioProjects/Java/src/main/java/input.txt";
			String out = "C:/Users/ztrong/Desktop/AndroidStudioProjects/Java/src/main/java/output.txt";
			br = new BufferedReader(new InputStreamReader(new FileInputStream(inp)));
			output = new PrintWriter(new FileOutputStream(out));
		} else {
			br = new BufferedReader(new InputStreamReader(System.in));
			output = new PrintWriter(System.out);
		}
	}

	private static String _next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	private static int nextInt() {
		return Integer.parseInt(_next());
	}

	private static long nextLong() {
		return Long.parseLong(_next());
	}

	private static double nextDouble() {
		return Double.parseDouble(_next());
	}

	private static String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	private static final int maxN = (int) 1e5 + 5;
	private static final int maxM = (int) 1e6 + 5;
	private static final int inf = (int) 1e9 + 7;

	private static int N;
	private static int[] a = new int[maxN];
	private static int cnt1, cnt2, cnt4;

	private static void init() {

	}

	private static void enter() throws IOException {
		N = nextInt();
		for (int i = 1; i <= N; ++i) {
			int x = nextInt();
			if (x % 4 == 0) {
				++cnt4;
			}
			else if (x % 2 == 0) {
				++cnt2;
			}
			else {
				++cnt1;
			}
		}
	}

	private static void print(boolean ok) {
		if (ok) {
			output.println("Yes");
		}
		else {
			output.println("No");
		}
	}

	private static void solve() throws IOException {
		if (cnt2 == 0) {
			print(cnt4 + 1 >= cnt1);
		}
		else {
			print(cnt4 >= cnt1);
		}
	}

	public static void main(String[] args) throws IOException {
		openFile();
		init();
		enter();
		solve();
		output.close();
	}
}