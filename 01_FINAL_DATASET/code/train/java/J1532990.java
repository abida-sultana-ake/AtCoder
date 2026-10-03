import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.SocketPermission;
import java.util.*;

public class Main {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    final int MOD = 1000000007;

    void run() {
        int N = in.nextInt();
        String s1 = in.next(), s2 = in.next();

        // 1 : Red, 2 : Blue, 3 : Green
        int[][] prev = new int[4][4];
        int[][] next = new int[4][4];
        prev[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int c1 = 0; c1 <= 3; c1++) for (int c2 = 0; c2 <= 3; c2++) {
                next[c1][c2] = 0;
            }

            for (int c1 = 0; c1 <= 3; c1++) for (int c2 = 0; c2 <= 3; c2++) {
                for (int nc1 = 1; nc1 <= 3; nc1++) for (int nc2 = 1; nc2 <= 3; nc2++) {
                    if (c1 == nc1 || c2 == nc2) continue;
                    if (i != N - 1 && s1.charAt(i) == s1.charAt(i + 1)) {
                        // Horizontal blocks
                        if (nc1 == nc2) continue;
                    } else {
                        // Vertical block
                        if (nc1 != nc2) continue;
                    }
                    next[nc1][nc2] = (next[nc1][nc2] + prev[c1][c2]) % MOD;
                }
            }
            if (i != N - 1 && s1.charAt(i) == s1.charAt(i + 1)) {
                // Horizontal blocks
                i++;
            } else {
                // Vertical block
            }

            // swap
            int[][] tmp = prev; prev = next; next = tmp;
        }

        int res = 0;
        for (int c1 = 1; c1 <= 3; c1++) {
            for (int c2 = 1; c2 <= 3; c2++) {
                if (s1.charAt(N - 1) == s2.charAt(N - 1)) {
                    if (c1 != c2) continue;
                } else {
                    if (c1 == c2) continue;
                }
                res = (res + prev[c1][c2]) % MOD;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        new Main().run();
    }

    class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
            //stream = new FileInputStream(new File("dec.in"));

        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextIntArray(int n) {
            return nextIntArray(n, 0);
        }

        int[] nextIntArray(int n, int margin) {
            int[] array = new int[n + margin];
            for (int i = 0; i < n; i++)
                array[i + margin] = nextInt();

            return array;
        }

        int[][] nextIntMap(int n, int m) {
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = in.nextIntArray(m);
            }
            return map;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        long[] nextLongArray(int n) {
            return nextLongArray(n, 0);
        }

        long[] nextLongArray(int n, int margin) {
            long[] array = new long[n + margin];
            for (int i = 0; i < n; i++)
                array[i + margin] = nextLong();

            return array;
        }

        long[][] nextLongMap(int n, int m) {
            long[][] map = new long[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = in.nextLongArray(m);
            }
            return map;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        double[] nextDoubleArray(int n) {
            return nextDoubleArray(n, 0);
        }

        double[] nextDoubleArray(int n, int margin) {
            double[] array = new double[n + margin];
            for (int i = 0; i < n; i++)
                array[i + margin] = nextDouble();

            return array;
        }

        double[][] nextDoubleMap(int n, int m) {
            double[][] map = new double[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = in.nextDoubleArray(m);
            }
            return map;
        }

        String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        String[] nextStringArray(int n) {
            String[] array = new String[n];
            for (int i = 0; i < n; i++)
                array[i] = next();

            return array;
        }

        String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
}
