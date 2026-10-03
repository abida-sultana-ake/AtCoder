
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static final long MOD = 1000_000_007L;
    private static long[] count = new long[1001];

    public static void main(String[] args) {
	int N = Integer.parseInt(scan.next());
	for (int i = 1; i <= N; i++) {
	    factorization(i);
	}

	long ans = 1;
	for (int i = 2; i <= N; i++) {
	    ans = ans * (count[i]+1) % MOD;
	}

	System.out.println(ans);
	scan.close();
    }

    private static void factorization(int x) {
	for (int i = 2; i*i <= x; i++) {
	    if(x % i == 0) {
		factorization(i);
		factorization(x / i);
		return;
	    }
	}
	count[x]++;
    }
}
