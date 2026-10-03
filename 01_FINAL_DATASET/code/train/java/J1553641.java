import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;

public class Main
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
 
    public static void main(String[] args)
    {
        FastReader s=new FastReader();
        int n=s.nextInt();
        long a[]=new long[n];
        int c=0;
        ArrayList<Long> arr =new ArrayList<Long>(2);
        for(int i=0;i<n;i++)
            a[i]=s.nextLong();
        Arrays.sort(a);
        for(int i=n-1;i>0;i--)
        {
            if(c==2)
                break;
            if(a[i]==a[i-1])
            {
                i--;
                arr.add(a[i]);
                c++;
                
            }  
        }
        if(c==2)
            System.out.println(arr.get(0)*arr.get(1));
        else
            System.out.println("0");
    }
}
        