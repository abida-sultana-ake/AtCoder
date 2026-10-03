import java.io.*;
import java.util.*;

public class Main {


    static MyScanner sc;
    private static PrintWriter out;

    public static void main(String[] s) throws Exception {
        sc = new MyScanner(System.in);
//        sc = new MyScanner(new BufferedReader(new StringReader("5\n" +
//                "4 6 4 4 6\n" +
//                "1 2 \n" +
//                "2 3 \n" +
//                "3 4\n" +
//                "4 5")));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long t = System.currentTimeMillis();
        solve();
        out.flush();

    }


    private static void solve() {

        int n = sc.nextInt();
        int [] x = sc.na(n);


        int lg = 0;
        int res = 0;
        for (int k = 0 ; k  < n ; k++) {
            if (x[k] == k + 1) {
                lg++;
            } else {
                res += (lg + 1) / 2;
                lg = 0;
            }
        }
        res += (lg + 1) / 2;
        System.out.print(res);
    }




    private static void solveT() {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static long gcd(long l, long l1) {
        if (l > l1) return gcd(l1, l);
        if (l == 0) return l1;
        return gcd(l1 % l, l);
    }

    private static long pow(long a, long b, long m) {
        if (b == 0) return 1;
        if (b == 1) return a;
        long pp = pow(a, b / 2, m);
        pp *= pp;
        pp %= m;
        return (pp * (b % 2 == 0 ? 1 : a)) % m;
    }


    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(BufferedReader br) {
            this.br = br;
        }

        public MyScanner(InputStream in) {
            this(new BufferedReader(new InputStreamReader(in)));
        }

        void findToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        String next() {
            findToken();
            return st.nextToken();
        }

        int[] na(int n) {
            int[] k = new int[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.nextInt();
            }
            return k;
        }

        long[] nl(int n) {
            long[] k = new long[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.nextLong();
            }
            return k;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    private static final class BTree {
        private BNode root;

        public BTree(int[] r) {
            root = new BNode(r, 0, r.length - 1);
        }

        public void update(int fr, int to, int val) {
            root.update(fr, to, val);
        }

        public long val(int k) {
            return root.val(k);
        }

        private class BNode {
            long val;
            BNode left;
            BNode right;
            int from;
            int to;

            public BNode(int[] r, int from, int to) {
                this.from = from;
                this.to = to;
                if (from == to) {
                    val = r[from];
                } else {
                    int m = (to + from) / 2;
                    left = new BNode(r, from, m);
                    right = new BNode(r, m + 1, to);
                }
            }

            public long val(int index) {
                if (index == from && index == to) return val;
                if (index > to || index < from) return 0;
                return left.val(index) + right.val(index) + val;
            }

            public void update(int fr, int to, int val) {
                if (fr <= this.from && this.to <= to) {
                    this.val += val;
                    return;
                }
                if (this.to < fr || to < this.from) return;
                if (left != null) left.update(fr, to, val);
                if (right != null) right.update(fr, to, val);
            }
        }
    }


}