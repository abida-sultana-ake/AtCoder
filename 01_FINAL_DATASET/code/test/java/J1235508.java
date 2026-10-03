import java.io.*;
import java.util.*;

public class Main implements Runnable {

    private void solve() throws IOException {

        int N = nextInt();

        long a = 0;
        long b = 0;

        long s = 0;
        long s2 = 0;
        long[] cur = new long[N];
        for (int i = 0; i < N; ++i) {
            cur[i] = nextInt();
            s += cur[i];
            s2 += cur[i];

            if((i + 1 ) % 2 != 0) {
                // pos
                if(s <= 0) {
                    a += Math.abs(s) + 1;
                    s += Math.abs(s) + 1;
                }
                if(s2 >= 0) {
                    b += Math.abs(s2) +1;
                    s2 -= Math.abs(s2) + 1;
                }

            } else {
                if(s >= 0) {
                    a += Math.abs(s) + 1;
                    s -= Math.abs(s) + 1;
                }
                if(s2 <= 0) {
                    b += Math.abs(s2) + 1;
                    s2 += Math.abs(s2) +1;
                }
            }
//            writer.println("s1" + " = " + s + " s2 = " + s2);
        }
//        writer.println(a + " " + b);
        writer.println(Math.min(a,b));
    }




    public static void main(String[] args) {
        new Main().run();
    }



    BufferedReader reader;
    //    BufferedReader reader2;
    StringTokenizer tokenizer;
    PrintWriter writer;
    //    BufferedWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
//            reader = new BufferedReader(new FileReader("input.txt"));
            //            reader2 = new BufferedReader(new FileReader("1.in"));
            tokenizer = null;
            writer = new PrintWriter(System.out);
//            writer = new     PrintWriter("output.txt");
//                                                    writer = new BufferedWriter(System.out);
            //                        writer = new BufferedWriter(new OutputStreamWriter(System.out));
            solve();
            reader.close();
            //            reader2.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    short nextShort() throws IOException {
        return Short.parseShort(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }

        return tokenizer.nextToken();
    }

}