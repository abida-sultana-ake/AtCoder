
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Main m = new Main();
	m.answer();
    }

    private Scanner scan = new Scanner(System.in);
    private final int N;
    private final int K;
    private final int[] x;

    public Main() {
	N = Integer.parseInt(scan.next());
	K = Integer.parseInt(scan.next());
	x = new int[N];

	for (int i = 0; i < N; i++) {
	    x[i] = Integer.parseInt(scan.next());
	}

	scan.close();
    }

    public final void answer() {
	int ans = Arrays.stream(x).map(x -> 2 * Integer.min(x, K-x)).sum();
	System.out.println(ans);
    }
}
