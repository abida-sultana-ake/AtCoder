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
        int r=sc.nextInt();
        int w=sc.nextInt();
        int c=sc.nextInt();
        int d[][]=new int[r][w];
        int e[]=new int[c];
        for( int i=0; i<c; i++ ){
            e[i]=sc.nextInt();
        }
        for( int i=0,id=1; i<w; i++ ){
            int st=i%2==0? 0:r-1, df=i%2==0?1:-1;
            for( int t=st,tt=0; tt<r; tt++,t+=df ){
                d[t][i]=id; e[id-1]--;
                if(e[id-1]==0)id++;
            }
        }
        for( int i=0; i<r; i++ ){
            for( int t=0; t<w; t++ ){
                out.print(d[i][t]); 
                if(t<w-1)out.print(" ");
                else out.println(); 
            }
        }

       
        // out.println(); 
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