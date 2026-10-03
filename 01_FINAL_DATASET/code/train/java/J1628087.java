import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class Main {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        new Main().calc();    
    }
    
    List<List<Integer>> treeList;
    boolean[] done;
    int[] distN, dist1;
    
    
    public void calc() {
        int N = in.nextInt();
        int[] a = new int[N-1], b = new int[N-1];

        treeList = new ArrayList<List<Integer>>();
        for (int i = 0; i < N; i++) {
            treeList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < N-1; i++) {
            a[i] = in.nextInt() - 1;
            b[i] = in.nextInt() - 1;
            treeList.get(a[i]).add(b[i]);
            treeList.get(b[i]).add(a[i]);
        }
        
        done = new boolean[N];
        dist1 = new int[N];
        distN = new int[N];
        
        dfs(0, 0, dist1);
        Arrays.fill(done, false);
        dfs(N-1, 0, distN);
        
        int fennec = 0, snuke = 0;;
        
        for(int i = 0; i < N; i++) {
            if (dist1[i] <= distN[i]) {
                fennec++;
            }
            else {
                snuke++;
            }
        }
        
        String ans = "Fennec";
        
        if (snuke >= fennec) {
            ans = "Snuke";
        }

        
        out.println(ans);
        out.close();
    }
    
    void dfs(int to, int len, int[] dist) {
        if (done[to]) {
            return;
        }
        done[to] = true;
        dist[to] += len;
        treeList.get(to).forEach(next -> dfs(next, len+1, dist));             
    }
    
    class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = nextInt();

            return array;
        }

        int[][] nextIntMap(int n, int m) {
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = in.nextIntArray(m);
            }
            return map;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++)
                array[i] = nextLong();

            return array;
        }

        long[][] nextLongMap(int n, int m) {
            long[][] map = new long[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = in.nextLongArray(m);
            }
            return map;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        double[] nextDoubleArray(int n) {
            double[] array = new double[n];
            for (int i = 0; i < n; i++)
                array[i] = nextDouble();

            return array;
        }

        double[][] nextDoubleMap(int n, int m) {
            double[][] map = new double[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = in.nextDoubleArray(m);
            }
            return map;
        }

        String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        String[] nextStringArray(int n) {
            String[] array = new String[n];
            for (int i = 0; i < n; i++)
                array[i] = next();

            return array;
        }

        String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
}
