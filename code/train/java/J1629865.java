import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();

		final int MAX_VALUE = 1_000_000_000;

		int[][] dist = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == j) dist[i][j] = 0;
				else dist[i][j] = MAX_VALUE;
			}
		}

		List<Integer> towns = new ArrayList<Integer>();
		for (int i = 0; i < r; i++) {
			towns.add(sc.nextInt());
		}

		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();

			dist[from][to] = dist[to][from] = cost;
		}

		sc.close();

		for (int k = 0; k < n + 1; k++) {
			for (int i = 0; i < n + 1; i++) {
				for (int j = 0; j < n + 1; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		List<List<Integer>> perm = permutations(r, towns);
		int min = MAX_VALUE;
		for (List<Integer> item : perm) {
			int temp = 0;
			for (int i = 1; i < item.size(); i++) {
				temp += dist[item.get(i - 1)][item.get(i)];
			}
			if (min > temp) min = temp;
		}
		System.out.println(min);

	}

	private static List<List<Integer>> permutations(int n, List<Integer> list) {
		if (n <= 0) {
			return Arrays.asList(Arrays.asList());
		}
		else {
			List<List<Integer>> result = new ArrayList<>();
			for (Integer head : list) {
				for (List<Integer> tail : permutations(n - 1, remove(head, list))) {
					result.add(cons(head, tail));
				}
			}
			return result;
		}
	}

	private static List<Integer> cons(Integer head, List<Integer> tail) {
		List<Integer> list = new ArrayList<>();
		list.add(head);
		list.addAll(tail);
		return list;
	}

	private static List<Integer> remove(Integer e, List<Integer> list) {
		List<Integer> newList = new ArrayList<>(list);
		newList.remove(e);
		return newList;
	}
}
