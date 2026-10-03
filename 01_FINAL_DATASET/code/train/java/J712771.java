import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().solve();
    }

    void solve() {
        FastScanner in = new FastScanner(System.in);

        int N = in.nextInt();
        int Q = in.nextInt();
        int[] X = new int[N];
        int[] R = new int[N];
        int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = in.nextInt();
            R[i] = in.nextInt();
            H[i] = in.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int _i = 0; _i < Q; _i++) {
            int A = in.nextInt();
            int B = in.nextInt();

            double ans = 0;
            for (int i = 0; i < N; i++) {
                if (X[i] <= B && A <= X[i] + H[i]) {
                    int a = Math.max(X[i], A);
                    int b = Math.min(X[i] + H[i], B);

                    double v = area(R[i], X[i], H[i], a)
                            - area(R[i], X[i], H[i], b);
                    ans += v;
                }
            }
            sb.append(ans + "\n");
        }
        System.out.print(sb);

    }

    double area(int R, int X, int H, int A) {
        double r = R * (double) (X + H - A) / H;
        double s = r * r * Math.PI;
        double v = s * (X + H - A) / 3;
        return v;
    }


    class FastScanner {
        private InputStream _stream;
        private byte[] _buf = new byte[1024];
        private int _curChar;
        private int _numChars;
        private StringBuilder _sb = new StringBuilder();

        FastScanner(InputStream stream) {
            this._stream = stream;
        }

        public int read() {
            if (_numChars == -1) throw new InputMismatchException();
            if (_curChar >= _numChars) {
                _curChar = 0;
                try {
                    _numChars = _stream.read(_buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (_numChars <= 0) return -1;
            }
            return _buf[_curChar++];
        }

        public String next() {
            int c = read();
            while (isWhitespace(c)) {
                c = read();
            }
            _sb.setLength(0);
            do {
                _sb.appendCodePoint(c);
                c = read();
            } while (!isWhitespace(c));
            return _sb.toString();
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public long nextLong() {
            int c = read();
            while (isWhitespace(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isWhitespace(c));
            return res * sgn;
        }

        public boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//