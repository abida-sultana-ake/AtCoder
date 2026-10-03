import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

  static final int MOD = 1000000007;

  public static void main(String [] args) {
    InputReader scanner = new InputReader(System.in);
    int N = scanner.nextInt();
    int [] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = scanner.nextInt();
    }
    Arrays.sort(A);
    int res = 1;
    if (N % 2 == 1) {
      if (A[0] != 0) {
        System.out.println(0);
        return;
      }
    }
    int cnt = (N % 2 == 1) ? 2 : 1;
    int start = (N % 2 == 1) ? 1 : 0;
    for (int i = start; i < N; i += 2) {
      if (A[i] != cnt || A[i + 1] != cnt) {
        System.out.println(0);
        return;
      }
      res *= 2;
      res %= MOD;
      cnt += 2;
    }
    System.out.println(res);
  }

  static class Interval implements Comparable<Interval> {
    int a, b;
    public Interval(int a, int b) {
      this.a = a;
      this.b = b;
    }

    public int compareTo(Interval rhs) {
      if (b < rhs.b) return -1;
      if (b == rhs.b) {
        return a - rhs.a;
      }
      return 1;
    }
  }

  static class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String nextLine() {
      try {
        return reader.readLine();
      } catch (IOException e) {
        return null;
      }
    }

    public boolean hasNext() {
      if (tokenizer == null) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
        }
      }
      return tokenizer.hasMoreTokens();
    }

    public String next() {
      if (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
          if (!tokenizer.hasMoreTokens()) {
            return null;
          }
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}
