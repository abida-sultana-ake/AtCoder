import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		ABC50B p = new ABC50B();
		p.solve();
	}
}

class ABC50B {
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] t = new int[N];
		long sum = 0;
		for (int i = 0; i < N; i++) {
			t[i] = Integer.parseInt(input[i]);
			sum += t[i];
		}
		int M = Integer.parseInt(br.readLine());
		long[] ans = new long[M];
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int pi = Integer.parseInt(input[0]);
			int xi = Integer.parseInt(input[1]);
			ans[i] = sum - t[pi - 1] + xi;
		}

		for (int i = 0; i < M; i++) {
			System.out.println(ans[i]);
		}
	}
}

class ABC50A {
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long a = Long.parseLong(input[0]);
		long b = Long.parseLong(input[2]);
		if (input[1].equals("+"))
			System.out.println((a + b));
		else
			System.out.println((a - b));
	}
}