import java.util.Scanner;

class Main {

    int n, m;
    boolean[][] c;

    void solve() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int[] a = new int[m], b = new int[m];
        c = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt() - 1;
            b[i] = in.nextInt() - 1;
            c[a[i]][b[i]] = c[b[i]][a[i]] = true;
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            c[a[i]][b[i]] = c[b[i]][a[i]] = false;
            if (link())
                ans++;
            c[a[i]][b[i]] = c[b[i]][a[i]] = true;
        }
        System.out.println(ans);
    }

    boolean link() {
        boolean[] visited = new boolean[n];
        visited[0] = true;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    if (visited[i]) {
                        if (c[i][j] && !visited[j]) {
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
