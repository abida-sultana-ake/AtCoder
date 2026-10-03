
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] T = new int[N];
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			T[i] = in.nextInt();
			A[i] = in.nextInt();
		}
		in.close();
		long t, a, multiplyer;
		t = T[0];
		a = A[0];

		for (int i = 1; i < N; i++) {
			multiplyer = calcMultiplyer(t, a, T[i], A[i]);
			t = multiplyer * T[i];
			a = multiplyer * A[i];
		}
		System.out.println((t + a));
	}

	public static long calcMultiplyer(long a, long b, long ratio_a, long ratio_b) {
		long ma, mb;
		ma = a / ratio_a;
		mb = b / ratio_b;
		if (a % ratio_a != 0)
			ma++;
		if (b % ratio_b != 0)
			mb++;
		return Math.max(ma, mb);
	}

}
