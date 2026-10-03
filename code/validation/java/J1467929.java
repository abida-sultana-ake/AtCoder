import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Main {

  private long solve(long[] a) {
    Arrays.sort(a);
    int N = a.length;
    {
      boolean ok = true;
      for (long x : a) {
        if (x >= N) {
          ok = false;
          break;
        }
      }
      if (ok) {
        return 0;
      }
    }

    long ans = 0;
    while (true) {
      long sum = 0;
      for (int i = 0; i < N; i++) {
        if (a[i] > N - 1) {
          long c = ((a[i] - (N - 1)) + (N + 1) - 1) / (N + 1);
          sum += c;
          a[i] -= c * (N + 1);
        }
      }

      for (int i = 0; i < N; i++) {
        a[i] += sum;
      }

      ans += sum;

      boolean ok = true;
      for (int i = 0; i < N; i++) {
        if (a[i] >= N) {
          ok = false;
          break;
        }
      }
      if (ok) {
        return ans;
      }
    }
  }

  private void test() {
    Random random = new Random();

    while (true) {
      long K = random.nextInt(100) + 3;
      ArrayList<Long> list = new ArrayList<>();
      long N = 20;
      long rest = K % N;
      long x = K / N;
      for (int i = 0; i < rest; i++) {
        long a = N - 1 + (x + 1) * (N + 1) - K;
        list.add(a);
      }
      for (int i = 0; i < N - rest; i++) {
        long a = N - 1 + x * (N + 1) - K;
        list.add(a);
      }

      long[] ans = new long[(int) N];
      for (int i = 0; i < N; i++) {
        ans[i] = list.get(i);
      }

      long actual = solve(ans);
      if (actual != K) {
        throw new IllegalStateException();
      }
    }
  }

  private void solve(FastScanner in, PrintWriter out) {
    int N = in.nextInt();
    long[] a = in.nextLongArray(N);

    out.println(solve(a));
  }

  public static void main(String[] args) {
    FastScanner in = new FastScanner();
    PrintWriter out = new PrintWriter(System.out);
    new Main().solve(in, out);
    out.close();
  }

  private static class FastScanner {

    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int bufferLength = 0;

    private boolean hasNextByte() {
      if (ptr < bufferLength) {
        return true;
      } else {
        ptr = 0;
        try {
          bufferLength = in.read(buffer);
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (bufferLength <= 0) {
          return false;
        }
      }
      return true;
    }

    private int readByte() {
      if (hasNextByte()) {
        return buffer[ptr++];
      } else {
        return -1;
      }
    }

    private static boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    private void skipUnprintable() {
      while (hasNextByte() && !isPrintableChar(buffer[ptr])) {
        ptr++;
      }
    }

    boolean hasNext() {
      skipUnprintable();
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      StringBuilder sb = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    long nextLong() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      long n = 0;
      boolean minus = false;
      int b = readByte();
      if (b == '-') {
        minus = true;
        b = readByte();
      }
      if (b < '0' || '9' < b) {
        throw new NumberFormatException();
      }
      while (true) {
        if ('0' <= b && b <= '9') {
          n *= 10;
          n += b - '0';
        } else if (b == -1 || !isPrintableChar(b)) {
          return minus ? -n : n;
        } else {
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    double[] nextDoubleArray(int n) {
      double[] array = new double[n];
      for (int i = 0; i < n; i++) {
        array[i] = nextDouble();
      }
      return array;
    }

    double[][] nextDoubleMap(int n, int m) {
      double[][] map = new double[n][];
      for (int i = 0; i < n; i++) {
        map[i] = nextDoubleArray(m);
      }
      return map;
    }

    public int nextInt() {
      return (int) nextLong();
    }

    public int[] nextIntArray(int n) {
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = nextInt();
      }
      return array;
    }

    public long[] nextLongArray(int n) {
      long[] array = new long[n];
      for (int i = 0; i < n; i++) {
        array[i] = nextLong();
      }
      return array;
    }

    public String[] nextStringArray(int n) {
      String[] array = new String[n];
      for (int i = 0; i < n; i++) {
        array[i] = next();
      }
      return array;
    }

    public char[][] nextCharMap(int n) {
      char[][] array = new char[n][];
      for (int i = 0; i < n; i++) {
        array[i] = next().toCharArray();
      }
      return array;
    }

    public int[][] nextIntMap(int n, int m) {
      int[][] map = new int[n][];
      for (int i = 0; i < n; i++) {
        map[i] = nextIntArray(m);
      }
      return map;
    }
  }
}
