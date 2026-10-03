import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Main {

    public Main() {
    }

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        new Main().run();
    }

    int N;
    int M;
    boolean[] visited;
    List<List<Integer>> adjList = new ArrayList<List<Integer>>();

    private void run() {
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        int ans = 0;
        ans = dfs(0, 0);

        System.out.println(ans);
    }

    private int dfs(int n, int idx) {
        if (n == N - 1) {
            return 1;
        }
        visited[idx] = true;

        int res = 0;
        for (int i = 0; i < adjList.get(idx).size(); i++) {
            if (visited[adjList.get(idx).get(i)]) {
                continue;
            }

            res += dfs(n + 1, adjList.get(idx).get(i));
        }
        visited[idx] = false;
        return res;
    }

}
