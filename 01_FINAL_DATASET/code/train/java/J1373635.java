import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1行、2つ(複数)数字
		String[] ss0 = br.readLine().trim().split(" ", 0);
		long X = Long.parseLong(ss0[0]);
		long A = Long.parseLong(ss0[1]);
		long B = Long.parseLong(ss0[2]);

		if(A-B>=0){ System.out.println("delicious"); return; }
		if(B-A>X){ System.out.println("dangerous"); return; }

		System.out.println("safe"); return;
	}
	//-----------------------------------------------------------------
	// Debug.Print
	static void dp(String s) {
		System.out.println(s);
	}
	static void dp(StringBuilder s) { dp(s.toString()); }
	static void dp(int i) { dp(String.valueOf(i)); }
	static void dp(long i) { dp(String.valueOf(i)); }
}
