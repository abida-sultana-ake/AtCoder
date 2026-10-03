import java.util.*;

public class Main {
    static int bridge;
    static int cnt;
    static int[] pre;
    static int[] low;

    private static void dfs(Map<Integer, List<Integer>> G, int u, int v) {
        pre[v - 1] = cnt++;
        low[v - 1] = pre[v - 1];

        for (int w : G.get(v)) {
            if (pre[w - 1] == -1) {
                dfs(G, v, w);
                low[v - 1] = Math.min(low[v - 1], low[w - 1]);
                if (low[w - 1] == pre[w - 1])
                    bridge++;
            } else if (w != u)
                low[v - 1] = Math.min(low[v - 1], pre[w - 1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        Map<Integer, List<Integer>> G = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            G.put(i, new ArrayList<Integer>());
        }

        for (int j = 0; j < e; j++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            G.get(u).add(w);
            G.get(w).add(u);
        }

        low = new int[v];
        pre = new int[v];

        for (int i = 0; i < v; i++) {
            low[i] = -1;
            pre[i] = -1;
        }

        for (int k = 1; k <= v; k++) {
            if (pre[k - 1] == -1)
                dfs(G, k, k);
        }

        System.out.println(bridge);
    }

}
