import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        run(sc, out);
        out.flush();
        out.close();
        sc.close();
    }

    static void run(Scanner sc, PrintWriter out) {
        int A = sc.nextInt();
        int B= sc.nextInt();
        int N= sc.nextInt();
        long ab = lcm(A, B);
        long ans = 0;
        while (ans<N) {
            ans += ab;
        }
        out.println(ans);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / (a > b ? gcd(a, b) : gcd(b, a));
    }
}
