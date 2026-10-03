import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Solver solver = new Solver();
		solver.init();
		solver.readHead(in.readLine());
		solver.readVal(in.readLine());
		solver.solve();
	}
}

class Solver {
	int N;
	int A;
	int B;
	long[] Val;

	public void init() {
		N = 0;
		A = 0;
		B = 0;
	}

	public void readHead(String str) {
		String[] strArr = str.split(" ");
		N = Integer.parseInt(strArr[0]);
		A = Integer.parseInt(strArr[1]);
		B = Integer.parseInt(strArr[2]);
		Val = new long[N];

		// System.out.println(N);
	}

	public void readVal(String str) {
		// System.out.println(str);
		String[] strArr = str.split(" ");
		for (int i = 0; i < N; i++)
			Val[i] = Long.parseLong(strArr[i]);
	}

	public void solve() {
		TreeMap<Long, Integer> items = new TreeMap<Long, Integer>(new Comparator<Long>() {
			public int compare(Long m, Long n) {
				return ((Long) m).compareTo(n) * -1;
			}
		});
		for (int i = 0; i < N; i++) {
			// System.out.println(Val[i]);
			if (items.containsKey(Val[i]))
				items.put(Val[i], items.get(Val[i]) + 1);
			else
				items.put(Val[i], 1);
		}
		TreeMap<Long, Integer> select = new TreeMap<Long, Integer>();
		int a = 0;
		for (long key : items.keySet()) {
			// System.out.println(key + " " + items.get(key));
			if (A - a <= items.get(key)) {
				int s = A - a;
				select.put(key, s);
				break;
			} else {
				select.put(key, items.get(key));
				a += items.get(key);
			}
		}
		long sum = 0;
		for (long key : select.keySet()) {
			// System.out.println(key + " " + select.get(key));
			sum += (key * select.get(key));
		}
		System.out.printf("%.6f\n", (double) sum / (double) A);

		long numPat = 0;
		if (select.size() == 1) {
			long key = select.firstKey();
			for (int i = A; i <= B && i <= items.get(key); i++) {
				// System.out.println(i + " " + combination(items.get(key), i));
				numPat += combination(items.get(key), i);
			}
		} else {
			for (long key : select.keySet()) {
				numPat = combination(items.get(key), select.get(key));
				break;
			}
		}
		System.out.println(numPat);
	}

	private long combination(int n, int k) {
		HashMap<Integer, Integer> factorization = new HashMap<Integer, Integer>();

		// 分母を素因数分解
		for (int i = k; i > 1; i--) {
			int d = 2;
			for (int j = i; j > 1;) {
				if (j % d == 0) {
					if (factorization.containsKey(d))
						factorization.put(d, factorization.get(d) - 1);
					else
						factorization.put(d, -1);
					j /= d;
				} else {
					d++;
				}
			}
		}

		// 分子を素因数分解
		for (int i = n; i > n - k; i--) {
			int d = 2;
			for (int j = i; j > 1;) {
				if (j % d == 0) {
					if (factorization.containsKey(d))
						factorization.put(d, factorization.get(d) + 1);
					else
						factorization.put(d, 1);
					j /= d;
				} else {
					d++;
				}
			}
		}

		// 解答生成
		long ans = 1L;
		for (int d : factorization.keySet()) {
			for (int i = 0; i < factorization.get(d); i++) {
				ans *= d;
			}
		}
		return ans;
	}

}
