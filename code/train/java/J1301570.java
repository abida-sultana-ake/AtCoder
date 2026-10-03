import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long h = in.nextInt();
            long w = in.nextInt();
            long minDiff = Long.MAX_VALUE;

            for (int y = 1; y < h; y++) {
                long s1 = w * y;

                long s2 = (h - y) * (w >> 1);
                long s3 = (h - y) * ((w + 1) >> 1);
                long maxs = Math.max(Math.max(s1, s2), s3);
                long mins = Math.min(Math.min(s1, s2), s3);
                minDiff = Math.min(minDiff, maxs - mins);

                s2 = ((h - y) >> 1) * w;
                s3 = ((h - y + 1) >> 1) * w;
                maxs = Math.max(Math.max(s1, s2), s3);
                mins = Math.min(Math.min(s1, s2), s3);
                minDiff = Math.min(minDiff, maxs - mins);
            }

            long t = h;
            h = w;
            w = t;
            for (int y = 1; y < h; y++) {
                long s1 = w * y;

                long s2 = (h - y) * (w >> 1);
                long s3 = (h - y) * ((w + 1) >> 1);
                long maxs = Math.max(Math.max(s1, s2), s3);
                long mins = Math.min(Math.min(s1, s2), s3);
                minDiff = Math.min(minDiff, maxs - mins);

                s2 = ((h - y) >> 1) * w;
                s3 = ((h - y + 1) >> 1) * w;
                maxs = Math.max(Math.max(s1, s2), s3);
                mins = Math.min(Math.min(s1, s2), s3);
                minDiff = Math.min(minDiff, maxs - mins);
            }
            out.println(minDiff);
        }

    }

    static class InputReader {
        StringTokenizer st;
        BufferedReader br;

        public InputReader(InputStream is) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            this.br = br;
        }

        public String next() {
            if (st == null || !st.hasMoreTokens()) {
                String nextLine = null;
                try {
                    nextLine = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (nextLine == null)
                    return null;
                st = new StringTokenizer(nextLine);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

