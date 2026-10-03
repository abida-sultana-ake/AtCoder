import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hamza Hasbi
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        C_Sequence solver = new C_Sequence();
        solver.solve(1, in, out);
        out.close();
    }

    static class C_Sequence {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();

            long[] a = new long[n + 1];
            long[] pre = new long[n + 1];
            Arrays.fill(a, 0);
            Arrays.fill(pre, 0);
            long[] pro = new long[n + 1];
            Arrays.fill(pro, 0);
            long res = 0;
            long ans = 0;


            for (int i = 1; i <= n; i++) {
                a[i] = in.nextLong();
                pre[i] = pre[i - 1] + a[i];
                if ((i & 1) == 1 && pre[i] <= 0) {
                    ans += Math.abs(1 - pre[i]);
                    pre[i] = 1;
                    continue;
                }
                if ((i & 1) == 0 && pre[i] >= 0) {
                    ans += Math.abs(1 + pre[i]);
                    pre[i] = -1;
                    continue;
                }
            }


            for (int i = 1; i <= n; i++) {

                pro[i] = pro[i - 1] + a[i];
                if ((i & 1) == 0 && pro[i] <= 0) {
                    res += Math.abs(1 - pro[i]);
                    pro[i] = 1;
                    continue;
                }
                if ((i & 1) == 1 && pro[i] >= 0) {
                    res += Math.abs(1 + pro[i]);
                    pro[i] = -1;
                    continue;
                }
            }

            out.printLine(Math.min(res, ans));
        }

    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer st;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        return null;
                    }
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
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

        public void printLine(long i) {
            writer.println(i);
        }

        public void close() {
            writer.close();
        }

    }
}

