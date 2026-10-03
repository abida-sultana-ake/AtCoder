import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {

    private void solve(FastScanner sc) {
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] d = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            d[i] = a[i + 1] - a[i];
        }
        int maxgap = 0;
        int gap = 0;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (d[i] > 0) {
                gap += d[i];
                if (maxgap < gap) {
                    maxgap = gap;
                    cnt = 1;
                } else if (maxgap == gap) {
                    cnt++;
                }
            } else {
                gap += d[i];
                if (gap < 0) {
                    gap = 0;
                }
            }
        }
        System.out.println(cnt);
    }

    /*
     * template
     */

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        new Main().solve(sc);
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int bufLen = 0;

        private boolean hasNextByte() {
            if (ptr < bufLen) {
                return true;
            } else {
                ptr = 0;
                try {
                    bufLen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (bufLen <= 0) {
                    return false;
                }
            }
            return true;
        }

        private int readByte() {
            if (hasNextByte()) return buffer[ptr++];
            else return -1;
        }

        private static boolean isPrintableChar(int c) {
            return 33 <= c && c <= 126;
        }

        boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
            return hasNextByte();
        }

        String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while (true) {
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                } else if (b == -1 || !isPrintableChar(b)) {
                    return minus ? -n : n;
                } else {
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }

        int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
            return (int) nl;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}