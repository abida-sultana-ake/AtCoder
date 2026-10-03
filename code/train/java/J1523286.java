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
        public static void output() throws IOException
        {
        	int n = ri();
        	HashMap<Integer,Integer> ctr = new HashMap<Integer,Integer>() ;
        	for(int i =  0;i<n ; i++)
        	{
        		int x =ri();
        		if(ctr.containsKey(x))
        		{
        			ctr.put(x,ctr.get(x)+1) ;
        		}
        		else
        		{
        			ctr.put(x,1) ;
        		}
        	}
        	int side1 = 0 ;
        	for(int i : ctr.keySet())
        	{
        		if(ctr.get(i)>=2&&i>side1)
        		{
        			side1 = i ;
        		}
        	}
        	if(side1!=0)
        	{
        		ctr.put(side1,ctr.get(side1)-2) ;
        	}
        	int side2 = 0 ;
        	for(int i : ctr.keySet())
        	{
        		if(ctr.get(i)>=2&&i>side2)
        		{
        			ctr.put(i,ctr.get(i)-2) ;
        			side2 = i ;
        		}
        	}
        	println((long)side1*(long)side2) ;
        }
}

