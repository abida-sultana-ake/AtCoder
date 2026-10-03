import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.PriorityQueue;
import java.util.Collection;
import java.util.Scanner;
import java.util.Queue;
import java.util.Comparator;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author acesine
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            List<Long> a = new ArrayList<>();
            for (int i = 0; i < 3 * N; i++) {
                a.add(in.nextLong());
            }
            Queue<Long> head = new PriorityQueue<>(Comparator.naturalOrder());
            Queue<Long> tail = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < N; i++) {
                head.add(a.get(i));
                tail.add(a.get(a.size() - 1 - i));
            }
            assert head.size() == N;
            assert tail.size() == N;
            long[] l = new long[N + 1];
            long[] r = new long[N + 1];
            l[0] = head.parallelStream().mapToLong(Long::longValue).sum();
            r[N] = tail.parallelStream().mapToLong(Long::longValue).sum();
            for (int i = 1; i <= N; i++) {
                if (a.get(N + i - 1) > head.peek()) {
                    long t = head.poll();
                    head.add(a.get(N + i - 1));
                    l[i] = l[i - 1] + a.get(N + i - 1) - t;
                } else {
                    l[i] = l[i - 1];
                }
                if (a.get(2 * N - i) < tail.peek()) {
                    long t = tail.poll();
                    tail.add(a.get(2 * N - i));
                    r[N - i] = r[N - i + 1] + a.get(2 * N - i) - t;
                } else {
                    r[N - i] = r[N - i + 1];
                }
                assert tail.size() == head.size();
            }
            long max = l[0] - r[0];
            for (int i = 1; i <= N; i++) {
                if (l[i] - r[i] > max) max = l[i] - r[i];
            }
            out.println(max);
        }

    }
}

