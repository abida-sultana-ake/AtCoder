import java.util.* ;
import java.io.* ;
public class Main
{
		static BufferedReader reader;
        static StringTokenizer tokenizer;
        static void init(InputStream input)
        {
            reader = new BufferedReader( new InputStreamReader(input) );
            tokenizer = new StringTokenizer("");
        }
        static String next() throws IOException
        {
            while ( ! tokenizer.hasMoreTokens() )
            {
                tokenizer = new StringTokenizer(reader.readLine() );
            }
            return tokenizer.nextToken();
        }
     
        static long nextInt() throws IOException
        {
            return Long.parseLong( next() );
        }
        public static int ri() throws IOException
        {
        	return (int)nextInt() ;
        }
        public static long rl() throws IOException
        {
        	return nextInt() ;
        }
        public static double rd() throws NumberFormatException, IOException
        {
        	return Double.parseDouble(next()) ;
        }
        static void print_a(int [] arr)
        {
        	for(int i = 0 ;i<arr.length ; i++)
        	{
        		print(arr[i]+" ") ;
        	}
        	println() ;
        }
        public static int [] ria() throws IOException
        {
        	int n = ri() ;
        	int [] a = new int[n] ;
        	for(int i = 0 ; i<n ; i++)
        	{
        		a[i] = ri() ;
        	}
        	return a ;
        }
        public static long [] rla() throws IOException
        {
        	int n = ri() ;
        	long [] a = new long[n] ;
        	for(int i =0 ; i<n ; i++)
        	{
        		a[i] = rl() ;
        	}
        	return a ;
        }
        public static int p(int i)
        {
        	return (int)Math.pow(2,i) ;
        }
        static PrintWriter writer;
        static void outit(OutputStream outputStream)
        {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
        static void print(Object...objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }
     
        static void println(Object...objects) {
            print(objects);
            writer.println();
        }
     
        static void close() {
            writer.close();
        }
     
        static void flush() {
            writer.flush();
        }
        public static void main(String [] args) throws IOException
        {
            init(System.in) ;
            outit(System.out) ;
    //    	int t = (int)nextInt() ;
    //    	for(int i =0 ; i<t ; i++)
            output() ;
            flush();
            close();
        }
        static int n ;
        static String s1 ;
        static String s2 ;
        static long [][] cache ;
        static long mod = 1000000007 ;
        public static void output() throws IOException
        {
        	n = ri();
        	s1 = next() ;
        	s2 = next() ;
        	cache = new long[n][2] ;
        	for(int i = 0 ;i<n ; i++)
        	{
        		cache[i][0] =-1 ;
        		cache[i][1] =-1 ;
        	}
        	if(n==1)
        	{
        		println(3) ;
        		return ;
        	}
        	if(check2(0))
        	{
        		println((((long)6)*dp(2,1))%mod) ;
        	}
        	else
        	{
        		println((((long)3)*dp(1,0))%mod) ;
        	}
        }
        public static long dp(int ind,int state)
        {
        	if(ind==n)
        	{
        		return (long)1 ;
        	}
        	if(ind==n-1)
        	{
        		if(state==0)
        		{
        			return (long)2 ;
        		}
        		else
        		{
        			return (long)1 ;
        		}
        	}
        	if(cache[ind][state]!=-1)
        	{
        		return cache[ind][state] ;
        	}
        	long ret = 1 ;
        	if(check2(ind))
        	{
        		if(state==0)
        		{
        			ret = (((long)2)*dp(ind+2,1))%mod ;
        		}
        		else
        		{
        			ret = (((long)3)*dp(ind+2,1))%mod ;
        		}
        	}
        	else
        	{
        		if(state==0)
        		{
        			ret =  (((long)2)*dp(ind+1,0))%mod ;
        		}
        		else
        		{
        			ret =  dp(ind+1,0) ;
        		}
        	}
        	return ret ;
        }
        static boolean check2(int i)
        {
        	if(s1.charAt(i)==s1.charAt(i+1)&&s2.charAt(i)==s2.charAt(i+1))
        	{
        		return true ;
        	}
        	else
        	{
        		return false ;
        	}
        }
}

