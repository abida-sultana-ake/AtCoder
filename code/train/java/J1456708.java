
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
	int min = Integer.min(A, B);
	System.out.println(C / min);
    }
}
