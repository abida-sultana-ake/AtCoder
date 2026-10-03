import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author @MaxHeap
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DolphinPath solver = new DolphinPath();
        solver.solve(1, in, out);
        out.close();
    }

    static class DolphinPath {
        public void solve(int testNumber, FastReader fs, PrintWriter pw) {
            int sx = fs.nextInt(), sy = fs.nextInt(), tx = fs.nextInt(), ty = fs.nextInt();
            StringBuilder ans = new StringBuilder();
            int px = sx, py = sy;
            while (py++ < ty) {
                ans.append("U");
            }
            while (px++ < tx) {
                ans.append("R");
            }
            while (py-- > sy + 1) {
                ans.append("D");
            }
            while (px-- > sx + 1) {
                ans.append("L");
            }
            px--;
            ans.append("L");
            while (py++ < ty + 1) {
                ans.append("U");
            }
            while (px++ < tx) {
                ans.append("R");
            }
            py--;
            ans.append("D");
            px++;
            ans.append("R");
            while (py-- > sy) {
                ans.append("D");
            }
            while (px-- > sx + 1) {
                ans.append("L");
            }
            ans.append("U");
            pw.println(ans.toString().trim());
        }

    }

    static class FastReader {
        BufferedReader bf;
        StringTokenizer st;

        public FastReader(InputStream is) {
            bf = new BufferedReader(new InputStreamReader(is));
            st = null;
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = bf.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
            } catch (Exception e) {
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

