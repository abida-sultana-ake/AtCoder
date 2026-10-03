import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            solve(in);
        }
    }

    private static void solve(Scanner in) {
        int N = in.nextInt(), M = in.nextInt();
        int[] l = new int[N + 1], r = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            l[i] = in.nextInt();// 1 <= l <= r <= M
            r[i] = in.nextInt();
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] nByLen = new List[M + 1];
        for (int n = 1; n < N + 1; n++) {
            int len = r[n] - l[n] + 1;
            if (nByLen[len] == null) {
                nByLen[len] = new ArrayList<>();
            }
            nByLen[len].add(n);
        }

        int accum = N;

        Fenwick F = new Fenwick(M);
        for (int d = 1; d < M + 1; d++) {
            int sum = accum;
            for (int e = d; e < M + 1; e += d) {
                sum += F.accum(e);
            }
            System.out.println(sum);
            if (nByLen[d] != null) {
                accum -= nByLen[d].size();
                for (int i : nByLen[d]) {
                    F.add(l[i], 1);
                    F.add(r[i] + 1, -1);
                }
            }
        }
    }
}

class Fenwick {
    private final int[] fenwick;

    public Fenwick(int n) {
        fenwick = new int[n + 1];
    }

    public int accum(int i) {
        int sum = 0;
        for (; i >= 0; i = (i & (i + 1)) - 1) {
            sum += fenwick[i];
        }
        return sum;
    }

    public int sum(int begin, int end) {
        return accum(end) - accum(begin - 1);
    }

    public void add(int i, int a) {
        for (; i < fenwick.length; i = i | i + 1) {
            fenwick[i] += a;
        }
    }

    @Override
    public String toString() {
        int N = fenwick.length;
        long[] raw = new long[N];
        long[] acc = new long[N];
        for (int i = 1; i < N; i++) {
            acc[i] = accum(i);
            raw[i] = acc[i] - acc[i - 1];
        }
        StringBuilder s = new StringBuilder();
        s.append("Fenwick [\n");
        s.append(" fenwick=" + Arrays.toString(fenwick) + "\n");
        s.append(" accum  =" + Arrays.toString(acc) + "\n");
        s.append(" raw    =" + Arrays.toString(raw) + "\n]");
        return s.toString();
    }
}