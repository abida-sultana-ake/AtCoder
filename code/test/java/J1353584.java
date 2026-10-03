import java.util.*;
import java.io.*;

public class Main {
    static Scanner in;
    static PrintWriter out;
    static void solve() {
	int N = in.nextInt();
	int T = in.nextInt();
	int answer = T;
	int[] A = new int[N];
	for (int i = 0; i < A.length; i++) {
	    A[i] = in.nextInt();
	    if (i > 0) {
		int d = A[i] - A[i - 1];
		if (d >= T) {
		    answer += T;
		} else {
		    answer += d;
		}
	    }
	}
	out.println(answer);
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