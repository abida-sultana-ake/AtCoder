

/**
 * @Author Mehdi Maick
 * Created on 10/12/2016.
 */

import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {


    public static void solve(FastReader fs, PrintWriter pw) {
        char[] s = fs.next().toCharArray();
        boolean[] f = new boolean[s.length + 1];
        f[0] = true;
        for (int i = 1; i <= s.length; i++) {
            if (i >= 5) {
                if (s[i - 1] == 'm' && s[i - 2] == 'a' && s[i - 3] == 'e' && s[i - 4] == 'r' && s[i - 5] == 'd') {
                    f[i] |= f[i - 5];
//                    System.err.println("found dream");
                    if (i + 1 < s.length && s[i] == 'e' && s[i + 1] == 'r') {
                        f[i + 2] |= f[i];
//                        System.err.println("found dreamer");
                    }

                } else if (s[i - 1] == 'e' && s[i - 2] == 's' && s[i - 3] == 'a' && s[i - 4] == 'r' && s[i - 5] == 'e') {
                    f[i] |= f[i - 5];
//                    System.err.println("found ERASE");
                    if (i < s.length && s[i] == 'r') {
                        f[i + 1] |= f[i];
//                        System.err.println("found dreamer");
                    }

                }


            }
        }
//        pw.println(Arrays.toString(f));
        pw.println((f[s.length] ? "YES" : "NO"));

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