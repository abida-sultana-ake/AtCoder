import java.io.*;
import java.util.*;

public class Main {
    static ContestScanner in;
    static Writer out;
    public static void main(String[] args) {
        Main main = new Main();
        try {
            in = new ContestScanner();
            out = new Writer();
            main.solve();
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        List<Edge>[] node = new List[n];
        for (int i = 0; i < n; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            long c = in.nextInt();
            node[a].add(new Edge(b, -c));
        }
        long[] cost = bellman_ford(node, n, m);
        if(lastC[n - 1] == n - 1) {
            System.out.println("inf");
            return;
        }
        System.out.println(-cost[n - 1]);
    }

    int[] lastC;
    long[] bellman_ford(List<Edge>[] node, int n, int m){ // edge*2
        int[] from = new int[m];
        int[] to = new int[m];
        long[] cost = new long[m];
        int eid = 0;
        for(int i=0; i<n; i++){
            for(Edge e: node[i]){
                from[eid] = i;
                to[eid] = e.to;
                cost[eid] = e.cost;
                eid++;
            }
        }
        long[] res = new long[n];
        final long inf = Long.MAX_VALUE/2;
        Arrays.fill(res, inf);
        res[0] = 0;
        boolean changed = true;
        lastC = new int[n];
        for (int j = 0; j < n && changed; j++) {
            changed = false;
            for(int i=0; i<m; i++){
                if(res[to[i]]>res[from[i]]+cost[i]){
                    lastC[to[i]] = j;
                    changed = true;
                    res[to[i]] = res[from[i]]+cost[i];
                }
            }
        }
        return res;
    }
}

class Edge{
    int to;
    long cost;
    Edge(int to, long cost){
        this.to = to;
        this.cost = cost;
    }
}

@SuppressWarnings("serial")
class MultiSet<T> extends HashMap<T, Long>{
    @Override public Long get(Object key){return containsKey(key)?super.get(key):0L;}
    public void add(T key,long v){put(key,get(key)+v);}
    public void add(T key){put(key,get(key)+1);}
    public void sub(T key){final long v=get(key);if(v==1)remove(key);else put(key,v-1);}
    public MultiSet<T> merge(MultiSet<T> set)
    {MultiSet<T>s,l;if(this.size()<set.size()){s=this;l=set;}else{s=set;l=this;}
        for(Entry<T,Long>e:s.entrySet())l.add(e.getKey(),e.getValue());return l;}
}

class Writer extends PrintWriter{
    public Writer(String filename)throws IOException
    {super(new BufferedWriter(new FileWriter(filename)));}
    public Writer()throws IOException{super(System.out);}
}
class ContestScanner implements Closeable{
    private BufferedReader in;private int c=-2;
    public ContestScanner()throws IOException
    {in=new BufferedReader(new InputStreamReader(System.in));}
    public ContestScanner(String filename)throws IOException
    {in=new BufferedReader(new InputStreamReader(new FileInputStream(filename)));}
    public String nextToken()throws IOException {
        StringBuilder sb=new StringBuilder();
        while((c=in.read())!=-1&&Character.isWhitespace(c));
        while(c!=-1&&!Character.isWhitespace(c)){sb.append((char)c);c=in.read();}
        return sb.toString();
    }
    public String readLine()throws IOException{
        StringBuilder sb=new StringBuilder();if(c==-2)c=in.read();
        while(c!=-1&&c!='\n'&&c!='\r'){sb.append((char)c);c=in.read();}
        return sb.toString();
    }
    public long nextLong()throws IOException,NumberFormatException
    {return Long.parseLong(nextToken());}
    public int nextInt()throws NumberFormatException,IOException
    {return(int)nextLong();}
    public double nextDouble()throws NumberFormatException,IOException
    {return Double.parseDouble(nextToken());}
    public void close() throws IOException {in.close();}
}
