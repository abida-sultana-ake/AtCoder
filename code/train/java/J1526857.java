import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author ogiekako
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScanner in = new MyScanner(inputStream);
        MyPrintWriter out = new MyPrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, MyScanner in, MyPrintWriter out) {
            String s = in.next() + '$';
            int n = s.length();
            int[][] nxt = new int[n + 1][26];
            ArrayUtils.fill(nxt, n);
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < 26; j++) {
                    if (s.charAt(i) - 'a' == j) {
                        nxt[i][j] = i + 1;
                    } else {
                        nxt[i][j] = nxt[i + 1][j];
                    }
                }
            }
            int INF = (int) 1e9;
            int[][] dp = new int[n + 1][26];
            ArrayUtils.fill(dp, INF);
            Arrays.fill(dp[n], 0);
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < 26; j++) {
                    for (int k = 0; k < 26; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[nxt[i][j]][k]);
                    }
                }
            }
            int len = INF;
            for (int i = 0; i < 26; i++) len = Math.min(len, dp[0][i]);
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < n; ) {
                for (int j = 0; j < 26; j++) {
                    if (dp[i][j] == len) {
                        b.append((char) ('a' + j));
                        i = nxt[i][j];
                        len--;
                        break;
                    }
                }
            }
            out.println(b);
        }

    }

    static class ArrayUtils {
        public static void fill(int[][] array, int value) {
            for (int[] a : array) Arrays.fill(a, value);
        }

    }

    static class MyPrintWriter {
        PrintWriter out;

        public MyPrintWriter(OutputStream outputStream) {
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public MyPrintWriter(Writer writer) {
            out = new PrintWriter(writer);
        }

        public void println(Object... os) {
            if (os.length == 0) {
                out.println();
                return;
            }
            for (int i = 0; i < os.length - 1; i++) {
                out.print(os[i]);
                out.print(' ');
            }
            out.println(os[os.length - 1]);
        }

        public void close() {
            out.close();
        }

    }

    static class MyScanner {
        private final InputStream in;
        private static final int BUFSIZE = 65536;
        int bufLen;
        int bufPtr;
        byte[] buf = new byte[BUFSIZE];
        private char[] strBuf = new char[BUFSIZE];

        public MyScanner(InputStream in) {
            this.in = in;
        }

        public int read() {
            if (bufLen == -1)
                throw new InputMismatchException();
            if (bufPtr >= bufLen) {
                bufPtr = 0;
                try {
                    bufLen = in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (bufLen <= 0)
                    return -1;
            }
            return buf[bufPtr++];
        }

        public String next() {
            int strLen = 0;
            int c;
            do {
                c = read();
                if (c == -1) throw new NoSuchElementException();
            } while (Character.isWhitespace(c));
            do {
                if (strLen + 1 >= strBuf.length) {
                    char[] tmp = new char[strBuf.length * 2];
                    System.arraycopy(strBuf, 0, tmp, 0, strBuf.length);
                    strBuf = tmp;
                }
                strBuf[strLen++] = (char) c;
                c = read();
            } while (c != -1 && !Character.isWhitespace(c));
            return new String(strBuf, 0, strLen);
        }

    }
}

