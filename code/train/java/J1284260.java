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

public  static void main(String[] args)   throws Exception, IOException{

    
    Reader sc = new Reader(System.in);
    PrintWriter out=new PrintWriter(System.out);

//  int n=sc.nextInt();  
  // int n=sc.nextInt(), m=sc.nextInt();  
  int n=sc.nextInt();  
  int m=sc.nextInt();  
  long d[]=new long[n], ans=0;
  int ed[] = new int[n];
  int from[] = new int[m];
  int to[] = new int[m];
  long c[] = new long[m],inf=(1L<<55);
  for( int i=0; i<n; i++ ){d[i] = inf;}
    for( int i=0; i<m; i++ ){
    int x=sc.nextInt()-1;
    int y=sc.nextInt()-1;
        from[i] = x;
        to[i] = y;
        c[i] = -sc.nextLong();
    }

    d[0]=0;
    int lp=0;
    long q=-1,p=q;
    while(true){
        boolean b=false;
        lp++;
        for( int i=0; i<m; i++ ){
            int fr = from[i];
            int t = to[i];
            if( d[fr] != inf && d[t] > d[fr] + c[i]){
                d[t] = d[fr] + c[i];
                b=true;
            }
        }
        q=d[n-1];
        if(!b){ans=-d[n-1]; break;}
        if(lp > 2010 ){
    if(q<p)out.println("inf");
    else out.println(-d[n-1]);
    out.flush();

    return;
}
p=q;
        // db(d);
    }
    // if(ans==0)
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

