import javax.rmi.CORBA.Util;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        String a, b, c;
        a = sc.next().toUpperCase();
        b = sc.next().toUpperCase();
        c = sc.next().toUpperCase();
        pw.println(a.charAt(0) + "" + b.charAt(0) + "" + c.charAt(0));
        pw.close();
    }


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
}