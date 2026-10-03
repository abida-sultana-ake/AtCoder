
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Main m = new Main();
	m.answer();
    }

    private Scanner scan = new Scanner(System.in);
    private final int n;

    public Main() {
	n = Integer.parseInt(scan.next());

	scan.close();
    }

    public final void answer() {
	System.out.println(n%2 == 0 ? n-1 : n+1);
    }
}
