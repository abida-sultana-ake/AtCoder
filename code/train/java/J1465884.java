import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    BufferedReader rd;

    Main() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        compute();
    }

    private void compute() throws IOException {
        long k = plong();
        long[] res = solve(k);
        out(res.length);
        StringBuilder buf = new StringBuilder();
        for(int i=0;i<res.length;i++) {
            if(i > 0) {
                buf.append(' ');
            }
            buf.append(res[i]);
        }
        out(buf);
    }

    private long[] solve(long k) {
        if(k == 0) {
            return new long[] { 0, 0 };
        } else if(k == 1) {
            return new long[] { 2, 0 };
        } else {
            long[] res = new long[50];
            long h = k / 50;
            int u = (int)(k%50);
            if(u > 0) {
                long base = 100 - u + h;
                for (int i = 0; i < u; i++) {
                    res[i] = base;
                }
                for (int i = u; i < 50; i++) {
                    res[i] = base - 51;
                }
            } else {
                for (int i = 0; i < 50; i++) {
                    res[i] = 49 + h;
                }
            }
            return res;
        }
    }

    private long plong() throws IOException {
        return plong(rd.readLine());
    }

    private long plong(String s) {
        return Long.parseLong(s);
    }

    private static void out(Object x) {
        System.out.println(x);
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
