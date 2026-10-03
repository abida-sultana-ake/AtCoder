import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
 * @author Anirudh Rayabharam <mail@anirudhrb.com>
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TransitTreePath solver = new TransitTreePath();
        solver.solve(1, in, out);
        out.close();
    }

    static class TransitTreePath {
        private ArrayList<ArrayList<Edge>> tree = new ArrayList<>();
        private long[] dist;
        private boolean[] seen;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            dist = new long[n + 1];
            seen = new boolean[n + 1];
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                tree.get(a).add(new Edge() {
                    {
                        to = b;
                        length = c;
                    }
                });
                tree.get(b).add(new Edge() {
                    {
                        to = a;
                        length = c;
                    }
                });
            }
            int q = in.nextInt();
            int k = in.nextInt();
            dfs(k, 0);
            for (int i = 0; i < q; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                out.println(dist[x] + dist[y]);
            }
        }

        private void dfs(int start, long d) {
            if (seen[start])
                return;
            dist[start] = d;
            seen[start] = true;
            for (int i = 0; i < tree.get(start).size(); i++) {
                Edge e = tree.get(start).get(i);
                dfs(e.to, d + e.length);
            }
        }

        class Edge {
            int to;
            int length;

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

