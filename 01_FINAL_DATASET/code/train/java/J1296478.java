import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Solver solver = new Solver();
		solver.init();
		solver.readHead(in.readLine());
		for (; solver.hasNext();) {
			solver.readBody(in.readLine());
		}
		solver.solve();
	}
}

class Solver {
	int N;
	int H;
	int W;
	int cnt;

	public void init() {
		N = 0;
		cnt = 0;
	}

	public void readHead(String str) {
		String[] strArr = str.split(" ");
		// N = Integer.parseInt(strArr[0]);
		// System.out.println(N);

		H = Integer.parseInt(strArr[0]);
		W = Integer.parseInt(strArr[1]);

		for (int i = 0; i < W + 2; i++)
			System.out.print("#");
		System.out.println();

	}

	public boolean hasNext() {
		// return cnt < N;
		return cnt < H;
	}

	public void readBody(String str) {
		// System.out.println(str);
		System.out.print("#");
		System.out.print(str);
		System.out.println("#");
		cnt++;
	}

	public void solve() {
		for (int i = 0; i < W + 2; i++)
			System.out.print("#");
		System.out.println();
	}
}
