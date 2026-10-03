import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String args[]) throws IOException {
		@SuppressWarnings("resource")
		Scanner cin = new Scanner(System.in);
		ArrayList<String> inLines = new ArrayList<String>();
		for (; cin.hasNext();) {
			inLines.add(cin.nextLine());
		}
		Solver solver = new Solver();
		solver.solve(inLines);
	}
}

class Solver {

	public void solve(ArrayList<String> inLines) {
		String[] strArr = inLines.get(0).split(" ");
		long N = Long.parseLong(strArr[0]);
		long M = Long.parseLong(strArr[1]);

		long ans = 0;
		if (N * 2 <= M) {
			ans = N;
			ans += (M - 2 * N) / 4;
		} else {
			ans = M / 2;
			ans += (M - 2 * ans) / 4;
		}
		System.out.println(ans);
	}
}
