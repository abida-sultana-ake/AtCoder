import java.util.*;
import java.io.*;
import java.math.*;


import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;


public class Main{ 


    static long mod=1000000007;
     // static int dx[]={1,-1,0,0};
     //  static int dy[]={0,0,1,-1};
    // static int dx[]={1,-1,0,0,1,1,-1,-1};
    // static int dy[]={0,0,1,-1,1,-1,1,-1};
    // PriorityQueue<Integer> que = new PriorityQueue<Integer>(); 

public  static void main(String[] args)   throws Exception, IOException{

    
    Reader sc = new Reader(System.in);
    PrintWriter out=new PrintWriter(System.out);

    //  int n=sc.nextInt();  
    int n=sc.nextInt();  
    int c[] = new int[3*n];
    long right[] = new long[3*n];
    long left[] = new long[3*n];
    int tn=3*n;
    PriorityQueue<Integer> que = new PriorityQueue<Integer>(); 

    for( int i=0; i<n*3; i++ ){
        c[i] = sc.nextInt();
    }
    
    
    for( int i=0; i<2*n; i++ ){
        que.add(c[i]);
        left[i] = c[i];
        if(i>0) left[i] += left[i-1];
        if(i >= n){
            left[i] -= que.poll();
        }
    }
    que.clear();
    for( int i=0; i<2*n; i++ ){
        int t = 3*n - i - 1;
        que.add(-c[t]);
        right[t] = c[t];
        if(i>0) right[t] += right[t+1];
        if(i >= n){
            right[t] += que.poll();
        }
    }
    long ans=left[n-1]-right[n];
    for( int i=n; i<2*n; i++ ){
        ans = max(ans, left[i] - right[i+1]);
    }

    out.println(ans);
    out.flush();
}

static void rep(int x, long d){

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

