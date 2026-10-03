import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            TaskB.vertex[] cities = new TaskB.vertex[n];
            for (int i = 0; i < n; ++i)
                cities[i] = new TaskB.vertex();
            for (int i = 0; i < m; ++i) {
                int a = in.nextInt();
                int b = in.nextInt();
                cities[a - 1].vertices.add(b - 1);
                cities[b - 1].vertices.add(a - 1);
            }
            for (TaskB.vertex i : cities)
                out.println(i.vertices.size());
        }

        static class vertex {
            ArrayList<Integer> vertices = new ArrayList<>();

        }

    }
}

