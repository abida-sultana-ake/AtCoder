import java.io.*;
import java.lang.reflect.Array;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

    String filename = "gri";//filename here, System.in/out if no file
    FastScanner in;

    PrintWriter out;

    static int min(int a, int b) {
        if (a <= b) {
            return a;
        } else {
            return b;
        }
    }

    static int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }


    public static class Point {
        double x;
        double y;

        Point(double a, double b) {
            x = a;
            y = b;
        }
    }

    public static class Circle {
        Point c;
        double r;

        Circle(Point c1, double r1) {
            c = c1;
            r = r1;
        }
    }

    public static class Line {
        double a;
        double b;
        double c;

        Line(double q, double w, double e) {
            a = q;
            b = w;
            c = e;
        }
    }

    static double distal(Point o, Line l) {
        double res = 0;
        res = (l.a * o.x) + (l.b * o.y) + l.c;
        if (res < 0) {
            res = -res;
        }
        res = res / (Math.sqrt((l.a * l.a) + (l.b * l.b)));
        return res;
    }

    static Point peresechenie(Line l1, Line l2) {
        Point p = new Point(l1.a, l1.b);
        p.x = ((-1) * ((l1.c * l2.b) - (l2.c * l1.b)) / ((l1.a * l2.b) - (l2.a * l1.b)));
        p.y = ((-1) * ((l1.a * l2.c) - (l2.a * l1.c)) / ((l1.a * l2.b) - (l2.a * l1.b)));
        return p;
    }

    static double rast(Point a, Point b) {
        return Math.sqrt(((b.x - a.x) * (b.x - a.x)) + ((b.y - a.y) * (b.y - a.y)));
    }

    static double[] kas(Circle w, Point p) {
        double ar[] = new double[5];
        if (rast(p, w.c) == w.r) {
            ar[0] = 1;
            ar[1] = p.x;
            ar[2] = p.y;
            return ar;
        } else {
            if (rast(p, w.c) < w.r) {
                ar[0] = 0;
                return ar;
            } else {
                double e = Math.sqrt(((rast(p, w.c) * rast(p, w.c)) - (w.r * w.r)));
                return ar; /* tut */
            }
        }
    }

    static double geron(Point A, Point B, Point C) {
        double a = rast(B, C);
        double b = rast(A, C);
        double c = rast(A, B);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static class Vector {
        double x;
        double y;

        Vector(Point a, Point b) {
            x = b.x - a.x;
            y = b.y - a.y;
        }
    }

    static double vpr(Vector a, Vector b) {
        return a.x * b.y - a.y * b.x;
    }

    static double nappl(Point A, Point B, Point C) {
        Vector a = new Vector(C, B);
        Vector b = new Vector(C, A);
        return vpr(a, b) / 2;
    }

    static Line sozd(Point p1, Point p2) {
        Line l = new Line(0, 0, 0);
        l.a = -1 * (p2.y - p1.y);
        l.b = (p1.x - p2.x) * (-1);
        l.c = -(l.a * p1.x) - (l.b * p1.y);
        return l;
    }

    static double plmn (Point[] ar, int n) {
        double s = 0;
        for (int i = 1; i < n - 1; i++) {
            Vector a = new Vector(ar[0], ar[i]);
            Vector b = new Vector(ar[0], ar[i + 1]);
            s = s + nappl(ar[i + 1],ar[i],ar[0]);
        }
        if (s < 0) {
            s = - s;
        }
        return s;
    }

    void solve() {
        int n = in.nextInt();
        long a[] = new long[n];
        a[0] = in.nextInt();
        for (int i = 1; i < n; i++) {
            a[i] = in.nextInt() + a[i - 1];
        }

        long b[] = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            b[i] = a[i] * 2 - a[n - 1];
            if (b[i] < 0) {
                b[i] = - b[i];
            }
        }
        long s = b[0];
        for (int i = 0; i < n - 1; i++) {
            if (b[i] < s) {
                s = b[i];
            }
        }
        out.print(s);
    }

    /* To strah i toska, to bessilnaya yarost,
       to sleozi i bol napolnyayut chasi. */


    void run() throws IOException {
        InputStream input = System.in;
        OutputStream output = System.out;
        try {
            File f = new File(filename + ".in");
            if (f.exists() && f.canRead()) {
                input = new FileInputStream(f);
                output = new FileOutputStream(filename + ".out");
            }
        } catch (IOException e) {
        }
        in = new FastScanner(input);
        out = new PrintWriter(new BufferedOutputStream(output));
        solve();
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new Main().run();
    }

    class FastScanner implements Closeable {
        private BufferedReader br;
        private StringTokenizer tokenizer;

        public FastScanner(InputStream stream) throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public boolean hasNext() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String s = br.readLine();
                    if (s == null) {
                        return false;
                    }
                    tokenizer = new StringTokenizer(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.hasMoreTokens();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken("\n");
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        @Override
        public void close() throws IOException {
            br.close();
        }
    }
}