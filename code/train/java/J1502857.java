import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	static HashMap<Integer, TreeSet<Integer>> dp = new HashMap<Integer, TreeSet<Integer>>();
	static int n;
	static int max = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		for (int i = 0; i < n - 1; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();

			if (!dp.containsKey(a)) {
				TreeSet<Integer> list = new TreeSet<>();
				list.add(b);
				dp.put(a, list);
			} else {
				dp.get(a).add(b);
			}

			if (!dp.containsKey(b)) {
				TreeSet<Integer> list = new TreeSet<>();
				list.add(a);
				dp.put(b, list);
			} else {
				dp.get(b).add(a);
			}

		}
		int[] f = bfs(1);
		int[] s = bfs(n);

		int ansF = 0;
		int ansS = 0;
		for (int i = 1; i <= n; i++) {
			if (f[i] <= s[i]) {
				ansF++;

			} else {
				ansS++;

			}
		}

		if (ansF > ansS) {
			System.out.println("Fennec");
		} else {
			System.out.println("Snuke");
		}

	}

	public static int[] bfs(int u) {
		int[] ans = new int[n + 1];
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(u);
		Arrays.fill(ans, max);
		ans[u] = 0;
		Iterator<Integer> it = null;

		while (!q.isEmpty()) {
			// 調べるノードを取り出す
			int v = q.poll();
			it = dp.get(v).iterator();
			while (it.hasNext()) {
				int temp = it.next();
				if (ans[temp] == max) {
					ans[temp] = ans[v] + 1;
					q.offer(temp);
				}
			}
		}
		return ans;

	}

}