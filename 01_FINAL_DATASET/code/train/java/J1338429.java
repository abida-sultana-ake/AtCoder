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
        C_Bugged solver = new C_Bugged();
        solver.solve(1, in, out);
        out.close();
    }

    static class C_Bugged {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int[] a = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                sum += a[i];
            }

            Arrays.sort(a);
            int i = 0;
            while (sum % 10 == 0 && i < n) {
                if (a[i] % 10 != 0) sum -= a[i];
                i++;
            }
            if (sum % 10 == 0) sum = -1;
            out.printLine(sum < 0 ? 0 : sum);
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

    }
}

