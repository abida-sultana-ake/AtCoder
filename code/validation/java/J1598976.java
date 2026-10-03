import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String arg[]) throws IOException { new Main().bw.close(); }

  BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  StringTokenizer st = null;
  String nxttok() { 
    try { while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine()); }
    catch(Exception e) { return "";}
    return st.nextToken();
  }

  int nxtint() { return  Integer.parseInt(nxttok()); }
  long nxtlong() { return Long.parseLong(nxttok()); }

  int maxn = 333;
  int n;
  int[][] gr = new int[maxn][maxn];

  class Edge {
    int u;
    int v;
    int c;
    Edge(int u, int v, int c) {
      this.u = u; this.v = v; this.c = c;
    }
  }

  ArrayList<Edge> el;

  Main() throws IOException {
    n = nxtint();
    for (int i =-1; ++ i < n; )
      for (int f = -1; ++f < n; )
        gr[i][f] = nxtint();
    el = new ArrayList<Edge>();
    for (int i = -1; ++ i < n; )
      for (int f = i; ++f < n; )
        el.add(new Edge(i, f, gr[i][f]));
    el.sort((u, v) -> u.c - v.c);
    long ans = 0;
    for (Edge e: el) {
      int u = e.u, v = e.v, c = e.c;
      boolean founde = false;
      for (int i = -1; ++i < n; ) {
        if (i == u || i == v) continue;
        if (gr[u][i] > c || gr[v][i] > c) continue;
        if (gr[u][i] + gr[v][i] < c) {
          bw.write("-1");
          return;
        }
        if (gr[u][i] + gr[v][i] == c) founde = true;
      }
      if (!founde) ans += c;
    }
    bw.write(ans + "\n");
  }
}
