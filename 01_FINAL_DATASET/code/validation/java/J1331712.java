import java.io.*;
import java.util.*;
 
public class Main {
    private static boolean debug = false;
    private static boolean elapsed = false;
 
    private static PrintWriter _out = new PrintWriter(System.out);
    private static PrintWriter _err = new PrintWriter(System.err);
 
    private int N;
    private int M;
 
    private void solve(Scanner sc) {
        N = sc.nextInt();
        M = sc.nextInt();
        int[] a = new int[M];
        int[] b = new int[M];
        int[] c = new int[M];
        for (int i = 0; i < M; ++i) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
            c[i] = sc.nextInt();
        }
 
        long[][] dist = new long[N][N];
 
        // 初期化
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < M; ++i) {
            dist[a[i]][b[i]] = Math.min(dist[a[i]][b[i]], c[i]);
            dist[b[i]][a[i]] = Math.min(dist[b[i]][a[i]], c[i]);
        }
 
        // 本計算
        for (int k = 0; k < N; ++k) {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
 
        int ans = M;
        for (int i = 0; i < M; ++i) {
            boolean shortest = false;
            for (int j = 0; j < N; ++j) {
                if (dist[j][a[i]] + c[i] == dist[j][b[i]]) {
                    shortest = true;
                    break;
                }
            }
            if (shortest) {
                --ans;
            }
        }
 
        _out.println(ans);
    }
    private long C(long n, long r) {
        long res = 1;
        for (long i = n; i > n - r; --i) {
            res *= i;
        }
        for (long i = r; i > 1; --i) {
            res /= i;
        }
        return res;
    }
    private long P(long n, long r) {
        long res = 1;
        for (long i = n; i > n - r; --i) {
            res *= i;
        }
        return res;
    }
    /*
     * 10^10 > Integer.MAX_VALUE = 2147483647 > 10^9
     * 10^19 > Long.MAX_VALUE = 9223372036854775807L > 10^18
     */
    public static void main(String[] args) {
        long S = System.currentTimeMillis();
 
        Scanner sc = new Scanner(System.in);
        new Main().solve(sc);
        _out.flush();
 
        long G = System.currentTimeMillis();
        if (elapsed) {
            _err.println((G - S) + "ms");
        }
        _err.flush();
    }
}