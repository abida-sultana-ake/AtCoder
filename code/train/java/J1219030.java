import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        int[][] b = new int[2][3];
        int[][] c = new int[3][2];

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    b[i][j] = in.nextInt();
                    sum += b[i][j];
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    c[i][j] = in.nextInt();
                    sum += c[i][j];
                }
            }

            int[][] B = new int[3][3];
            int x = rec(B, 1);

            out.println(x);
            out.println(sum - x);
        }

        int rec(int[][] B, int turn) {
            if (turn == 9) {
                int ret = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (B[i][j] == 0) {
                            B[i][j] = 1;
                            ret = calc(B);
                            B[i][j] = 0;
                        }
                    }
                }

                return ret;
            }

            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (B[i][j] == 0) {
                        B[i][j] = turn % 2 == 1 ? 1 : 2;
                        int x = rec(B, turn + 1);
                        max = Math.max(max, x);
                        min = Math.min(min, x);
                        B[i][j] = 0;
                    }
                }
            }

            return turn % 2 == 1 ? max : min;
        }

        int calc(int[][] B) {
            int ans = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (B[i][j] == B[i + 1][j]) {
                        ans += b[i][j];
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    if (B[i][j] == B[i][j + 1]) {
                        ans += c[i][j];
                    }
                }
            }
            return ans;
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
}

