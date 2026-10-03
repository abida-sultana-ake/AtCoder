import java.util.*;
import java.io.*;
import java.math.*;


import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;


public class Main{ 


    static long mod=1000000007;
     static int dx[]={1,-1,0,0};
       static int dy[]={0,0,1,-1};
    // static int dx[]={1,-1,0,0,1,1,-1,-1};
    // static int dy[]={0,0,1,-1,1,-1,1,-1};
    // PriorityQueue<Integer> que = new PriorityQueue<Integer>(); 
    //HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

public  static void main(String[] args)   throws Exception, IOException{

    
    Reader sc = new Reader(System.in);
    PrintWriter out=new PrintWriter(System.out);

    //  int n=sc.nextInt();  
    int n=sc.nextInt();
    int k=sc.nextInt();
    long d[] = new long[n];
    long s[] = new long[n];
    long ans = 0;

    for( int i=0; i<n; i++ ){
        d[i] = sc.nextInt() - k;
        if(i>0) d[i]+=d[i-1];
        s[i] = d[i];
    }
    sort(s);
    s = unique_array(s);
    bit bit = new bit(s.length);
    for( int i=0; i<n; i++ ){
        int t = binarySearch(s, d[i]) + 1;
        ans +=  bit.sum(t);
        bit.add(t,1);
        if(d[i]>=0)ans++;
    }

    out.println(ans);
    out.flush();
}

static long[] unique_array(long d[]) {
    //d:sorted
    int id = 1;
    for( int i=1; i<d.length; i++ ){
        if(d[i]!=d[id-1]){
            d[id++] = d[i];
        }
    }
    return copyOf(d, id);
}

static void db(Object... os){

    System.err.println(Arrays.deepToString(os));

}

static boolean validpos(int x,int y,int r, int c){
    
    return x<r && 0<=x && y<c && 0<=y;
    
}
 
static boolean bit(long x,int k){
    // weather k-th bit (from right) be one or zero
    return  ( 0 < ( (x>>k) & 1 )  )  ? true:false;
}

}


class XY {
    int x,y,d;
    XY(int x, int y, int d) {
        this.x=x;
        this.y=y;
        this.d=d;
    } 
}

class P implements Comparable<P>{
    int x,y;
    P(int x, int y) {
        this.x=x;
        this.y=y;
    } 
      
    public int compareTo(P p){
        return x - p.x;
    } 
}

class bit {
    int b[],n;
    bit(int n){
        this.n = n;
        b = new int[n+1];
    }
    int sum(int i){
        int s = 0;
        while(i > 0){
            s += b[i];
            i -= i&-i;
        }
        return s;   
    }
    void add(int i, int x){
        while(i <= n){
            b[i] += x;
            i += i&-i;
        }
    }
}

class Reader
{ 
    private BufferedReader x;
    private StringTokenizer st;
    
    public Reader(InputStream in)
    {
        x = new BufferedReader(new InputStreamReader(in));
        st = null;
    }
    public String nextString() throws IOException
    {
        while( st==null || !st.hasMoreTokens() )
            st = new StringTokenizer(x.readLine());
        return st.nextToken();
    }
    public int nextInt() throws IOException
    {
        return Integer.parseInt(nextString());
    }
    public long nextLong() throws IOException
    {
        return Long.parseLong(nextString());
    }
    public double nextDouble() throws IOException
    {
        return Double.parseDouble(nextString());
    }
}

