import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class Main {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        new Main().calc();
    }
    
    int N,M,R;
    int[] r,A,B,C;
    boolean[] done;
    int[][] dist;
    int ans;
    
    public void calc() {
        N = in.nextInt();
        M = in.nextInt();
        R = in.nextInt();
        r = new int[R];
        A = new int[M];
        B = new int[M];
        C = new int[M];

        for (int i = 0; i < R; i++) {
            r[i] = in.nextInt() - 1;
        }

        for (int i = 0; i < M; i++) {
            A[i] = in.nextInt() - 1;
            B[i] = in.nextInt() - 1;
            C[i] = in.nextInt();
        }
        
        dist = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = 99999999;
            }
            dist[i][i] = 0;  
        }
        
        for (int i = 0; i < M; i++) {
            dist[A[i]][B[i]] = Math.min(C[i], dist[A[i]][B[i]]);
            dist[B[i]][A[i]] = dist[A[i]][B[i]];
        }      
        
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        done = new boolean[R];
        ans = Integer.MAX_VALUE;
        
        dfs(0, -1, 0);
        
        out.println(ans);
        out.close();
    }
    
    /**
     * 
     * @param curNum 現在訪れた町の数
     * @param curTown 今訪れている町
     * @param d 今まで歩いてきた距離
     */
    private void dfs(int curNum, int curTown, int d) {
        // out.println("curNum: " + curNum + " curTown: " + curTown + " d: " + d);
        // 最後の町にたどり着いたら
        if (curNum == R) {
            // 答えを更新
            if (ans > d) {
                ans = d;
            }
            return;
        }
        
        // まだ訪れていない町を訪問
        for (int i = 0; i < R; i++) {
            // 訪れていなければ
            if (!done[i]) {
                // 訪れたことにする
                done[i] = true;
                
                // これが訪れた最初の町なら，距離dは0で次に進む
                if (curTown == -1) {                    
                    dfs(curNum+1, i, 0);
                }
                // 最初の町でなければ，今までの距離dと，次の町への距離を加える
                // 次の町への距離は，現在の町r[curTown]から，次の町r[i]への最短距離distになる
                else {
                    dfs(curNum+1, i, d+dist[r[curTown]][r[i]]);                
                }
                
                done[i] = false;
            }
        }   
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
