
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Main m = new Main();
	m.answer();
    }

    private Scanner scan = new Scanner(System.in);
    private final int N;
    private final int[] A;

    public Main() {
	N = Integer.parseInt(scan.next());
	A = new int[N];
	
	for (int i = 0; i < N; i++) {
	    A[i] = Integer.parseInt(scan.next());
	}

	scan.close();
    }

    public final void answer() {
	Arrays.sort(A);

	int h = 0;
	int w = 0;
	for (int i = N-1; i > 0; i--) {
	    if(A[i] == A[i-1]) {
		if(h == 0) {
		    h = A[i];
		    i--;
		} else if(w == 0) {
		    w = A[i];
		    break;
		}
	    }
	}
	System.out.println((long)h * w);
    }
}
