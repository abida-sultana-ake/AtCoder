import java.util.*;

public class Main {
  static long[] depth;
  static ArrayList[] edge;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    depth = new long[n];
    edge = new ArrayList[n];
    for(int i = 0; i < n; i++) {
      edge[i] = new ArrayList<Edge>();
    }
    for(int i = 0; i < n - 1; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      long c = sc.nextLong();
      Edge e1 = new Edge(b, c);
      Edge e2 = new Edge(a, c);
      edge[a].add(e1);
      edge[b].add(e2); 
    }
    int Q = sc.nextInt();
    int K = sc.nextInt() - 1;
    dfs(K, -1, 0);
    for(int i = 0; i < Q; i++) {
      int x = sc.nextInt() - 1;
      int y = sc.nextInt() - 1;
      System.out.println(depth[x] + depth[y]);
    }
  }

  public static void dfs(int v, int parent, long d) {
    depth[v] = d;
    ArrayList<Edge> elist = edge[v];
    for(int i = 0; i < elist.size(); i++) {
      Edge e = elist.get(i);
      if(e.to != parent) dfs(e.to, v, e.cost + depth[v]); 
    } 
  }
}

class Edge {
  int to;
  long cost;
  Edge(int to, long cost) {
    this.to = to;
    this.cost = cost;
  }
}