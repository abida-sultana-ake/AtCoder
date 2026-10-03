import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Solver solver = new Solver();
		solver.init();
		solver.readHead(in.readLine());
		for (; solver.hasNext();) {
			solver.readBody(in.readLine());
		}
		// solver.solve();
	}
}

class Solver {
	int N;
	int K;
	int cnt;

	public void init() {
		N = 0;
		cnt = 0;
	}

	public void readHead(String str) {
		String[] strArr = str.split(" ");
		N = Integer.parseInt(strArr[0]);
		// System.out.println(N);
		K = Integer.parseInt(strArr[1]);
	}

	public boolean hasNext() {
		// return cnt < N;
		return cnt < 1;
	}

	public void readBody(String str) {
		// System.out.println(str);
		cnt++;
		String[] strArr = str.split(" ");
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int l = Integer.parseInt(strArr[i]);
			nums.add(l);
		}
		nums.sort(new Comparator<Integer>() {
			public int compare(Integer v1, Integer v2) {
				return v2 - v1;
			}
		});
		int sum = 0;
		int cnt = 0;
		for (int i : nums) {
			// System.out.println(i);
			sum += i;
			cnt++;
			if (cnt >= K)
				break;
		}
		System.out.println(sum);
	}

	public void solve() {

	}
}
