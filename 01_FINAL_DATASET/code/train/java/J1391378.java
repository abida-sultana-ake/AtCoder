
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	int a = Integer.parseInt(scan.next());
	int b = Integer.parseInt(scan.next());
	int c = Integer.parseInt(scan.next());
	    
	int ab = a + b;
	int bc = b + c;
	int ca = c + a;

	System.out.println(min(ab, min(bc, ca)));
	scan.close();
    }

    public static int min(int x, int y) {
	return x < y ? x : y;
    }
}
