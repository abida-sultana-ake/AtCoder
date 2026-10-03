import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String s1 = in.nextString();
            String s2 = in.nextString();

            List<Boolean> piledList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    piledList.add(false);
                } else {
                    piledList.add(true);
                    i++;
                }
            }

            long ans;
            if (piledList.get(0)) {
                ans = 6;
            } else {
                ans = 3;
            }

            long MOD = 1_000_000_007;
            Modulo modulo = new Modulo(MOD);
            for (int i = 1; i < piledList.size(); i++) {
                if (piledList.get(i - 1)) {
                    if (piledList.get(i)) {
                        ans = modulo.mlt(ans, 3);
                    }
                } else {
                    ans = modulo.mlt(ans, 2);
                }
            }

            out.println(ans);
        }

    }

    static class InputReader {
        BufferedReader in;
        StringTokenizer tok;

        public String nextString() {
            while (!tok.hasMoreTokens()) {
                try {
                    tok = new StringTokenizer(in.readLine(), " ");
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
            }
            return tok.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
            tok = new StringTokenizer("");
        }

    }

    static class Modulo {
        long m;

        public Modulo(long m) {
            this.m = m;
        }

        public long mlt(long a, long b) {
            return (a * b) % m;
        }

    }
}

