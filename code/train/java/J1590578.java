
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Main m = new Main();
	m.answer();
    }

    private Scanner scan = new Scanner(System.in);
    private final String s;

    public Main() {
	s = scan.next();

	scan.close();
    }

    public final void answer() {
	StringBuilder ans = new StringBuilder();

	for (int i = 0; i < s.length(); i++) {
	    if(i % 2 == 0)
		ans.append(s.charAt(i));
	}

	System.out.println(ans.toString());
    }
}
