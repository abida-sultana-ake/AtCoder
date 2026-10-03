import java.io.*;
import java.util.*;

public class Main implements Runnable {

    private void solve() throws IOException {

        int N = nextInt();

        UF uf = new UF(N);
        Pair[] pA = new Pair[N];
        Pair[] pB = new Pair[N];

        ArrayList<Edge> p = new ArrayList<>();

        for(int i = 0; i < N; ++i) {
            int x = nextInt();
            int y = nextInt();
            pA[i] = new Pair(i, x);
            pB[i] = new Pair(i, y);
        }
        Arrays.sort(pA);
        Arrays.sort(pB);

        for(int i = 0; i < N - 1; ++i) {
            p.add(new Edge(pA[i].id,pA[i+1].id,Math.abs(pA[i].value-pA[i+1].value)));
            p.add(new Edge(pB[i].id,pB[i+1].id,Math.abs(pB[i].value-pB[i+1].value)));
        }
        Collections.sort(p);
        long ret = 0L;
        for(int i = 0; i < p.size(); ++i) {
            Edge e = p.get(i);
            if(!uf.isSame(e.from,e.to)) {
                uf.union(e.from,e.to);
                ret += e.value;
            }
        }
        writer.println(ret);
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int value;

        public Edge(int from,int to,int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    static class UF {
        int N;
        int[] elem;
        int[] rank;

        public UF(int N) {
            this.N = N;
            elem = new int[N];
            rank = new int[N];

            for(int i = 0; i < N; ++i) {
                elem[i] = i;
                rank[i] = 1;
            }
        }

        public int getRoot(int x) {
            if(elem[x] == x) return x;
            else return elem[x] = getRoot(elem[x]);
        }

        public boolean isSame(int x,int y) {
            return getRoot(x) == getRoot(y);
        }

        public void union(int x,int y) {
            int xRoot = getRoot(x);
            int yRoot = getRoot(y);
            if(xRoot == yRoot) return;

            if(rank[xRoot] > rank[yRoot]) {
                rank[xRoot] += rank[yRoot];
                elem[yRoot] = xRoot;
            } else {
                rank[yRoot] += rank[xRoot];
                elem[xRoot] = yRoot;
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int id;
        int value;

        public Pair(int id,int value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
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
//            reader = new BufferedReader(new FileReader("input.txt"));
            //            reader2 = new BufferedReader(new FileReader("1.in"));
            tokenizer = null;
            writer = new PrintWriter(System.out);
//            writer = new     PrintWriter("output.txt");
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