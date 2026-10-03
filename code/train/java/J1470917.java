
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Main m = new Main();
	m.answer();
    }

    private Scanner scan = new Scanner(System.in);
    private final int A;
    private final int B;
    private final int C;

    public Main() {
	A = Integer.parseInt(scan.next());
	B = Integer.parseInt(scan.next());
	C = Integer.parseInt(scan.next());

	scan.close();
    }

    public final void answer() {
	boolean possible = false;
	for (int x = 1; x <= B; x++) {
	    if(A*x % B == C) {
		possible = true;
		break;
	    }
	}
	System.out.println(possible ? "YES" : "NO");
    }
}
