import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Solver solver = new Solver();
		solver.init();
		solver.readHead(in.readLine());
		// for (; solver.hasNext();) {
		// solver.readBody(in.readLine());
		// }
	}
}

class Solver {
	int N;
	int cnt;

	public void init() {
		N = 0;
		cnt = 0;
	}

	public void readHead(String str) {
		String[] strArr = str.split(" ");
		// N = Integer.parseInt(strArr[0]);
		// System.out.println(N);
		int x = Integer.parseInt(strArr[0]);
		int a = Integer.parseInt(strArr[1]);
		int b = Integer.parseInt(strArr[2]);
		if (a >= b) {
			System.out.println("delicious");
		} else if (a + x >= b) {
			System.out.println("safe");
		} else {
			System.out.println("dangerous");
		}
	}

	public boolean hasNext() {
		return cnt < N;
	}

	public void readBody(String str) {
		// System.out.println(str);
		cnt++;
	}
}
