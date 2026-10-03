import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author bcools
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
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] scores = new int[n];
            int sum = 0;
            for (int i = 0; i < n; ++i) {
                scores[i] = in.nextInt();
                sum += scores[i];
            }
            if (sum % 10 != 0) {
                out.println(sum);
            } else {
                Arrays.sort(scores);
                int index = 0;
                while (index < scores.length && sum % 10 == 0) {
                    if (scores[index] % 10 == 0) {
                        index++;
                    } else {
                        sum -= scores[index];
                        index++;
                    }
                }
                out.println((sum % 10 == 0) ? 0 : sum);
            }
        }

    }
}

