import java.util.*;
import java.io.*;

public class Main {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer stok;

    String nextToken() throws IOException {
        while (stok == null || !stok.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null) {
                return null;
            }
            stok = new StringTokenizer(s);
        }
        return stok.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    char nextChar() throws IOException {
        return (char) (br.read());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }

    public static class Point {
        public long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public Point minus(Point b) {
            return new Point(x - b.x, y - b.y);
        }

        public double cross(Point b) {
            return x * b.y - y * b.x;
        }

        public double dot(Point b) {
            return x * b.x + y * b.y;
        }

    }

    boolean inside(Point d, Point a, Point b, Point c) {
        return (Math.min(a.x, Math.min(b.x, c.x)) <= d.x && Math.min(a.y, Math.min(b.y, c.y)) <= d.y &&
                Math.max(a.x, Math.max(b.x, c.x)) >= d.x && Math.max(a.y, Math.max(b.y, c.y)) >= d.y);
    }

    long s(Point a, Point b, Point c) {
        return ((Math.max(a.x, Math.max(b.x, c.x)) - Math.min(a.x, Math.min(b.x, c.x))) *
                (Math.max(a.y, Math.max(b.y, c.y)) - Math.min(a.y, Math.min(b.y, c.y))));
    }

    void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        Point[] points = new Point[n];
        TreeSet<Long> setx = new TreeSet<>();
        TreeSet<Long> sety = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            points[i] = new Point(nextLong(), nextLong());
            setx.add(points[i].x);
            sety.add(points[i].y);

        }

        long min = Long.MAX_VALUE;
        for (Long x1 : setx) {
            for (Long x2 : setx) {
                for (Long y1 : sety) {
                    for (Long y2 : sety) {
                        long mxx = Math.max(x1, x2);
                        long mnx = Math.min(x1, x2);
                        long mxy = Math.max(y1, y2);
                        long mny = Math.min(y1, y2);
                        int cnt = 0;
                        for (int q = 0; q < n; q++) {
                            if (mnx <= points[q].x && points[q].x <= mxx && mny <= points[q].y && points[q].y <= mxy) {
                                cnt++;
                            }
                        }
                        if (cnt >= k) {
                            min = Math.min(min, (mxx - mnx) * (mxy - mny));
                        }
                    }
                }
            }

        }

        out.println(min);
    }

    void run() throws IOException {
        // br = new BufferedReader(new FileReader("dragons.in"));
        //out = new PrintWriter("dragons.out");
        // br = new BufferedReader(new FileReader("input.txt"));
        // out = new PrintWriter("output.txt");
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        br.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        // Locale.setDefault(Locale.US);
        new Main().run();
    }
}