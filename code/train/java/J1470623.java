import java.util.*;
import java.io.*;
import java.math.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class Main{
    static long mod=1000000007;
    // static int dx[]={1,-1,0,0};
    // static int dy[]={0,0,1,-1};
    // static int dx[]={1,-1,0,0,1,1,-1,-1};
    // static int dy[]={0,0,1,-1,1,-1,1,-1};
    // PriorityQueue<Integer> que = new PriorityQueue<Integer>(); 
    //HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    //ArrayList<Integer> lis = new ArrayList<Integer>();
    public  static void main(String[] args)   throws Exception, IOException{
        Reader sc = new Reader(System.in);
        PrintWriter out=new PrintWriter(System.out);

        // int n=sc.nextInt();
        long k=sc.nextLong();
        long r=50-k%50,q=k/50,d[]=new long[50];
        for( int i=0; i<50; i++ ){
            d[i] = i+1;
        }
        // r%=50;
        for( int i=0; i<r; i++ ){
            d[i]--;
        }
        out.println(50);
        if(k==0)fill(d,0);
        for( int i=0; i<50; i++ ){
            out.print(d[i]+q);
            if(i<49)out.print(" ");
        }

        out.println(); 
        out.flush();
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

class Pair implements Comparable<Pair>{
    int x,y,id;
    Pair(int x, int y,int id) {
        this.x=x;
        this.y=y;
        this.id=id;
    } 
    public int compareTo(Pair p){
        return p.x -     x;
    } 
}

// class Pair implements Comparable<Pair>{
//     int x,y;
//     Pair(int x, int y) {
//         this.x=x;
//         this.y=y;
//     } 
//     public int compareTo(Pair p){//descend
//         return p.x - x;
//     } 

// }

class P implements Comparable<P>{
    int diff,id1,id2;
    P(int diff, int id1,int id2) {
        this.diff=diff;
        this.id1=id1;
        this.id2=id2;
    } 
      
    public int compareTo(P p){//ascend
        return diff - p.diff;
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