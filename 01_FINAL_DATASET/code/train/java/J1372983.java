
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	long X = Long.parseLong(scan.next());
	long Y = Long.parseLong(scan.next());

	System.out.println(Math.abs(X-Y) <= 1 ? "Brown" : "Alice");
	scan.close();
    }
}
