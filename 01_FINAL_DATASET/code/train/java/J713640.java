import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;

public class Main {

	public static void main(String args[]) {
		new Main().solve();
	}

	int modulo = 1000000007;

	HashMap<Integer, HashSet<Integer>> islands;
	long white[];
	long black[];

	void solve() {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		islands = new HashMap<Integer, HashSet<Integer>>();
		white = new long[N];
		black = new long[N];

		for (int i = 0; i < N; i++) {
			islands.put(i, new HashSet<Integer>());
		}

		for (int i = 0; i < N-1; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			islands.get(a-1).add(b-1);
			islands.get(b-1).add(a-1);
		}

		long num = dp(0, -10);

		System.out.println(num % modulo);

	}

	long dp(int id, int parent) {
		
		white[id] = 1;
		black[id] = 1;

		if (id == 0 || islands.get(id).size() != 1) {
			for (int i : islands.get(id)) {
				if (i == parent) continue;
				dp(i, id);
				white[id] = (white[id] * (white[i] + black[i])) % modulo;
				black[id] = (black[id] * white[i]) % modulo;
			}
		}

		return white[id] + black[id];

	}
}
