
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	int N = Integer.parseInt(scan.next());
	int K = Integer.parseInt(scan.next());
	int X = Integer.parseInt(scan.next());
	int Y = Integer.parseInt(scan.next());

	int cost = (N <= K ? N * X : K*X + (N-K)*Y);
	System.out.println(cost);
	scan.close();
    }
}
