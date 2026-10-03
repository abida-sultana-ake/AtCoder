import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            solve(in);
        }
    }

    private static void solve(Scanner in) {
        int N = in.nextInt(), Ma = in.nextInt(), Mb = in.nextInt();
        int[] A = new int[N], B = new int[N], C = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
            B[i] = in.nextInt();
            C[i] = in.nextInt();
        }
        int MAX = Math.max(sum(A), sum(B)) + 1;
        int NA = sum(C) + 1;
        int[][][] dp = new int[N + 1][MAX][MAX];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < MAX; j++) {
                for (int k = 0; k < MAX; k++) {
                    dp[i][j][k] = NA;
                }
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < MAX; j++) {
                for (int k = 0; k < MAX; k++) {
                    if (dp[i + 1][j][k] > dp[i][j][k]) {
                        dp[i + 1][j][k] = dp[i][j][k];
                    }
                    if (j + A[i] < MAX && k + B[i] < MAX) {
                        if (dp[i + 1][j + A[i]][k + B[i]] > dp[i][j][k] + C[i]) {
                            dp[i + 1][j + A[i]][k + B[i]] = dp[i][j][k] + C[i];
                        }
                    }
                }
            }
        }
        int minc = NA;
        for (int i = 0; i < N + 1; i++) {
            for (int j = 1; j < MAX; j++) {
                for (int k = 1; k < MAX; k++) {
                    if (j * Mb == k * Ma) {
                        minc = minc < dp[i][j][k] ? minc : dp[i][j][k];
                    }
                }
            }
        }
        System.out.println(minc == NA ? -1 : minc);
    }

    private static int sum(int[] a) {
        int sum = 0;
        for (int n : a)
            sum += n;
        return sum;
    }
}

class Scanner implements Closeable {
    private final InputStream stream;
    private final byte[] buf = new byte[1024];
    private int cur;
    private int num;

    Scanner(InputStream stream) {
        this.stream = stream;
    }

    int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    int nextInt() {
        return (int) nextLong();
    }

    long nextLong() {
        int c = read();
        while (isdel(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long l = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            l *= 10;
            l += c - '0';
            c = read();
        } while (!isdel(c));
        return l * sgn;
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String next() {
        int c = read();
        while (isdel(c))
            c = read();
        StringBuilder s = new StringBuilder();
        do {
            s.appendCodePoint(c);
            c = read();
        } while (!isdel(c));
        return s.toString();
    }

    private int read() {
        if (num == -1)
            throw new InputMismatchException();
        if (cur >= num) {
            cur = 0;
            try {
                num = stream.read(buf);
            } catch (Exception e) {
                throw new InputMismatchException();
            }
            if (num <= 0)
                return -1;
        }
        return buf[cur++];
    }

    private boolean isdel(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    @Override
    public void close() {
        try {
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}