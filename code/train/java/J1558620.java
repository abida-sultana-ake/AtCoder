import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        new Main().go();
    }

    PrintWriter out;
    Reader in;
    BufferedReader br;

    Main() throws IOException {

        try {

            //br = new BufferedReader( new FileReader("input.txt") );
            in = new Reader("input.txt");
            out = new PrintWriter( new BufferedWriter(new FileWriter("output.txt")) );
        }
        catch (Exception e) {

            //br = new BufferedReader( new InputStreamReader( System.in ) );
            in = new Reader();
            out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)) );
        }
    }

    void go() throws IOException {

        int t = 1;
        while (t > 0) {
            solve();
            //out.println();
            t--;
        }

        out.flush();
        out.close();
    }

    int inf = 2000000000;
    int mod = 1000000007;
    double eps = 0.00000001;

    int n;
    int m;

    //ArrayList<Integer>[] g = new ArrayList[200010];


    void solve() throws IOException {

        int n = in.nextInt();
        int[] cnt = new int[100010];

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            cnt[x]++;
            cnt[x+1]++;
            if (x > 0)
                cnt[x-1]++;
        }

        int max = 0;
        for (int i = 0; i < 100010; i++)
            max = Math.max(max, cnt[i]);

        out.println(max);
    }


    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    class Pair implements Comparable<Pair>{

        int a;
        int b;

        Pair(int a, int b) {

            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair p) {

            if (a > p.a) return 1;
            if (a < p.a) return -1;
            if (b > p.b) return 1;
            if (b < p.b) return -1;
            return 0;
        }
    }

    class Item {

        int a;
        int b;
        int c;

        Item(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }

    class Reader {

        BufferedReader  br;
        StringTokenizer tok;

        Reader(String file) throws IOException {
            br = new BufferedReader( new FileReader(file) );
        }

        Reader() throws IOException {
            br = new BufferedReader( new InputStreamReader(System.in) );
        }

        String next() throws IOException {

            while (tok == null || !tok.hasMoreElements())
                tok = new StringTokenizer(br.readLine());
            return tok.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException {
            return Integer.valueOf(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.valueOf(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.valueOf(next());
        }


        String nextLine() throws IOException {
            return br.readLine();
        }

    }

}