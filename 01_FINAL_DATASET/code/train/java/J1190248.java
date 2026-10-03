import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// 街
		int N = Integer.parseInt(scn.next());
		// 徒歩疲労
		long A = Long.parseLong(scn.next());
		// テレポート疲労
		long B = Long.parseLong(scn.next());

		long[] towns = new long[N];

		for (int i = 0; i < N; i++) {
			towns[i] = Long.parseLong(scn.next());
		}

		long sum = 0;
		for (int i = 1; i < N; i++) {
			long toho = (towns[i] - towns[i - 1]) * A;
			if (toho > B) {
				sum += B;
			} else {
				sum += toho;
			}
		}

		System.out.println(sum);

	}

}