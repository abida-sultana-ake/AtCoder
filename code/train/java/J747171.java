import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) {
		// 入力
		final int  h1, w1, h2, w2;	
		try(Scanner scan = new Scanner(System.in)) {
			h1 = scan.nextInt();	// 1≦H1,W1,H2,W2≦10^5
			w1 = scan.nextInt();
			h2 = scan.nextInt();
			w2 = scan.nextInt();
		}
		
		// 共通の値が一つでもあればいい
		boolean result = h1 == h2 || h1 == w2 || w1 == h2 || w1 == w2;
		
		out.println(result ? "YES" : "NO");
		out.flush();
	}

}
