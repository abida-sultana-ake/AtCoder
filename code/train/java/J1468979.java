    import java.io.*;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            boolean local = false;
            if (args.length > 0 && args[0].equals("LOCAL"))
                local = true;

            new Main(local).go();
        }

        boolean LOCAL;
        PrintWriter out;
        Reader in;
        BufferedReader br;

        Main(boolean local) throws IOException {

            this.LOCAL = local;

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

            if (this.LOCAL)
                t = in.nextInt();

            while (t > 0) {

                solve();
                t--;

                if (LOCAL)
                    out.println();

            }

            out.flush();
            out.close();
        }


        int inf = 2000000000;
        int mod = 1000000007;
        double eps = 1e-9;

        int n;
        int m;

        ArrayList<Integer>[] g = new ArrayList[200010];

        void solve() throws IOException {


            long k = in.nextLong();

            long[] ans = new long[50];

            long x = k / 50;
            if (k % 50 != 0)
                x++;

            for (int i = 0; i < 50; i++) {
                ans[i] = 50-i+x-1;
            }

            long mod = (x*50) - k;

            //System.err.println(mod);

            for (int i = 0; i < mod; i++)
                ans[50-i-1]--;

            out.println(50);
            for (int i = 0; i < 50; i++)
                out.print(ans[i]+" ");

        }


        class Edge implements Comparable<Edge> {

            int a;
            int b;
            int c;
            int i;

            Edge(int a, int b, int c, int i) {

                this.a = a;
                this.b = b;
                this.c = c;
                this.i = i;
            }

            public int compareTo(Edge p) {

                if (c > p.c) return 1;
                if (c < p.c) return -1;
                if (i > p.i) return 1;
                if (i < p.i) return -1;
                return 0;
            }
        }

        class Pair implements Comparable<Pair>{

            int a;
            int b;

            Pair(int a, int b) {

                this.a = a;
                this.b = b;
            }

            public int compareTo(Pair p) {

    //            if (a > p.a) return 1;
    //            if (a < p.a) return -1;
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