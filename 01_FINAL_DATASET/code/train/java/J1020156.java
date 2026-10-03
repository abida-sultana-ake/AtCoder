import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main implements Runnable {

    Set<Integer> smaller = new HashSet<Integer>();
    Set<Integer> bigger = new HashSet<Integer>();
    int adder = 100_000;
    int[] color = new int[200001];
    HashMap<Integer,Integer> dp;

    int id = 1;
    int N;
    boolean[] used;
    int[] ret;
    ArrayList<Integer>[] adj = new ArrayList[200005];
    ArrayList<Integer>[] dj = new ArrayList[200005];
    ArrayList<Integer> comp;
    private void solve() throws IOException {


        for(int i = 0; i <= 200004; ++i) adj[i] = new ArrayList<>();
        for(int i = 0; i <= 200004; ++i) dj[i] = new ArrayList<>();
        N = nextInt();
        ret = new int[ N + 1];
        used = new boolean[ N + 1 + 200000];
        int K = nextInt();
        int L = nextInt();

        for(int k = 0; k < K; ++k) {
            int a = nextInt();
            int b = nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i = 1; i <= N; ++i) {
            if(!used[i])  {
                dfs(i);
                ++id;
            }
        }
        for(int l = 0; l < L; ++l) {
            int a = nextInt();
            int b = nextInt();
            dj[a].add(b);
            dj[b].add(a);
        }

        Arrays.fill(used, false);

        for(int i = 1; i <= N; ++i) {
            if(!used[i]) {
                comp = new ArrayList<>();
                dp = new HashMap<>();
                dfs2(i);
                for(int elem : comp) {
                    ret[elem] += dp.get(color[elem]);
                }
            }
        }

        writer.print(ret[1]);
        for(int i = 2; i <= N; ++i) writer.print(" " + ret[i]);
        writer.println();

    }

    private void dfs2(int v) {
        used[v] = true;
        comp.add(v);
        if(!dp.containsKey(color[v])) {
            dp.put(color[v],1);
        } else {
            dp.put(color[v],dp.get(color[v])+1);
        }
        for(int to : dj[v]) {
            if(!used[to]) dfs2(to);
        }
    }

    private void dfs(int v) {
        used[v] = true;
        color[v] = id;
        for(int to : adj[v]) {
            if(!used[to]) {
                dfs(to);
            }
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }

    BufferedReader reader;
    //    BufferedReader reader2;
    StringTokenizer tokenizer;
    PrintWriter writer;
    //    BufferedWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
//            reader = new BufferedReader(new FileReader("trees.in"));
            //            reader2 = new BufferedReader(new FileReader("1.in"));
            tokenizer = null;
            writer = new PrintWriter(System.out);
//            writer = new     PrintWriter("trees.out");
//                                                    writer = new BufferedWriter(System.out);
            //                        writer = new BufferedWriter(new OutputStreamWriter(System.out));
            solve();
            reader.close();
            //            reader2.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    short nextShort() throws IOException {
        return Short.parseShort(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }

        return tokenizer.nextToken();
    }

}