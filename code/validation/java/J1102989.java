import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScannerA fs = new FastScannerA();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt(), m = fs.nextInt();
        if(n == 1 && m == 1) {
            System.out.println("Draw");
        } else if(n == 1) {
            System.out.println("Alice");
        } else if(m == 1) {
            System.out.println("Bob");
        } else {
            if(n > m) {
                System.out.println("Alice");
            } else if(n < m) {
                System.out.println("Bob");
            } else {
                System.out.println("Draw");
            }
        }

        out.close();
    }
}

class FastScannerA {
    BufferedReader br;
    StringTokenizer st;

    public FastScannerA() {
        try	{
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        } catch (Exception e){e.printStackTrace();}
    }

    public String next() {
        if (st.hasMoreTokens())	return st.nextToken();
        try {st = new StringTokenizer(br.readLine());}
        catch (Exception e) {e.printStackTrace();}
        return st.nextToken();
    }

    public int nextInt() {return Integer.parseInt(next());}

    public long nextLong() {return Long.parseLong(next());}

    public double nextDouble() {return Double.parseDouble(next());}

    public String nextLine() {
        String line = "";
        try {line = br.readLine();}
        catch (Exception e) {e.printStackTrace();}
        return line;
    }

    public Integer[] nextIntegerArray(int n) {
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++) a[i] = nextInt();
        return a;
    }

    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = nextInt();
        return a;
    }

    public char[] nextCharArray() {
        return nextLine().toCharArray();
    }
}