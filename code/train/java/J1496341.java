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
        long h = in.nextInt();
        long w = in.nextInt();
        long ans = h * w;
        // 最初縦に切る
        for (long i = w / 3; i <= w / 3 + 1; i++) {
            long a = i * h;
            long b = half(h, w - i);
            long c = h * w - (a + b);
            ans = Math.min(ans, diff(a, b, c));
        }
        for (long i = h / 3; i <= h / 3 + 1; i++) {
            long a = i * w;
            long b = half(h - i, w);
            long c = h * w - (a + b);
            ans = Math.min(ans, diff(a, b, c));
        }
        System.out.println(ans);
    }

    long diff(long a, long b, long c) {
        long min = Math.min(a, Math.min(b, c));
        long max = Math.max(a, Math.max(b, c));
        return max - min;
    }

    long half(long h, long w) {
        return Math.max((h / 2) * w, h * (w / 2));
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
