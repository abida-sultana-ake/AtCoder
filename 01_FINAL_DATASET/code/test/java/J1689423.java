import java.io.*;
import java.util.*;

public class Main {
    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    static void solve()
    {
        int n = ni();
        int[] a = new int[3*n];
        for(int i = 0; i < 3*n; i++){
            a[i] = ni();
        }
        long ans = Long.MIN_VALUE;

        PriorityQueue<Integer> left = new PriorityQueue<Integer>();
        PriorityQueue<Integer> right = new PriorityQueue<Integer>(Collections.reverseOrder());
        long[] l = new long[n+1];
        long[] r = new long[n+1];

        for(int i = 0; i < n ; i++){
            left.add(a[i]);
            l[0] += a[i];
        }
        for(int i = 0; i < n ; i++){
            right.add(a[i+2*n]);
            r[0] += a[i+2*n];
        }

        for(int k = 1; k <= n; k++){
            left.add(a[n-1+k]);
            l[k] = l[k-1] + a[n-1+k] - left.poll();
            right.add(a[2*n-k]);
            r[k] = r[k-1] + a[2*n-k] - right.poll();
        }
        for(int i = 0; i <= n; i++){
            ans = Math.max(ans, l[i] - r[n-i]);
        }
        out.println(ans);
    }

    
    public static void main(String[] args) throws Exception
    {
        long S = System.currentTimeMillis();
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        
        solve();
        out.flush();
        long G = System.currentTimeMillis();
        tr(G-S+"ms");
    }

    
    private static boolean eof()
    {
        if(lenbuf == -1)return true;
        int lptr = ptrbuf;
        while(lptr < lenbuf)if(!isSpaceChar(inbuf[lptr++]))return false;
        
        try {
            is.mark(1000);
            while(true){
                int b = is.read();
                if(b == -1){
                    is.reset();
                    return true;
                }else if(!isSpaceChar(b)){
                    is.reset();
                    return false;
                }
            }
        } catch (IOException e) {
            return true;
        }
    }
    
    private static byte[] inbuf = new byte[1024];
    static int lenbuf = 0, ptrbuf = 0;
    
    private static int readByte()
    {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }
    
    private static boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
//  private static boolean isSpaceChar(int c) { return !(c >= 32 && c <= 126); }
    private static int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
    
    private static double nd() { return Double.parseDouble(ns()); }
    private static char nc() { return (char)skip(); }
    
    private static String ns()
    {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    
    private static char[] ns(int n)
    {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
    
    private static char[][] nm(int n, int m)
    {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }
    
    private static int[] na(int n)
    {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }
    
    private static int ni()
    {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    
    private static long nl()
    {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    
    private static void tr(Object... o) { if(INPUT.length() != 0)System.out.println(Arrays.deepToString(o)); }

    private static int[] nsi(){
        char[] s = ns().toCharArray();
        int[] a = new int[s.length];
        for(int j = 0; j < s.length; j++){
           a[j] = s[j] - '0';
        }
        return a;
    }
}