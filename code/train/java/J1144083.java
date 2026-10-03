import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        run(sc, out);
        out.flush();
    }

    static void run(Scanner sc, PrintWriter out) {
        int N = sc.nextInt();
        String maxS = "";
        int maxP = 0;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            String S = sc.next();
            int P = sc.nextInt();
            if (P > maxP) {
                maxS = S;
                maxP = P;
            }
            sum += P;
        }
        out.println(maxP > sum / 2 ? maxS : "atcoder");
    }
}
