import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;


public class Main {
  public static void main(String[] args) {
    FastScanner sc = new FastScanner();
    char[] S = sc.next().toCharArray();
    char[] T = sc.next().toCharArray();
    int[] arrayS = new int[S.length];
    int[] arrayT = new int[T.length];

    for (int i = 0; i < S.length; i++) {
      arrayS[i] = S[i] == 'B' ? 1 : 0;
    }

    for (int i = 0; i < T.length; i++) {
      arrayT[i] = T[i] == 'B' ? 1 : 0;
    }

    SegmentTreeRSQ stS = new SegmentTreeRSQ(arrayS);
    SegmentTreeRSQ stT = new SegmentTreeRSQ(arrayT);

    int q = sc.nextInt();
    int[][] query = sc.nextIntTable(q, 4);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < q; i++) {
      long qS = stS.sum(query[i][0] - 1, query[i][1]);
      long qT = stT.sum(query[i][2] - 1, query[i][3]);
      
      int sLen = query[i][1] - query[i][0] + 1;
      int tLen = query[i][3] - query[i][2] + 1;
      
      qS += 2 * (sLen - qS);
      qT += 2 * (tLen - qT);
      
      if ((qS - qT) % 3 == 0) {
        sb.append("YES\n");
      } else {
        sb.append("NO\n");
      }
    }
    System.out.println(sb);
  }

}


class SegmentTreeRSQ {
  public int M, H, N;
  public long[] st;
  public long[] plus;

  public SegmentTreeRSQ(int n) {
    N = n;
    M = Integer.highestOneBit(Math.max(N - 1, 1)) << 2;
    H = M >>> 1;
    st = new long[M];
    plus = new long[H];
  }

  public SegmentTreeRSQ(int[] a) {
    N = a.length;
    M = Integer.highestOneBit(Math.max(N - 1, 1)) << 2;
    H = M >>> 1;
    st = new long[M];
    plus = new long[H];
    for (int i = 0; i < N; i++) {
      st[H + i] = a[i];
    }
    for (int i = (M >> 1) - 1; i >= 1; i--) {
      propagate(i);
    }
  }

  public void add(int pos, int v) {
    for (int i = H + pos; i >= 1; i >>>= 1) {
      st[i] += v;
    }
  }

  private void propagate(int i) {
    int count = H / Integer.highestOneBit(i);
    st[i] = st[2 * i] + st[2 * i + 1] + plus[i] * count;
  }

  public void add(int l, int r, int v) {
    if (l < r)
      add(l, r, v, 0, H, 1);
  }

  private void add(int l, int r, int v, int cl, int cr, int cur) {
    if (cur >= H) {
      st[cur] += v;
    } else if (l <= cl && cr <= r) {
      plus[cur] += v;
      propagate(cur);
    } else {
      int mid = cl + cr >>> 1;
      if (cl < r && l < mid) {
        add(l, r, v, cl, mid, 2 * cur);
      }
      if (mid < r && l < cr) {
        add(l, r, v, mid, cr, 2 * cur + 1);
      }
      propagate(cur);
    }
  }

  private long gsum;

  public long sum(int l, int r) {
    gsum = 0;
    sum(l, r, 0, H, 1);
    return gsum;
  }

  private void sum(int l, int r, int cl, int cr, int cur) {
    if (l <= cl && cr <= r) {
      gsum += st[cur];
    } else {
      int mid = cl + cr >>> 1;
      if (cl < r && l < mid) {
        sum(l, r, cl, mid, 2 * cur);
      }
      if (mid < r && l < cr) {
        sum(l, r, mid, cr, 2 * cur + 1);
      }
      gsum += plus[cur] * (Math.min(r, cr) - Math.max(l, cl));
    }
  }
}


class FastScanner {
  public static String debug = null;

  private final InputStream in = System.in;
  private int ptr = 0;
  private int buflen = 0;
  private byte[] buffer = new byte[1024];
  private boolean eos = false;

  private boolean hasNextByte() {
    if (ptr < buflen) {
      return true;
    } else {
      ptr = 0;
      try {
        if (debug != null) {
          buflen = debug.length();
          buffer = debug.getBytes();
          debug = "";
          eos = true;
        } else {
          buflen = in.read(buffer);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (buflen < 0) {
        eos = true;
        return false;
      } else if (buflen == 0) {
        return false;
      }
    }
    return true;
  }

  private int readByte() {
    if (hasNextByte())
      return buffer[ptr++];
    else
      return -1;
  }

  private static boolean isPrintableChar(int c) {
    return 33 <= c && c <= 126;
  }

  private void skipUnprintable() {
    while (hasNextByte() && !isPrintableChar(buffer[ptr]))
      ptr++;
  }

  public boolean isEOS() {
    return this.eos;
  }

  public boolean hasNext() {
    skipUnprintable();
    return hasNextByte();
  }

  public String next() {
    if (!hasNext())
      throw new NoSuchElementException();
    StringBuilder sb = new StringBuilder();
    int b = readByte();
    while (isPrintableChar(b)) {
      sb.appendCodePoint(b);
      b = readByte();
    }
    return sb.toString();
  }

  public long nextLong() {
    if (!hasNext())
      throw new NoSuchElementException();
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

  public int nextInt() {
    return (int) nextLong();
  }

  public long[] nextLongList(int n) {
    return nextLongTable(1, n)[0];
  }

  public int[] nextIntList(int n) {
    return nextIntTable(1, n)[0];
  }

  public long[][] nextLongTable(int n, int m) {
    long[][] ret = new long[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        ret[i][j] = nextLong();
      }
    }
    return ret;
  }

  public int[][] nextIntTable(int n, int m) {
    int[][] ret = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        ret[i][j] = nextInt();
      }
    }
    return ret;
  }
}
