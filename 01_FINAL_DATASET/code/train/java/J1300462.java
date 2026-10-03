//package com.zhangyong.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    FastScanner in;
    PrintWriter out;

    class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        private FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

    private void solve() {
        int n, m;
        n = in.nextInt();
        m = in.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = in.next();
        }
        for (int i = 0; i < m + 2; i++) {
            if (i != m + 1) {
                out.print("#");
            } else {
                out.println("#");
            }
        }
        for (int i = 0; i < n; i++) {
            out.print("#");
            out.print(str[i]);
            out.println("#");
        }
        for (int i = 0; i < m + 2; i++) {
            out.print("#");
        }
    }

    private void run() {
        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
