import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	static Scanner in;
	static PrintWriter out;

	static void solve() {
		int N = in.nextInt();
		int[] a = new int[N];
		for(int i = 0; i < N; i++) {
			a[i] = in.nextInt();
		}
		int cnt4 = 0, cnt2 = 0;
		for(int t : a) {
			if(t % 4 == 0) {
				cnt4++;
			} else if(t % 2 == 0) {
				cnt2++;
			}			
		}
		if (cnt2 == N) {
			out.println("Yes");
			return;
		}
		N = N - (cnt2 / 2) * 2;
		float t = (N  - 1) / 2.0f;
		if (t <= cnt4) {
			out.println("Yes");
			return;
		}
		out.println("No");
		return;
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
