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
        int X = sc.nextInt();
        int Y = sc.nextInt();
        out.println(X<Y ? "Better" : "Worse");
    }
}
