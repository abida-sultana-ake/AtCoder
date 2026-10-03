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
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            char[] s = in.next().toCharArray();
            int n = s.length;
            int[][] next = new int[n + 2][26];
            int[][] dist = new int[n + 2][26];
            int[] gmin = new int[n + 2];
            for (int[] x : dist) Arrays.fill(x, 1 << 29);
            Arrays.fill(dist[n], 1);
            Arrays.fill(next[n], n + 1);
            gmin[n] = 1;
            for (int i = n - 1; i >= 0; i--) {
                System.arraycopy(next[i + 1], 0, next[i], 0, 26);
                next[i][s[i] - 'a'] = i + 1;
                for (int j = 0; j < 26; j++)
                    dist[i][j] = gmin[next[i][j]] + 1;
                gmin[i] = AUtils.min(dist[i]);
            }
            int cpos = 0;
            char[] ret = new char[gmin[0]];
            int ridx = 0;
            while (cpos <= n) {
                for (int j = 0; j < 26; j++) {
                    if (dist[cpos][j] == gmin[cpos]) {
                        ret[ridx++] = (char) (j + 'a');
                        cpos = next[cpos][j];
                        break;
                    }
                }
            }
            out.println(new String(ret));
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            } else {
                if (this.curChar >= this.numChars) {
                    this.curChar = 0;

                    try {
                        this.numChars = this.stream.read(this.buf);
                    } catch (IOException var2) {
                        throw new InputMismatchException();
                    }

                    if (this.numChars <= 0) {
                        return -1;
                    }
                }

                return this.buf[this.curChar++];
            }
        }

        public String next() {
            int c;
            while (isSpaceChar(c = this.read())) {
                ;
            }

            StringBuilder result = new StringBuilder();
            result.appendCodePoint(c);

            while (!isSpaceChar(c = this.read())) {
                result.appendCodePoint(c);
            }

            return result.toString();
        }

        public static boolean isSpaceChar(int c) {
            return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class AUtils {
        public static int min(int[] arr) {
            int res = arr[0];
            for (int x : arr) res = Math.min(res, x);
            return res;
        }

    }
}

