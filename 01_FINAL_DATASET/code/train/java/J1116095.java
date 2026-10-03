import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ConsoleIO io = new ConsoleIO(new InputStreamReader(System.in), new PrintWriter(System.out));
        //ConsoleIO io = new ConsoleIO(new FileReader("D:\\fbhc\\fighting_all_the_zombies_example_input.txt"), new PrintWriter(new File("D:\\fbhc\\out.txt")));

        new Main(io).solve();
        io.close();
    }
    ConsoleIO io;
    Main(ConsoleIO io) {
        this.io = io;
    }

    long MOD = 1_000_000_007;
    int N, M, W, K, Q;
    List<List<Integer>> gr = new ArrayList<>();

    int[] tts;
    int[] par;
    int[] deg;

    public void solve() {
        int n = Integer.parseInt(io.readLine());
        char[] c = io.readLine().toCharArray();
        int[] a = new int[n];
        N = n;
        for(int i = 0;i<4;i++) {
            a[0] = i & 1;
            a[1] = (i >> 1) & 1;
            for (int j = 2; j < n; j++) {
                a[j] = c[j - 1] == 'o' ? a[j - 2] ^ a[j - 1] : a[j - 2] ^ (1 - a[j - 1]);
            }

            if ((c[N - 1] == 'o' ? a[N - 2] ^ a[N - 1] : a[N - 2] ^ (1 - a[N - 1])) == a[0] && (c[0] == 'o' ? a[N - 1] ^ a[0] : a[N - 1] ^ (1 - a[0])) == a[1]) {
                io.writeLine(getAns(a));
                return;
            }

        }
        io.writeLine("-1");
    }
    String getAns(int[] a){
        char[] res= new char[a.length];
        for(int i = 0;i<res.length;i++)res[i]=a[i]==0?'S':'W';
        return new String(res);
    }
}

class ConsoleIO {
    BufferedReader br;
    PrintWriter out;
    public ConsoleIO(Reader reader, PrintWriter writer){br = new BufferedReader(reader);out = writer;}
    public void flush(){this.out.flush();}
    public void close(){this.out.close();}
    public void writeLine(String s) {this.out.println(s);}
    public void writeInt(int a) {this.out.print(a);this.out.print(' ');}
    public void writeWord(String s){
        this.out.print(s);
    }
    public void writeIntArray(int[] a, int k, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (i > 0) sb.append(separator);
            sb.append(a[i]);
        }
        this.writeLine(sb.toString());
    }
    public int read(char[] buf, int len){try {return br.read(buf,0,len);}catch (Exception ex){ return -1; }}
    public String readLine() {try {return br.readLine();}catch (Exception ex){ return "";}}
    public long[] readLongArray() {
        String[]n=this.readLine().trim().split("\\s+");long[]r=new long[n.length];
        for(int i=0;i<n.length;i++)r[i]=Long.parseLong(n[i]);
        return r;
    }
    public int[] readIntArray() {
        String[]n=this.readLine().trim().split("\\s+");int[]r=new int[n.length];
        for(int i=0;i<n.length;i++)r[i]=Integer.parseInt(n[i]);
        return r;
    }
    public int[] readIntArray(int n) {
        int[] res = new int[n];
        char[] all = this.readLine().toCharArray();
        int cur = 0;boolean have = false;
        int k = 0;
        boolean neg = false;
        for(int i = 0;i<all.length;i++){
            if(all[i]>='0' && all[i]<='9'){
                cur = cur*10+all[i]-'0';
                have = true;
            }else if(all[i]=='-') {
                neg = true;
            }
            else if(have){
                res[k++] = neg?-cur:cur;
                cur = 0;
                have = false;
                neg = false;
            }
        }
        if(have)res[k++] = neg?-cur:cur;
        return res;
    }
    public int ri() {
        try {
            int r = 0;
            boolean start = false;
            boolean neg = false;
            while (true) {
                int c = br.read();
                if (c >= '0' && c <= '9') {
                    r = r * 10 + c - '0';
                    start = true;
                } else if (!start && c == '-') {
                    start = true;
                    neg = true;
                } else if (start || c == -1) return neg ? -r : r;
            }
        } catch (Exception ex) {
            return -1;
        }
    }
    public long readLong() {
        try {
            long r = 0;
            boolean start = false;
            boolean neg = false;
            while (true) {
                int c = br.read();
                if (c >= '0' && c <= '9') {
                    r = r * 10 + c - '0';
                    start = true;
                } else if (!start && c == '-') {
                    start = true;
                    neg = true;
                } else if (start || c == -1) return neg ? -r : r;
            }
        } catch (Exception ex) {
            return -1;
        }
    }
    public String readWord() {
        try {
            boolean start = false;
            StringBuilder sb = new StringBuilder();
            while (true) {
                int c = br.read();
                if (c!= ' ' && c!= '\r' && c!='\n' && c!='\t') {
                    sb.append((char)c);
                    start = true;
                } else if (start || c == -1) return sb.toString();
            }
        } catch (Exception ex) {
            return "";
        }
    }
    public char readSymbol() {
        try {
            while (true) {
                int c = br.read();
                if (c != ' ' && c != '\r' && c != '\n' && c != '\t') {
                    return (char) c;
                }
            }
        } catch (Exception ex) {
            return 0;
        }
    }
    //public char readChar(){try {return (char)br.read();}catch (Exception ex){ return 0; }}
}