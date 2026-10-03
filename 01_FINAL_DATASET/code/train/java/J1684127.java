import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {

            int N = in.nextInt();
            int M = in.nextInt();

            int[] a = new int[M];
            int[] b = new int[M];
            for (int i = 0; i < M; i++) {
                a[i] = in.nextInt() - 1;
                b[i] = in.nextInt() - 1;
            }

            StronglyConnectedComponent o = new StronglyConnectedComponent();

            int count = 0;
            for (int i = 0; i < M; i++) {
                o.init(N);

                for (int j = 0; j < M; j++) {
                    if (j == i) {
                        continue;
                    }
                    o.add(a[j], b[j]);
                    o.add(b[j], a[j]);
                }

                if (o.scc() != 1) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}

class StronglyConnectedComponent {
    /** 頂点数 */
    public int V;
    /** グラフの隣接リスト表現 */
    public ArrayList<Integer>[] G;
    /** 変の向きを逆にしたグラフ */
    ArrayList<Integer>[] rG;
    /** 帰りがけ順の並び */
    ArrayList<Integer>
    // int[]
    vs;
    /** すでに調べたか */
    boolean[] used;
    /** 属する強連結成分のトポロジカル順序 */
    public int[] cmp;

    public void init(int v) {
        V = v;
        G = new ArrayList[V];
        for (int i = 0; i < G.length; i++) {
            G[i] = new ArrayList<Integer>();
        }
        rG = new ArrayList[V];
        for (int i = 0; i < rG.length; i++) {
            rG[i] = new ArrayList<Integer>();
        }
        vs = new ArrayList<Integer>();
        used = new boolean[V];
        cmp = new int[V];
    }

    public void add(int from, int to) {
        G[from].add(to);
        rG[to].add(from);
    }

    private void dfs(int v) {
        used[v] = true;
        for (int i = 0; i < G[v].size(); i++) {
            // debug(v, G[v].get(i));
            if (!used[G[v].get(i)]) {
                dfs(G[v].get(i));
            }
        }
        vs.add(v);
    }

    private void rdfs(int v, int k) {
        used[v] = true;
        cmp[v] = k;
        for (int i = 0; i < rG[v].size(); i++) {
            if (!used[rG[v].get(i)]) {
                rdfs(rG[v].get(i), k);
            }
        }
    }

    public int scc() {
        Arrays.fill(used, false);
        vs.clear();
        for (int v = 0; v < V; v++) {
            if (!used[v]) {
                dfs(v);
            }
        }
        Arrays.fill(used, false);
        int k = 0;
        for (int i = vs.size() - 1; i >= 0; i--) {
            if (!used[vs.get(i)]) {
                rdfs(vs.get(i), k++);
            }
        }
        return k;
    }

    public static void main(String[] args) {
        StronglyConnectedComponent o = new StronglyConnectedComponent();
        o.init(10);
        for (int i = 0; i < o.V; i++) {
            for (int j = 0; j < o.V; j++) {
                if (i == j) {
                    continue;
                }
                if (Math.random() < 0.25) {
                    o.add(i, j);
                }
            }
            debug("o.G[" + i + "]", o.G[i]);
        }

        debug("o.scc()", o.scc());

        debug("o.cmp", o.cmp);
    }

    private static final boolean DEBUG = true;

    private static final void debug(Object... o) {
        if (DEBUG)
            System.err.println(Arrays.deepToString(o));
    }

    private static final void message(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }

}
