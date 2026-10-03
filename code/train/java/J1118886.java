import java.util.*;

class Main {
	static int N;
	static char[] s;
	static int[] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		s = sc.next().toCharArray();
		ans = new int[N];
		int[] animals = new int[N];
		Arrays.fill(animals, -1);
		Arrays.fill(ans, -1);
		dfs(animals, 0);
		if (ans[0] == -1) {
			System.out.println(-1);
		} else {
			for (int i = 0; i < N; ++i) {
				System.out.print(ans[i] == 0 ? 'S' : 'W');
			}
			System.out.println();
		}
	}

	static void dfs(int[] arr, int cur) {
		if (cur == N) {
			for (int i = 0; i < N; ++i)
				ans[i] = arr[i];
			return;
		}
		if (arr[cur] == -1) {
			for (int i = 0; i < 2; ++i) {// 0:羊,1:狼
				arr[cur] = i;
				if ((s[cur] == 'o' && i == 0) || (s[cur] == 'x' && i == 1)) {
					arr[(cur + 1) % N] = 0;
					arr[(cur - 1 + N) % N] = 0;
					dfs(arr, cur + 1);
					arr[(cur + 1) % N] = 1;
					arr[(cur - 1 + N) % N] = 1;
					dfs(arr, cur + 1);
					arr[(cur + 1) % N] = -1;
					arr[(cur - 1 + N) % N] = -1;
				} else {
					arr[(cur + 1) % N] = 1;
					arr[(cur - 1 + N) % N] = 0;
					dfs(arr, cur + 1);
					arr[(cur + 1) % N] = 0;
					arr[(cur - 1 + N) % N] = 1;
					dfs(arr, cur + 1);
					arr[(cur + 1) % N] = -1;
					arr[(cur - 1 + N) % N] = -1;
				}
			}
		} else {
			if ((s[cur] == 'o' && arr[cur] == 0) || (s[cur] == 'x' && arr[cur] == 1)) {
				if (arr[(cur + 1) % N] == -1 || arr[(cur + 1) % N] == arr[(cur - 1 + N) % N]) {
					arr[(cur + 1) % N] = arr[(cur - 1 + N) % N];
					dfs(arr, cur + 1);
					if ((cur + 1) % N != 0)
						arr[(cur + 1) % N] = -1;
				}
			} else {
				if (arr[(cur + 1) % N] == -1 || arr[(cur + 1) % N] == (arr[(cur - 1 + N) % N] ^ 1)) {
					arr[(cur + 1) % N] = arr[(cur - 1 + N) % N] ^ 1;
					dfs(arr, cur + 1);
					if ((cur + 1) % N != 0)
						arr[(cur + 1) % N] = -1;
				}
			}
		}
	}

	static void tr(Object... objects) {
		System.out.println(Arrays.deepToString(objects));
	}
}