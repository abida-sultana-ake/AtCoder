import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Main {

  private void solve(FastScanner in, PrintWriter out) {
    int N = in.nextInt();
    long[] A = new long[N];
    for (int i = 0; i < N; i++) {
      A[i] = in.nextInt();
    }

    long[] ans = new long[N];
    PriorityQueue<long[]> queue = new PriorityQueue<>((o1, o2) -> {
      //個数の降順
      if (o1[0] != o2[0]) {
        if (o1[0] - o2[0] > 0) {
          return -1;
        } else if (o1[0] - o2[0] < 0) {
          return 1;
        }
        return 0;
      }

      //番号の昇順
      if (o1[1] - o2[1] > 0) {
        return 1;
      } else if (o1[1] - o2[1] < 0) {
        return -1;
      }
      return 0;
    });

    for (int i = 0; i < N; i++) {
      queue.add(new long[]{A[i], i, 1});
    }

    while (queue.size() >= 2) {
      long[] first = queue.poll();
      long[] second = queue.poll();

      int f = (int) first[1];
      int s = (int) second[1];
      long x = first[0] - second[0];
      ans[f] += x * first[2];
      second[2] += first[2];
      if (f < s) {
        second[1] = f;
      }
      queue.add(second);
    }

    long[] last = queue.poll();
    ans[(int) last[1]] += last[0] * last[2];

    for (int i = 0; i < N; i++) {
      out.println(ans[i]);
    }

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
