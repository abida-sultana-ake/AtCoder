/**
 * @Author Mehdi Maick
 * Created on 05/12/2016.
 */

import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Main {
    static int n;
    static int A;
    static int[] tab;
    static HashMap<String, Long> memo = new HashMap<>();

    static long f(int i, long sum, int inset) {
        if (i >= 0 && A * inset == sum) {
            System.err.println(inset + " " + sum);
            return 1L;
        }
        if (i < 0) return 0;
        String key = i + " " + sum + " " + inset;
        if (memo.containsKey(key)) return memo.get(key);
        long ans = f(i - 1, sum, inset);
        if (i >= 0)
            ans += f(i - 1, sum - tab[i], inset - 1);
        memo.put(key, ans);
        return ans;

    }

    public static void solve(FastReader fs, PrintWriter pw) {
        n = fs.nextInt();
        A = fs.nextInt();
        tab = new int[n];
        int mx = 2550;
        for (int i = 0; i < n; i++)
            tab[i] = fs.nextInt();
        long[][] f = new long[n + 1][3000];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = 0; k < mx; k++) {
                    f[j + 1][k + tab[i - 1]] += f[j][k];
                }
            }
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += f[i][i * A];
        }
        pw.println(ans);
    }

    public static void main(String[] args) throws Exception {
        FastReader fs = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        solve(fs, pw);

        fs.close();
        pw.close();
    }

    static class FastReader {

        BufferedReader reader;
        StringTokenizer st;

        FastReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        return null;
                    }
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String s = null;
            try {
                s = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
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

        char nextChar() {
            return next().charAt(0);
        }

        int[] nextIntArray(int n) {
            int[] arr = new int[n];
            int i = 0;
            while (i < n) {
                arr[i++] = nextInt();
            }
            return arr;
        }

        long[] nextLongArray(int n) {
            long[] arr = new long[n];
            int i = 0;
            while (i < n) {
                arr[i++] = nextLong();
            }
            return arr;
        }

        int[] nextIntArrayOneBased(int n) {
            int[] arr = new int[n + 1];
            int i = 1;
            while (i <= n) {
                arr[i++] = nextInt();
            }
            return arr;
        }

        long[] nextLongArrayOneBased(int n) {
            long[] arr = new long[n + 1];
            int i = 1;
            while (i <= n) {
                arr[i++] = nextLong();
            }
            return arr;
        }

        void close() {
            try {
                reader.close();
            } catch (IOException e) {
                System.err.println("There's been an error trying closing the reader ");
                e.printStackTrace();
            }
        }
    }


}