
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Main m = new Main();
	m.answer();
    }

    private Scanner scan = new Scanner(System.in);
    private final int x;
    private final int y;

    public Main() {
	x = Integer.parseInt(scan.next());
	y = Integer.parseInt(scan.next());

	scan.close();
    }

    public final void answer() {
	System.out.println(y > x ? "Better" : "Worse");
    }
}
