import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main implements Runnable {

    HashMap<Integer,Integer> roadComponent = new HashMap<>();
    HashMap<Integer,Integer> railComponent = new HashMap<>();

    ArrayList<Integer>[] road=  new ArrayList[200001];
    ArrayList<Integer>[] rail = new ArrayList[200001];
    boolean[] used = new boolean[200001];

    int componentId = 1;
    int N,K,L;
    private void solve() throws IOException {

        N = nextInt();
        K = nextInt();
        L = nextInt();

        for(int i = 0; i <= 200000; ++i) {
            road[i] = new ArrayList<>();
            rail[i] = new ArrayList<>();
        }

        for(int k = 0; k < K; ++k) {
            int a = nextInt();
            int b = nextInt();
            road[a].add(b);
            road[b].add(a);
        }
        componentId = 1;
        for(int i = 1; i <= N; ++i) {
            if(!used[i]) {
                dfs(i);
                ++componentId;
            }
        }
        componentId = 1;
        Arrays.fill(used, false);
        for(int l = 0; l < L; ++l) {
            int a = nextInt();
            int b = nextInt();
            rail[a].add(b);
            rail[b].add(a);
        }
        for(int i = 1; i <= N; ++i) {
            if(!used[i]) {
                dfs2(i);
                ++componentId;
            }
        }
        ArrayList<Data> g = new ArrayList<>();
        for(int i = 1; i <= N; ++i) {
            g.add(new Data(i,roadComponent.get(i),railComponent.get(i)));
        }

        Collections.sort(g);

        int currStart = 0;
        int[] result = new int[ N +  1];
        Data curr = new Data(-1,-1,-1);
        for(int i = 0; i < g.size(); ++i) {
            if(curr.railComp != g.get(i).railComp || curr.roadComp != g.get(i).roadComp) {
                for(int j = currStart; j < i; ++j) {
                    result[g.get(j).vertex] = i - currStart;
                }
                curr = g.get(i);
                currStart = i;
            }
        }
        for(int  j = currStart; j < g.size(); ++j) {
            result[g.get(j).vertex] = g.size() - currStart;
        }

        writer.print(result[1]);

        for(int i = 2; i <= N; ++i) writer.print(" " + result[i]);
        writer.println();

    }

    private void dfs2(int v) {
        used[v] = true;
        railComponent.put(v,componentId);
        for(int to : rail[v]) {
            if(!used[to]) dfs2(to);
        }
    }

    static class Data implements Comparable<Data> {
        int vertex;
        int roadComp;
        int railComp;

        public Data(int _vertex,int _roadComp,int _railComp) {
            vertex = _vertex;
            roadComp = _roadComp;
            railComp = _railComp;
        }

        @Override
        public int compareTo(Data o) {
            if(this.roadComp != o.roadComp) {
                return this.roadComp - o.roadComp;
            } else return this.railComp - o.railComp;
        }
    }

    private void dfs(int v) {
        used[v] = true;
        roadComponent.put(v,componentId);
        for(int to : road[v]) {
            if(!used[to]) dfs(to);
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