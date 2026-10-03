import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
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
        public void solve(int testNumber, Scanner sn, PrintWriter out) {
            int n = sn.nextInt();
            LinkedList<Integer> lista = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                int x = sn.nextInt();
                if (i % 2 != 0) {
                    lista.addLast(x);
                } else {
                    lista.addFirst(x);
                }
            }
            if (n % 2 == 0) {
                for (int i = 0; lista.size() != 0; i++) {
                    out.print(lista.pollFirst());
                    out.print(" ");
                }
            } else {
                for (int i = 0; lista.size() != 0; i++) {
                    out.print(lista.pollLast());
                    out.print(" ");
                }

            }

            out.println();
        }

    }
}

