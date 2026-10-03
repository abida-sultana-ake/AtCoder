import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main implements Runnable {

    private void solve() throws IOException {

        int N = nextInt();

        long MOD = 1_000_000_007;
        long[] cnt = new long[1001];
        long p = 1L;
        for(int i = 2; i <= N; ++i) {
            int z = i;
            for(int q = 2; q * q <= z; ++q) {
                if(z % q == 0) {
                    int c = 0;
                    while(z % q == 0) {
                        z /= q;
                        ++c;
                    }
                    cnt[q] += c;
                }
            }
            if(z > 1) {
                cnt[z]++;

            }
        }
        for(int j = 1; j <= 1000; ++j) {
            if(cnt[j] > 0) {
                p *= (cnt[j] + 1);
                p %= MOD;
            }
        }
        writer.println(p);
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
//            reader = new BufferedReader(new FileReader("highcard.in"));
            //            reader2 = new BufferedReader(new FileReader("1.in"));
            tokenizer = null;
            writer = new PrintWriter(System.out);
//            writer = new     PrintWriter("highcard.out");
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