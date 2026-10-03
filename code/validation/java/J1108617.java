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
		int N = Integer.parseInt(inLines.get(0));
		String str = inLines.get(1);
		int maxX = 0;
		int x = 0;
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'I')
				x++;
			else if (str.charAt(i) == 'D')
				x -= 1;
			if (x > maxX)
				maxX = x;
		}
		System.out.println(maxX);
	}
}
