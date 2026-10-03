import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    final int NMAX = 1000;
    final int MMAX = 2000;
    final long INF = Long.MAX_VALUE;
    int[] a = new int[MMAX];
    int[] b = new int[MMAX];
    long[] c = new long[MMAX];

    for (int i = 0; i < M; i++) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextLong();
      c[i] = -c[i]; //スコア逆
    }
    long ans = bellmanFord(a,b,c,N,M);

    if(ans == -INF) System.out.println("inf");
    else System.out.println(-ans);
  }

  public static long bellmanFord(int[] a, int[] b, long[]c, int N, int M){
    final long INF = Long.MAX_VALUE;
    final int NMAX = 1000;
    final int MMAX = 2000;

    long[] dist = new long[NMAX];


    for (int i = 0; i < N; i++) {
      dist[i] = INF; //初期化
    }

    dist[0] = 0L;

    for(int loop = 0; loop < N - 1; loop++) {
      for (int i = 0; i < M; i++) {
        if(dist[a[i] - 1] == INF) continue;

        if(dist[b[i] - 1] > dist[a[i] - 1] + c[i]) {
          dist[b[i] - 1] = dist[a[i] - 1] + c[i];
        }
      }
    }

    long ans = dist[N - 1];

    boolean[] negative = new boolean[NMAX];

    for(int i = 0; i < N; i++) {
      negative[i] = false;
    }

    for (int loop = 0; loop < N; loop++) {
      for (int i = 0; i < M; i++) {
        if (dist[a[i] - 1] == INF) continue;

        if (dist[b[i] - 1] > dist[a[i] - 1] + c[i]) {
          dist[b[i] - 1] = dist[a[i] - 1] + c[i];
          negative[b[i] - 1] = true;
        }

        if (negative[a[i] - 1] == true) {
          negative[b[i] - 1] = true;
        }
      }
    }
    if (negative[N - 1]) return -INF;
    else return ans;
  }
}
