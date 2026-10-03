
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Main m = new Main();
	m.answer();
    }

    private Scanner scan = new Scanner(System.in);
    private int N;
    private int[][] A;

    public Main() {
	N = Integer.parseInt(scan.next());
	A = new int[N][N];
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		int a = Integer.parseInt(scan.next());
		A[i][j] = a;
	    }
	}
	scan.close();
    }

    public final void answer() {

	int[][] dest = new int[N][];
	for (int i = 0; i < N; i++) {
	    dest[i] = Arrays.copyOf(A[i], N);
	}

	for (int k = 0; k < N; k++) {
	    for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
		    dest[i][j] = Integer.min(dest[i][j], dest[i][k] + dest[k][j]);
		}
	    }
	}

	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		if(dest[i][j] != A[i][j]) {
		    System.out.println(-1);
		    return;
		}
	    }
	}

	long result = 0;
	for (int i = 0; i < N; i++) {
	    for (int j = i+1; j < N; j++) {
		boolean flag = true;
		for (int k = 0; k < N; k++) {
		    if(i == k || j == k) continue;
		    if(dest[i][j] == A[i][k] + A[k][j]) {
			flag = false;
			break;
		    }
		}
		if(flag) result = result + dest[i][j];
	    }
	}
	System.out.println(result);
    }
}
