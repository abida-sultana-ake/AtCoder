import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStreamReader;
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
        int[][] memo = new int[200000 + 1][];
        char[] cs;
        int[][] chars = new int[26][];

        public void solve(int testNumber, MyInput in, PrintWriter out) {
            cs = in.next();
            int[] cnt = new int[26];
            for (int i = 0; i < cs.length; i++) {
                cnt[cs[i] - 'a']++;
            }
            for (int i = 0; i < chars.length; i++) chars[i] = new int[cnt[i]];
            Arrays.fill(cnt, 0);
            for (int i = 0; i < cs.length; i++) {
                chars[cs[i] - 'a'][cnt[cs[i] - 'a']++] = i;
            }
            rec(0);
            StringBuilder sb = new StringBuilder();
            for (int cur = 0; cur != -1; cur = memo[cur][2]) {
                sb.append((char) (memo[cur][1] + 'a'));
            }
            out.println(sb.toString());
        }

        int[] rec(int len) {
            if (memo[len] == null) {
                int ans = Integer.MAX_VALUE;
                int j = -1;
                int k = -1;
                for (int i = 0; i < 26; i++) {
                    int li = index(len, i);
                    if (li == -1) {
                        ans = 0;
                        j = i;
                        k = -1;
                        break;
                    }
                    if (ans > rec(li + 1)[0]) {
                        ans = rec(li + 1)[0];
                        j = i;
                        k = li + 1;
                    }
                }
                memo[len] = new int[]{ans + 1, j, k,};
            }
            return memo[len];
        }

        int index(int len, int ci) {
            int[] idx = chars[ci];
            int low = -1, high = idx.length;
            while (high - low > 1) {
                int mid = (low + high) / 2;
                if (idx[mid] < len) low = mid;
                else high = mid;
            }
            return high == idx.length ? -1 : idx[high];
//        return low < 0 ? -1 : idx[low];
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

        public char[] next() {
            int len = 0;
            str[len++] = nextChar();
            len = reads(len, isSpace);
            return Arrays.copyOf(str, len);
        }

        static class EndOfFileRuntimeException extends RuntimeException {
        }

    }
}

