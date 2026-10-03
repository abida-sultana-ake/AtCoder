import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    private static int N;
    private static double[] X;
    private static double[] Y;
    private static double[] C;

    private static boolean check(double t) {
        double d = t / C[0];
        double xl = X[0] - d;
        double xr = X[0] + d;
        double yu = Y[0] + d;
        double yd = Y[0] - d;

        for (int i = 1; i < N; i++) {
            double cd = t / C[i];
            double cxl = X[i] - cd;
            double cxr = X[i] + cd;
            double cyu = Y[i] + cd;
            double cyd = Y[i] - cd;
            if (cxr <= xl || xr <= cxl || yu <= cyd || cyu <= yd) {
                return false;
            }
            xl = Math.max(xl, cxl);
            xr = Math.min(xr, cxr);
            yu = Math.min(yu, cyu);
            yd = Math.max(yd, cyd);
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        X = new double[N];
        Y = new double[N];
        C = new double[N];

        for (int i = 0; i < N; i++) {
            String[] s = in.readLine().split(" ");
            X[i] = Double.parseDouble(s[0]) + 100000;
            Y[i] = Double.parseDouble(s[1]) + 100000;
            C[i] = Double.parseDouble(s[2]);
        }
        double ok = 1000 * 100000;
        double ng = 0;
        for (int i = 0; i < 100; i++) {
            double mid = (ok + ng) / 2;
            if (check(mid)) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        PrintWriter out = new PrintWriter(System.out);
        out.println(ok);
        out.flush();
    }
}
