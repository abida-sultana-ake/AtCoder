
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    MyScanner sc    = new MyScanner();
    Scanner   sc2   = new Scanner(System.in);
    long      start = System.currentTimeMillis();
    long      fin   = System.currentTimeMillis();
    final int MOD   = 1000000007;
    int[]     dx    = { 1, 0, 0, -1 };
    int[]     dy    = { 0, 1, -1, 0 };

    void run() {
        double xs = sc.nextDouble();
        double ys = sc.nextDouble();
        double xt = sc.nextDouble();
        double yt = sc.nextDouble();

        int N = sc.nextInt();
        P[] p = new P[N];
        for (int i = 0; i < N; i++) {
            p[i] = new P(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        }
        double[][] g = new double[N + 2][N + 2];

        for (int i = 0; i < N + 2; i++)
            Arrays.fill(g[i], Long.MAX_VALUE);

        // start <-> goalの距離
        g[0][N + 1] = g[N + 1][0] = Math.hypot(xs - xt, ys - yt);
        // start <-> バリアの距離
        for (int i = 0; i < N; i++) {
            double dist = Math.hypot(xs - p[i].x, ys - p[i].y);
            g[0][i + 1] = g[i + 1][0] = Math.max(0, dist - p[i].r);
        }
        // バリア <-> goalの距離
        for (int i = 0; i < N; i++) {
            double dist = Math.hypot(xt - p[i].x, yt - p[i].y);
            g[N + 1][i + 1] = g[i + 1][N + 1] = Math.max(0, dist - p[i].r);
        }
        // バリア間の距離
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double dist = Math.hypot(p[j].x - p[i].x, p[j].y - p[i].y);
                if (dist <= p[j].r + p[i].r) {
                    g[i + 1][j + 1] = g[j + 1][i + 1] = 0;
                } else {
                    g[i + 1][j + 1] = g[j + 1][i + 1] = dist - (p[j].r + p[i].r);
                }
            }
        }

        // Dikstra
        double len[] = new double[N + 2]; // minimum graphance
        boolean v[] = new boolean[N + 2]; // decision flag
        for (int i = 0; i < N + 2; i++) {
            len[i] = Long.MAX_VALUE;
        }
        len[0] = 0;
        for (int i = 0; i < N + 2; i++) {
            // search minimum neighbor node
            int pp = 0;
            double min = Long.MAX_VALUE;
            for (int j = 0; j < N + 2; j++) {
                if (!v[j] && len[j] < min) {
                    pp = j;
                    min = len[j];
                }
            }
            v[pp] = true;
            for (int j = 0; j < N + 2; j++) {
                if ((len[pp] + g[pp][j]) < len[j]) {
                    len[j] = len[pp] + g[pp][j];
                }
            }
        }
        System.out.println(len[N + 1]);
    }

    class P {
        double x;
        double y;
        double r;

        public P(double x, double y, double r) {
            super();
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }

    void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    void debug2(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    boolean inner(int h, int w, int limH, int limW) {
        return 0 <= h && h < limH && 0 <= w && w < limW;
    }

    void swap(int[] x, int a, int b) {
        int tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;
    }

    // find minimum i (k <= a[i])
    int lower_bound(int a[], int k) {
        int l = -1;
        int r = a.length;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (k <= a[mid])
                r = mid;
            else
                l = mid;
        }
        // r = l + 1
        return r;
    }

    // find minimum i (k < a[i])
    int upper_bound(int a[], int k) {
        int l = -1;
        int r = a.length;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (k < a[mid])
                r = mid;
            else
                l = mid;
        }
        // r = l + 1
        return r;
    }

    int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    boolean palindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    class MyScanner {
        int nextInt() {
            try {
                int c = System.in.read();
                while (c != '-' && (c < '0' || '9' < c))
                    c = System.in.read();
                if (c == '-')
                    return -nextInt();
                int res = 0;
                do {
                    res *= 10;
                    res += c - '0';
                    c = System.in.read();
                } while ('0' <= c && c <= '9');
                return res;
            } catch (Exception e) {
                return -1;
            }
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String next() {
            try {
                StringBuilder res = new StringBuilder("");
                int c = System.in.read();
                while (Character.isWhitespace(c))
                    c = System.in.read();
                do {
                    res.append((char) c);
                } while (!Character.isWhitespace(c = System.in.read()));
                return res.toString();
            } catch (Exception e) {
                return null;
            }
        }

        int[] nextIntArray(int n) {
            int[] in = new int[n];
            for (int i = 0; i < n; i++) {
                in[i] = nextInt();
            }
            return in;
        }

        int[][] nextInt2dArray(int n, int m) {
            int[][] in = new int[n][m];
            for (int i = 0; i < n; i++) {
                in[i] = nextIntArray(m);
            }
            return in;
        }

        double[] nextDoubleArray(int n) {
            double[] in = new double[n];
            for (int i = 0; i < n; i++) {
                in[i] = nextDouble();
            }
            return in;
        }

        long[] nextLongArray(int n) {
            long[] in = new long[n];
            for (int i = 0; i < n; i++) {
                in[i] = nextLong();
            }
            return in;
        }

        char[][] nextCharField(int n, int m) {
            char[][] in = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < m; j++) {
                    in[i][j] = s.charAt(j);
                }
            }
            return in;
        }
    }
}