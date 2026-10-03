import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Solver solver = new Solver();
		solver.init();
		solver.readHead(in.readLine());
		for (; solver.hasNext();) {
			solver.readBody(in.readLine());
		}
		solver.solve();
	}
}

class Solver {
	int N;
	long K;
	int cnt;
	TreeMap<Integer, Long> Arr;

	public void init() {
		N = 0;
		cnt = 0;
	}

	public void readHead(String str) {
		String[] strArr = str.split(" ");
		// N = Integer.parseInt(strArr[0]);
		// System.out.println(N);
		N = Integer.parseInt(strArr[0]);
		K = Long.parseLong(strArr[1]);
		Arr = new TreeMap<Integer, Long>();
	}

	public boolean hasNext() {
		return cnt < N;
	}

	public void readBody(String str) {
		String[] strArr = str.split(" ");
		int a = Integer.parseInt(strArr[0]);
		int b = Integer.parseInt(strArr[1]);
		if (Arr.containsKey(a))
			Arr.put(a, Arr.get(a) + b);
		else
			Arr.put(a, (long) b);
		// System.out.println(str);
		cnt++;
	}

	public void solve() {
		long n = 0;
		for (int key : Arr.keySet()) {
			n += Arr.get(key);
			if (n >= K) {
				System.out.println(key);
				break;
			}
		}
	}
}
