import java.util.Arrays;
import java.util.Scanner;

public class Main {
	class C implements Comparable<C>{
		int a, b;

		C(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(C o) {
			return o.a - this.a;
		}
	}

	void run() {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		C[] a = new C[n];
		for (int i = 0; i < n; i++) {
			a[i] = new C(sc.nextInt(), i + 1);
		}
		Arrays.sort(a);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(a[i].b + "\n");
		}
		System.out.print(sb);
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
