import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author HossamDoma
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
        public ArrayList<Integer>[] g = new ArrayList[200010];
        public int[] dist1 = new int[200010];
        public int[] distN = new int[200010];
        public int[] mark = new int[200010];
        int f = 1;
        int snuke = 1;

        void dfs(int node, int parent, int[] dArray) {

            for (int x : g[node]) {
                if (x != parent) {
                    dArray[x] = dArray[node] + 1;
                    dfs(x, node, dArray);
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {


            int n = in.nextInt();

            for (int i = 0; i < n - 1; ++i) {

                int x = in.nextInt();
                int y = in.nextInt();

                if (g[x] == null)
                    g[x] = new ArrayList<>();

                if (g[y] == null)
                    g[y] = new ArrayList<>();

                g[x].add(y);
                g[y].add(x);
            }

            dist1[1] = distN[n] = 0;

            dfs(1, 0, dist1);
            dfs(n, 100001, distN);

            Arrays.fill(mark, 0xff);

            mark[1] = 0;
            mark[0] = 0;

            mark[n] = 1;
            mark[100001] = 1;

//        play(1, 0);

            for (int i = 1; i <= n; ++i) {
                if (dist1[i] <= distN[i])
                    f++;
                else
                    snuke++;
            }
            if (f > snuke)
                out.println("Fennec");
            else
                out.println("Snuke");

        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

