import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int N, L, logN;
	static int[] X;
	static int[][] table;

	public static void main(String[] args) {
		N = sc.nextInt();
		X = new int[N];
		for (int i = 0; i < N; ++i) {
			X[i] = Integer.parseInt(sc.next());
		}
		L = sc.nextInt();
		logN = 1;
		while ((1 << logN) < N) {
			logN++;
		}
		build();
		int Q = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; ++i) {
			int A = Integer.parseInt(sc.next()) - 1;
			int B = Integer.parseInt(sc.next()) - 1;
			sb.append(solve(Math.min(A, B), Math.max(A, B)) + "\n");
		}
		System.out.print(sb);
	}

	static void build() {
		table = new int[logN + 1][N];
		for (int i = 0; i < N; ++i) {
			int pos = Arrays.binarySearch(X, X[i] + L);
			if (pos < 0) {
				pos = -pos - 2;
			}
			table[0][i] = pos;
		}
		for (int i = 1; i <= logN; ++i) {
			for (int j = 0; j < N; ++j) {
				int next = table[i - 1][j];
				table[i][j] = table[i - 1][next];
			}
		}
	}

	static int solve(int l, int r) {
		int len = 0;
		for (int i = 0; i <= logN; ++i) {
			if (table[i][l] < r) {
				++len;
			} else {
				break;
			}
		}
		if (len == 0) return 1;
		return (1 << (len - 1)) + solve(table[len - 1][l], r);
	}

}
