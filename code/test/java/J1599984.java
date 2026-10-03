import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int e = in.nextInt();
            int f = in.nextInt();

            boolean[] waterSize = new boolean[3001];
            waterSize[0] = true;
            for (int i = 0; i < waterSize.length; i++) {
                if (i - 100 * a >= 0)
                    waterSize[i] |= waterSize[i - 100 * a];
                if (i - 100 * b >= 0)
                    waterSize[i] |= waterSize[i - 100 * b];
            }

            boolean[] sugarSize = new boolean[3001];
            sugarSize[0] = true;
            for (int i = 0; i < sugarSize.length; i++) {
                if (i - c >= 0)
                    sugarSize[i] |= sugarSize[i - c];
                if (i - d >= 0)
                    sugarSize[i] |= sugarSize[i - d];
            }

            ArrayList<Integer> waters = new ArrayList<>();
            for (int i = 0; i < waterSize.length; i++) {
                if (waterSize[i])
                    waters.add(i);
            }

            ArrayList<Integer> sugars = new ArrayList<>();
            for (int i = 0; i < sugarSize.length; i++) {
                if (sugarSize[i])
                    sugars.add(i);
            }

            int bestW = 0;
            int bestS = 0;
            double bestDens = -1.0;
            for (Integer w : waters) {
                for (Integer s : sugars) {
                    if (w + s > f)
                        continue;
                    if (w + s == 0)
                        continue;

                    double dens = 1.0 * s / (w + s);

                    if (dens - (1.0 * e / (100.0 + e)) <= 1e-9) {
                        if (dens - bestDens >= 1e-9) {
                            bestDens = dens;
                            bestW = w;
                            bestS = s;
                        }
                    }
                }
            }

            out.println((bestS + bestW) + " " + bestS);
        }

    }

    static class InputReader {
        StringTokenizer st;
        BufferedReader br;

        public InputReader(InputStream is) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            this.br = br;
        }

        public String next() {
            if (st == null || !st.hasMoreTokens()) {
                String nextLine = null;
                try {
                    nextLine = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (nextLine == null)
                    return null;
                st = new StringTokenizer(nextLine);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

