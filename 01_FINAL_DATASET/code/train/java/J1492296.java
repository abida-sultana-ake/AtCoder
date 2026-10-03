import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{
	static Scanner in;
	static PrintWriter out;
	static void solve()
	{
		int m = in.nextInt();
		int n = in.nextInt();
		int A = (m - 1) * (n - 1);
		out.print(A);
	}
	public static void main(String[] args)
	{
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.flush();
		out.close();
		in.close();
	}
}