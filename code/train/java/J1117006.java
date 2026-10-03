import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //while(true)
            solve(in);
        }
    }

    static final char o = 'o', x = 'x', S = 'S', W = 'W';

    private static void solve(Scanner in) {
        int N = in.nextInt();
        char[] s = in.next().toCharArray();
        char[][] dp = new char[N + 1][4];
        dp[0][0] = S;
        dp[0][1] = S;
        dp[0][2] = W;
        dp[0][3] = W;
        dp[1][0] = S;
        dp[1][1] = W;
        dp[1][2] = S;
        dp[1][3] = W;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                if (s[i] == o) {
                    if (dp[i][j] == S) {
                        dp[i + 1][j] = dp[i - 1][j];
                    } else {
                        dp[i + 1][j] = flip(dp[i - 1][j]);
                    }
                } else {
                    if (dp[i][j] == S) {
                        dp[i + 1][j] = flip(dp[i - 1][j]);
                    } else {
                        dp[i + 1][j] = dp[i - 1][j];
                    }
                }
            }
        }
        for (int j = 0; j < 4; j++) {
            if (dp[0][j] == dp[N][j]) {
                boolean ok = true;
                if (s[0] == o && dp[0][j] == S) {
                    ok = dp[N - 1][j] == dp[1][j];
                } else if (s[0] == o && dp[0][j] == W) {
                    ok = dp[N - 1][j] != dp[1][j];
                } else if (s[0] == x && dp[0][j] == S) {
                    ok = dp[N - 1][j] != dp[1][j];
                } else {
                    ok = dp[N - 1][j] == dp[1][j];
                }
                if (!ok) {
                    continue;
                }
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    ans.append(dp[i][j]);
                }
                System.out.println(ans);
                return;
            }
        }
        System.out.println("-1");
    }

    private static char flip(char c) {
        return c == S ? W : S;
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