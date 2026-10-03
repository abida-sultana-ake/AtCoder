import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

  FastScanner sc;

  Main() {
    sc = new FastScanner();
  }

  int ni() {
    return Integer.parseInt(sc.next());
  }

  public static void main(String[] args) {
    new Main().run();
  }

  void run() {
    int n = ni();
    int[] a = new int[n];

    for (int i = 0; i < n; ++i) {
      a[i] = ni();
    }

    int[] dp = new int[n];
    Arrays.fill(dp, 1 << 28);
    dp[0] = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = 1; j <= 2; ++j) {
        if (i + j >= n) {
          continue;
        }
        dp[i + j] = Math.min(dp[i + j], dp[i] + Math.abs(a[i] - a[i + j]));
      }
    }

    System.out.println(dp[n - 1]);
  }

  void debug(Object... os) {
    System.err.println(Arrays.deepToString(os));
  }

  class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = in.read(buffer);
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (buflen <= 0) {
          return false;
        }
      }
      return true;
    }

    private int readByte() {
      if (hasNextByte()) return buffer[ptr++];
      else return -1;
    }

    private boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    private void skipUnprintable() {
      while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
    }

    public boolean hasNext() {
      skipUnprintable();
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) throw new NoSuchElementException();
      StringBuilder sb = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    public long nextLong() {
      if (!hasNext()) throw new NoSuchElementException();
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
  }
}
