import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        run(sc, out);
        out.flush();
    }

    static void run(Scanner sc, PrintWriter out) {
        int N = sc.nextInt();
        out.println(N%2==0 ? N-1 : N+1);
    }
}
