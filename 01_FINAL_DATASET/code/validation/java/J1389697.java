import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Aeroui
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public static int MOD = 1_000_000_007;
        public long[] fact = new long[100005];

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int M = in.nextInt();

            init();
            if (Math.abs(N - M) >= 2)
                out.println(0);
            else if (Math.abs(N - M) == 1)
                out.println((fact[N] * fact[M]) % MOD);
            else
                out.println((((fact[N] * fact[M]) % MOD) * 2) % MOD);
        }

        public void init() {
            fact[0] = 1;
            for (int i = 1; i < fact.length; ++i)
                fact[i] = (fact[i - 1] * i) % MOD;
        }

    }
}

