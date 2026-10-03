import java.util.*;
import java.io.*;
import java.math.*;


import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;


public class Main{ 


    static long mod=1000000007;
    //  static int dx[]={1,-1,0,0};
    //  static int dy[]={0,0,1,-1};
    // static int dx[]={1,-1,0,0,1,1,-1,-1};
    // static int dy[]={0,0,1,-1,1,-1,1,-1}; 


public  static void main(String[] args)   throws Exception, IOException{

    
    Reader sc = new Reader(System.in);
    PrintWriter out=new PrintWriter(System.out);

  int n=sc.nextInt();
  int a=sc.nextInt();
  int b=sc.nextInt();

  int c[]=new int[n];
  int d[]=new int[n],mx=0;
  A x[]=new A[n];

  for( int i=0; i<n; i++ ){
       d[i]=sc.nextInt();
      if(a==1)continue;
       int k=d[i];
       while(k>0){c[i]++;k/=a;}
       x[i]=new A(d[i],c[i],log(d[i]));
       mx=max(mx,c[i]);
  }
  if(a>1)sort(x);
  sort(d);
  if(a==1){
     for( int i=0; i<n; i++ ){
    out.print(d[i]%mod);
    out.print(i<n-1?" ":"");
   }
    out.println( );
    out.flush();
    return;
  }
  // for( int i=0; i<n; i++ ){
  //   db(x[i].a,x[i].b,x[i].d);
  // }

  int e=0; double lg=log(a);
  for( int i=0; i<n; i++ ){e+=mx-c[i];x[i].b=0;}

  if(e>=b){
  for( int i=0; i<b; i++ ){
    x[0].b++; x[0].d+=lg; sort(x);
  }
  }
  else{
     for( int i=0; i<e; i++ ,b--){
    x[0].b++; x[0].d+=lg; sort(x);
  }
  for( int i=0; i<n; i++ ){x[i].b+=b/n;}
  for( int i=0; i< b%n; i++ ){x[0].b++; x[0].d+=lg;
   sort(x);

  }
 // for( int i=0; i<n; i++ ){
 //    db(x[i].a,x[i].b,x[i].d);
 //  }

  }
  
   for( int i=0; i<n; i++ ){
    long w=x[i].a,z=powerb(a,x[i].b,mod);
    out.print(w*z%mod);
    out.print(i<n-1?" ":"");
   }



    
      

    out.println( );
    out.flush();
}

public static long powerb(long base, long exponent, long mod) {
            if (exponent == 0)
                return 1 % mod;
            long result = powerb(base, exponent >> 1, mod);
            
            BigInteger a=new BigInteger(result+"");
            a=a.multiply(a);
            a=a.mod(new BigInteger(""+mod));
            result=a.longValue();
            
            if ((exponent & 1) != 0){
                a=a.multiply(new BigInteger(""+base));
                a=a.mod(new BigInteger(""+mod));
                result = a.longValue();}
            return result;
        }


 static long gcd(long a, long b){
                 if(min(a,b) == 0) return max(a,b);
                 return gcd(max(a, b) % min(a,b), min(a,b));
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



class A implements Comparable<A>{
  int a,b; double d;
  A(int a,int b,double d){
    this.a=a;
    this.b=b;
    this.d=d;
  }

  public int compareTo(A x){
     return (d-x.d)>0?1:-1; 
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

