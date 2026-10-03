import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
    FastScanner in = new FastScanner();
    PrintWriter out = new PrintWriter(System.out);

    private void solve() {
        int N = in.nextInt();
        long[] wh = new long[N];
        for (int i = 0; i < N; i++) {
            long w = in.nextLong();
            long h = in.nextLong();
            wh[i] = (w << 32) - h;
        }
        Arrays.sort(wh);
        SegTree sg = new SegTree(100005);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int h = -1 * (int)((wh[i] << 32) >> 32);
            int now = sg.getMax(0, h, 1, 0, -1) + 1;
            sg.add(h, now);
            ans = Math.max(ans, now);
        }
        out.println(ans);
    }

    private void run() {
        solve();
        out.flush();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}

class SegTree {
    int n;
    int[] d;

    SegTree(int mx) {
        n = 1;
        while (n < mx) n <<= 1;
        d = new int[n << 1];
    }

    int getMax(int a, int b, int i, int l, int r) {
        if (r == -1) r = n;
        if (a <= l && r <= b) return d[i];
        int res = 0;
        int c = (l + r) >> 1;
        if (a < c) res = Math.max(res, getMax(a, b, i << 1, l, c));
        if (c < b) res = Math.max(res, getMax(a, b, (i << 1) | 1, c, r));
        return res;
    }

    void add(int i, int x) {
        i += n;
        while (i > 0) {
            d[i] = Math.max(d[i], x);
            i >>= 1;
        }
    }
}

class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        }else{
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }

    private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}

    private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}

    public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}

    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while(isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public long nextLong() {
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
        while(true){
            if ('0' <= b && b <= '9') {
                n *= 10;
                n += b - '0';
            }else if(b == -1 || !isPrintableChar(b)){
                return minus ? -n : n;
            }else{
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }

    public int nextInt() {
        long nl = nextLong();
        if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
        return (int) nl;
    }

    public double nextDouble() { return Double.parseDouble(next());}
}