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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int h = in.nextInt();
            int w = in.nextInt();
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            int[][] t = new int[h][w];
            int curPos = 0;
            int curCol = 0;
            while (curPos != h * w) {
                int row = curPos / w;
                int col = 0;

                if (row % 2 == 0)
                    col = curPos % w;
                else
                    col = w - curPos % w - 1;

                if (a[curCol] == 0)
                    curCol++;

                a[curCol]--;
                t[row][col] = curCol + 1;

                curPos++;
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    out.print(t[i][j] + " ");
                }
                out.println();
            }
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
 