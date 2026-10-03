import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	static Scanner in;
	static PrintWriter out;

	static void solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		out.println((n-1)*(m-1));
	}

	public static void main(String[] args) {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.flush();
		out.close();
		in.close();
	}

}
