import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author tanzaku
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyInput in = new MyInput(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        RMQInt rmq0 = new RMQInt(1 << 29);
        RMQInt rmq1 = new RMQInt(1 << 29);
        TreeMap<Integer, int[]> mp = new TreeMap<>();
        int[] p;

        public void solve(int testNumber, MyInput in, PrintWriter out) {
            int n = in.nextInt();
            p = in.nextIntArray(n);
            rmq0.build(n);
            rmq1.build(n);
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) rmq0.Update(p[i], i);
                else rmq1.Update(p[i], i);
            }
            next(0, n);
            List<Long> ans = new ArrayList<>();
            for (; !mp.isEmpty(); ) {
                int[] interval = mp.pollFirstEntry().getValue();
                int l = interval[0], r = interval[1];
                if (r - l == 0) continue;
//            dump(l, r);
                if ((r - l) % 2 != 0) throw new RuntimeException();
                int idx, idx2;
                if (l % 2 == 0) {
                    idx = rmq0.QueryIndex(l, r - 1);
                    idx2 = rmq1.QueryIndex(idx, r);
                    rmq0.Update(1 << 29, idx);
                    rmq1.Update(1 << 29, idx2);
                } else {
                    idx = rmq1.QueryIndex(l, r - 1);
                    idx2 = rmq0.QueryIndex(idx, r);
                    rmq0.Update(1 << 29, idx2);
                    rmq1.Update(1 << 29, idx);
                }
//            dump(l, r, idx, idx2);
                ans.add((long) p[idx] << 32 | p[idx2]);
                next(l, idx);
                next(idx + 1, idx2);
                next(idx2 + 1, r);
            }
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) >>> 32);
                out.print(' ');
                out.print(ans.get(i) & 0x7FFFFFFF);
                out.print(i == ans.size() - 1 ? '\n' : ' ');
            }
        }

        void next(int l, int r) {
            if (r - l == 0) return;
            int v;
            if (l % 2 == 0) {
                v = rmq0.Query(l, r - 1);
            } else {
                v = rmq1.Query(l, r - 1);
            }
            mp.put(v, new int[]{l, r});
        }

    }

    static class RMQInt {
        int n;
        int[] xs;
        int[] ys;
        final int INF;

        public RMQInt(int inf) {
            INF = inf;
        }

        int Min(int a, int b) {
            return a == INF ? b : (b == INF ? a : (a <= b ? a : b));
        }

        int minIndex(int a, int b) {
            return a == -1 ? b : (b == -1 ? a : (Min(xs[a], xs[b]) == xs[a] ? a : b));
        }

        public void build(int m) {
            for (n = 1; n < m; n <<= 1) ;
            xs = new int[2 * n];
            ys = new int[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                ys[i] = i;
            }
            clear();
        }

        public void clear() {
            Arrays.fill(xs, INF);
        }

        public void Update(int v, int idx) {
            xs[idx += n - 1] = v;
            while (idx > 0) {
                idx = (idx - 1) / 2;
                xs[idx] = Min(xs[idx * 2 + 1], xs[idx * 2 + 2]);
                ys[idx] = ys[minIndex(idx * 2 + 1, idx * 2 + 2)];
            }
        }

        public int Query(int l, int r) {
            return Query(l, r, 0, n, 0);
        }

        int Query(int l, int r, int a, int b, int k) {
            if (l <= a && b <= r) return xs[k];
            if (b <= l || r <= a) return INF;
            final int m = (a + b) / 2;
            return Min(
                    Query(l, r, a, m, 2 * k + 1),
                    Query(l, r, m, b, 2 * k + 2));
        }

        public int QueryIndex(int l, int r) {
            return QueryIndex(l, r, 0, n, 0) - (n - 1);
        }

        int QueryIndex(int l, int r, int a, int b, int k) {
            if (l <= a && b <= r) return ys[k];
            if (b <= l || r <= a) return -1;
            final int m = (a + b) / 2;
            return minIndex(
                    QueryIndex(l, r, a, m, 2 * k + 1),
                    QueryIndex(l, r, m, b, 2 * k + 2));
        }

    }

    static class MyInput {
        private final BufferedReader in;
        private static int pos;
        private static int readLen;
        private static final char[] buffer = new char[1024 * 8];
        private static char[] str = new char[500 * 8 * 2];
        private static boolean[] isDigit = new boolean[256];
        private static boolean[] isSpace = new boolean[256];
        private static boolean[] isLineSep = new boolean[256];

        static {
            for (int i = 0; i < 10; i++) {
                isDigit['0' + i] = true;
            }
            isDigit['-'] = true;
            isSpace[' '] = isSpace['\r'] = isSpace['\n'] = isSpace['\t'] = true;
            isLineSep['\r'] = isLineSep['\n'] = true;
        }

        public MyInput(InputStream is) {
            in = new BufferedReader(new InputStreamReader(is));
        }

        public int read() {
            if (pos >= readLen) {
                pos = 0;
                try {
                    readLen = in.read(buffer);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
                if (readLen <= 0) {
                    throw new MyInput.EndOfFileRuntimeException();
                }
            }
            return buffer[pos++];
        }

        public int nextInt() {
            int len = 0;
            str[len++] = nextChar();
            len = reads(len, isSpace);
            int i = 0;
            int ret = 0;
            if (str[0] == '-') {
                i = 1;
            }
            for (; i < len; i++) ret = ret * 10 + str[i] - '0';
            if (str[0] == '-') {
                ret = -ret;
            }
            return ret;
        }

        public char nextChar() {
            while (true) {
                final int c = read();
                if (!isSpace[c]) {
                    return (char) c;
                }
            }
        }

        int reads(int len, boolean[] accept) {
            try {
                while (true) {
                    final int c = read();
                    if (accept[c]) {
                        break;
                    }
                    if (str.length == len) {
                        char[] rep = new char[str.length * 3 / 2];
                        System.arraycopy(str, 0, rep, 0, str.length);
                        str = rep;
                    }
                    str[len++] = (char) c;
                }
            } catch (MyInput.EndOfFileRuntimeException e) {
            }
            return len;
        }

        public int[] nextIntArray(final int n) {
            final int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextInt();
            }
            return res;
        }

        static class EndOfFileRuntimeException extends RuntimeException {
        }

    }
}

