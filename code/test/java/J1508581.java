import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * author @sahil
 */
class edge{
    int v;
    long w;
    edge(int uu,long ww){
        v=uu;
        w=ww;
    }
}
public class Main {
    static ArrayList<edge> adj[];
    static int n;
    static boolean vis[];
    static long dist[];
    public static void add(int u,int v,long w){
        adj[u].add(new edge(v,w));
        adj[v].add(new edge(u,w));
    }
    public static void bfs(int k){
        Queue<Integer> q=new LinkedList<>();
        vis[k]=true;
        q.add(k);
        while(!q.isEmpty()){
            int u=q.poll();
            for(edge e:adj[u]){
                if(!vis[e.v]){
                    dist[e.v]=dist[u]+e.w;
                    vis[e.v]=true;
                    q.add(e.v);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj=(ArrayList<edge>[])new ArrayList[n];
        vis=new boolean[n];
        dist=new long[n];
        for(int i=0;i<n;++i){
            adj[i]=new ArrayList<edge>();
            vis[i]=false;
        }
        for(int i=1;i<n;++i){
            String s[]=br.readLine().split(" ");
            int u=Integer.parseInt(s[0])-1;
            int v=Integer.parseInt(s[1])-1;
            long w=Long.parseLong(s[2]);
            add(u,v,w);
        }
        String s[]=br.readLine().split(" ");
        int q=Integer.parseInt(s[0]);
        int k=Integer.parseInt(s[1])-1;
        bfs(k);
        for(int i=0;i<q;++i){
            s=br.readLine().split(" ");
            int u=Integer.parseInt(s[0])-1;
            int v=Integer.parseInt(s[1])-1;
            System.out.println(dist[u]+dist[v]);
        }
    }
}
