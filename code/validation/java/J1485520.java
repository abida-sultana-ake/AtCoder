import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author OmarYasser
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, Scanner sc, PrintWriter out) {
            int n = sc.nextInt();
            boolean okT = false;
            int bad = 0, four = 0;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                bad += !(x % 2 == 0 || x % 4 == 0) ? 1 : 0;
                okT |= (x % 2 == 0 && x % 4 != 0);
                four += (x % 4 == 0) ? 1 : 0;
            }
            if (bad == 0) out.println("Yes");
            else if (okT) out.println(bad <= four ? "Yes" : "No");
            else out.println(bad - 1 <= four ? "Yes" : "No");
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader f) {
            br = new BufferedReader(f);
        }

        public String next() {
            while (st == null || !st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

