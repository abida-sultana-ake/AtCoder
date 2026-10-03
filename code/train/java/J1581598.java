import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;

class Main {
    static class Node implements Comparable<Node>{
        int x;
        long cost;
        public Node(int x,long cost){
            this.x=x;
        }
        public int compareTo(Node c){
            return Long.compare(this.cost,c.cost);
        }
    }
    //public static PrintWriter pw;
    public static PrintWriter pw = new PrintWriter(System.out);

    public static void solve() throws IOException {
//	pw=new PrintWriter(new FileWriter("C:\\Users\\shree\\Downloads\\small_output_in"));
        FastReader sc = new FastReader();
        int n=sc.I(); int m=sc.I(); int r=sc.I();
        a=new int[r+1];

        for(int i=1;i<=r;i++){
            a[i]=sc.I();

        }
        graph=new long[n+1][n+1];
        dist=new long[n+1][n+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(graph[i],Integer.MAX_VALUE);
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        for(int i=1;i<=m;i++){
            int x=sc.I(); int y=sc.I(); long cost=sc.L();
            graph[x][y]=cost;
            graph[y][x]=cost;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dist[i][j]=graph[i][j];
            }
        }
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        vis=new boolean[n+1];
        for(int i=1;i<=r;i++){
            dfs(a[i],0,r);
        }

        pw.println(ans);
        pw.close();

    }
    static int a[];
    static long  graph[][];
    static boolean vis[];
    static long ans=Long.MAX_VALUE;
    static long cnt=0;

    static long dist[][];
    static void dfs(int v,long cnt,int r){
        vis[v]=true;
        int cc=0;
        for(int i=1;i<=r;i++) if(vis[a[i]]) cc++;
        if(cc==r) ans=Math.min(ans,cnt);
        for(int i=1;i<=r;i++){
            if(!vis[a[i]]) dfs(a[i],cnt+dist[v][a[i]],r);
        }
        vis[v]=false;

    }
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                try {

                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();

    }

    static BufferedReader br;
    static long M = (long) 1e9 + 7;

    static class FastReader {

        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            //br=new BufferedReader(new FileReader("C:\\Users\\shree\\Downloads\\B-small-practice.in"));
            br = new BufferedReader(new InputStreamReader(System.in));

        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int I() {
            return Integer.parseInt(next());
        }

        long L() {
            return Long.parseLong(next());
        }

        double D() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public boolean hasNext() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return false;
                }
                st = new StringTokenizer(s);
            }
            return true;
        }

    }
}