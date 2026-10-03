import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
  final static int INF = 1 << 28;
  final static long LNF = 1L << 60;
  final static long MOD = 1_000_000_007;
  final static double EPS = 1e-9;
  final static double GOLDEN_RATIO = (1.0 + Math.sqrt(5)) / 2.0;
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    new Main().run();
  }

  void run() {
    long min = Long.MAX_VALUE;
    int n, k;
    n = ni();
    k = ni();
    int[] xs = new int[n];
    int[] ys = new int[n];
    TreeSet<Integer> setx = new TreeSet<>();
    TreeSet<Integer> sety = new TreeSet<>();
    for (int i = 0; i < n; ++i) {
      int x, y;
      x = ni();
      y = ni();
      xs[i] = x;
      ys[i] = y;
      setx.add(x);
      sety.add(y);
    }
    ArrayList<Integer> xlist = new ArrayList<>(setx);
    ArrayList<Integer> ylist = new ArrayList<>(sety);
    int xn = xlist.size();
    int yn = ylist.size();
    for (int minx : xlist) {
      for (int miny : ylist) {
        for (int maxx : xlist) {
          if (maxx < minx) {
            continue;
          }
          for (int maxy : ylist) {
            if (maxy < miny) {
              continue;
            }
            // count;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
              if (minx <= xs[i] && xs[i] <= maxx
                  && miny <= ys[i] && ys[i] <= maxy) {
                ++cnt;
              }
            }
            if (cnt >= k) {
              min = Math.min(min, (long) (maxx - minx) * (long) (maxy - miny));
            }
          }
        }
      }
    }
    System.out.println(min);
  }

  int ni() {
    return Integer.parseInt(sc.next());
  }

  long nl() {
    return sc.nextLong();
  }

  double nd() {
    return Double.parseDouble(sc.next());
  }

  void debug(Object... os) {
    System.err.println(Arrays.deepToString(os));
  }

  /**
   * ユークリッドの互除法
   *
   * @return a と b の最大公約数
   */
  long gcd(long a, long b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  /**
   * 拡張ユークリッドの互除法
   *
   * @return mx + ny = gcd(m, n)となるような(x, y)を返す
   */
  Pair<Long, Long> gcd_ex(long m, long n) {
    long[][] mat = _gcd_ex(m, n);
    return new Pair<>(mat[0][0], mat[0][1]);
  }

  long[][] _gcd_ex(long m, long n) {
    if (n == 0) {
      return new long[][]{{1, 0}, {0, 1}};
    }
    long k = m / n;
    long[][] K = new long[][]{{0, 1}, {1, -k}};
    long[][] r = _gcd_ex(n, m % n);
    long[][] dst = new long[2][2];
    for (int y = 0; y < 2; ++y)
      for (int x = 0; x < 2; ++x)
        for (int i = 0; i < 2; ++i)
          dst[y][x] += r[y][i] * K[i][x];
    return dst;
  }

  /**
   * 繰り返し2乗法を用いたべき乗の実装
   *
   * @return a^r (mod 1,000,000,007)
   */
  long pow(long a, long r) {
    long sum = 1;
    while (r > 0) {
      if ((r & 1) == 1) {
        sum *= a;
        sum %= MOD;
      }
      a *= a;
      a %= MOD;
      r >>= 1;
    }
    return sum;
  }

  /**
   * 組み合わせ
   * O(n)
   *
   * @return {}_nC_r
   */
  long C(int n, int r) {
    long sum = 1;
    for (int i = n; 0 < i; --i) {
      sum *= i;
      sum %= MOD;
    }
    long s = 1;
    for (int i = r; 0 < i; --i) {
      s *= i;
      s %= MOD;
    }
    sum *= pow(s, MOD - 2);
    sum %= MOD;

    long t = 1;
    for (int i = n - r; 0 < i; --i) {
      t *= i;
      t %= MOD;
    }
    sum *= pow(t, MOD - 2);
    sum %= MOD;

    return sum;
  }

  /**
   * 黄金分割探索
   *
   * @param left  下限
   * @param right 上限
   * @param f     探索する関数
   * @param comp  上に凸な関数を探索するときは、Comparator.comparingDouble(Double::doubleValue)
   *              下に凸な関数を探索するときは、Comparator.comparingDouble(Double::doubleValue).reversed()
   * @return 極値の座標x
   */
  double goldenSectionSearch(double left, double right, Function<Double, Double> f, Comparator<Double> comp) {
    double c1 = divideInternally(left, right, 1, GOLDEN_RATIO);
    double c2 = divideInternally(left, right, GOLDEN_RATIO, 1);
    double d1 = f.apply(c1);
    double d2 = f.apply(c2);
    while (right - left > 1e-9) {
      if (comp.compare(d1, d2) > 0) {
        right = c2;
        c2 = c1;
        d2 = d1;
        c1 = divideInternally(left, right, 1, GOLDEN_RATIO);
        d1 = f.apply(c1);
      } else {
        left = c1;
        c1 = c2;
        d1 = d2;
        c2 = divideInternally(left, right, GOLDEN_RATIO, 1);
        d2 = f.apply(c2);
      }
    }
    return right;
  }

  /**
   * [a,b]をm:nに内分する点を返す
   */
  double divideInternally(double a, double b, double m, double n) {
    return (n * a + m * b) / (m + n);
  }

  /**
   * http://alexbowe.com/popcount-permutations/
   * bitの立っている数が小さい順にループしたいときに使う。
   * ex)
   * <pre>
   * for (int i = 0; i < 25; ++i) {
   *   int bits = (1 << i) - 1;
   *   long m = C(25, num);
   *   for (j = 0; j < m; ++j) {
   *     ...(25個の中からi個bitが立っている)
   *     if (bits != 0)
   *       bits = next_perm(bits);
   *   }
   * }
   * </pre>
   *
   * @param v 現在のbit列
   * @return 次のbit列
   */
  int next_perm(int v) {
    int t = (v | (v - 1)) + 1;
    return t | ((((t & -t) / (v & -v)) >> 1) - 1);
  }

  static class Util {
    static <T extends Comparable<T>> T max(T a, T b) {
      if (a.compareTo(b) > 0) {
        return a;
      } else {
        return b;
      }
    }

    static <T extends Comparable<T>> T min(T a, T b) {
      if (a.compareTo(b) < 0) {
        return a;
      } else {
        return b;
      }
    }
  }

  /**
   * from http://gihyo.jp/dev/serial/01/geometry part 6
   */
  static class Line {
    double a;
    double b;
    double c;

    /**
     * 一般形のパラメータから直線を作成する
     *
     * @param a xの係数
     * @param b yの係数
     * @param c 定数項
     */
    Line(double a, double b, double c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    /**
     * 2点(x1, y1), (x2, y2)を通る直線を作成する
     *
     * @param x1 1点目のx座標
     * @param y1 1点目のy座標
     * @param x2 2点目のx座標
     * @param y2 2点目のy座標
     * @return 直線
     */
    static Line fromPoints(double x1, double y1, double x2, double y2) {
      double dx = x2 - x1;
      double dy = y2 - y1;
      return new Line(dy, -dx, dx * y1 - dy * x1);
    }

    /**
     * 与えられた直線との交点を返す
     *
     * @param l 直線
     * @return 交点。2直線が平行の場合はnull
     */
    Point2D getIntersectionPoint(Line l) {
      double d = a * l.b - l.a * b;
      if (d == 0.0) {
        return null;
      }
      double x = (b * l.c - l.b * c) / d;
      double y = (l.a * c - a * l.c) / d;
      return new Point2D.Double(x, y);
    }

    @Override
    public String toString() {
      return "a = " + a + ", b = " + b + ", c = " + c;
    }
  }

  static class Line1D {
    int x1;
    int x2;

    // [x1, x2) : 半開空間
    Line1D(int x1, int x2) {
      this.x1 = x1;
      this.x2 = x2;
    }

    boolean isCross(Line1D l) {
      return isCross(l.x1, l.x2);
    }

    boolean isCross(int y1, int y2) {
//      boolean ret = x1 < y2 && y1 < x2;
//      assert ret == new LineSegment(x1, 0, x2, 0).intersects(new LineSegment(y1, 0, y2, 0));
//      return ret;
      return new LineSegment(x1 - 0.25, 0, x2 + 0.25, 0).intersects(new LineSegment(y1 - 0.25, 0, y2 + 0.25, 0));
    }
  }

  /**
   * from http://gihyo.jp/dev/serial/01/geometry part 6
   */
  static public class LineSegment {
    double x1;
    double y1;
    double x2;
    double y2;

    LineSegment(double x1, double y1, double x2, double y2) {
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
    }

    Line toLine() {
      return Line.fromPoints(x1, y1, x2, y2);
    }

    boolean intersects(Line l) {
      double t1 = l.a * x1 + l.b * y1 + l.c;
      double t2 = l.a * x2 + l.b * y2 + l.c;
      return t1 * t2 <= 0;
    }

    boolean intersects(LineSegment s) {
      return bothSides(s) && s.bothSides(this);
    }

    // sが自線分の「両側」にあるかどうかを調べる
    private boolean bothSides(LineSegment s) {
      double ccw1 = GeomUtils.ccw(x1, y1, s.x1, s.y1, x2, y2);
      double ccw2 = GeomUtils.ccw(x1, y1, s.x2, s.y2, x2, y2);
      if (ccw1 == 0 && ccw2 == 0) { // sと自線分が一直線上にある場合
        // sのいずれか1つの端点が自線分を内分していれば、sは自線分と共有部分を持つので
        // trueを返す
        return internal(s.x1, s.y1) || internal(s.x2, s.y2);
      } else { // それ以外の場合
        // CCW値の符号が異なる場合にtrueを返す
        return ccw1 * ccw2 <= 0;
      }
    }

    // (x, y)が自線分を内分しているかどうかを調べる
    private boolean internal(double x, double y) {
      // (x, y)から端点に向かうベクトルの内積がゼロ以下であれば内分と見なす
      return GeomUtils.dot(x1 - x, y1 - y, x2 - x, y2 - y) <= 0;
    }

    public Point2D getIntersectionPoint(Line l) {
      if (!intersects(l)) {
        return null; // 交差しない場合はnullを返す
      }
      return l.getIntersectionPoint(toLine());
    }

    public Point2D getIntersectionPoint(LineSegment s) {
      if (!intersects(s)) {
        return null; // 交差しない場合はnullを返す
      }
      return s.toLine().getIntersectionPoint(toLine());
    }

    /**
     * from : http://www.deqnotes.net/acmicpc/2d_geometry/lines#distance_between_line_segment_and_point
     */
    double distance(double x0, double y0) {
      // 端点チェック
      if (GeomUtils.dot(x2 - x1, y2 - y1, x0 - x1, y0 - y1) < EPS) {
        return GeomUtils.abs(x0 - x1, y0 - y1);
      }
      if (GeomUtils.dot(x1 - x2, y1 - y2, x0 - x2, y0 - y2) < EPS) {
        return GeomUtils.abs(x0 - x2, y0 - y2);
      }
      // 直線と点の距離
      return Math.abs(GeomUtils.cross(x2 - x1, y2 - y1, x0 - x1, y0 - y1)) / GeomUtils.abs(x2 - x1, y2 - y1);
    }

    double distance(LineSegment l) {
      if (this.intersects(l)) {
        return 0.0;
      }
      double min = Double.MAX_VALUE;
      min = Math.min(min, distance(l.x1, l.y1));
      min = Math.min(min, distance(l.x2, l.y2));
      min = Math.min(min, l.distance(x1, y1));
      min = Math.min(min, l.distance(x2, y2));
      return min;
    }

    @Override
    public String toString() {
      return "(" + x1 + ", " + y1 + ") - (" + x2 + ", " + y2 + ")";
    }
  }

  /**
   * from http://gihyo.jp/dev/serial/01/geometry part 6
   */
  static class GeomUtils {
    // 外積
    static double cross(double x1, double y1, double x2, double y2) {
      return x1 * y2 - x2 * y1;
    }

    // 内積
    static double dot(double x1, double y1, double x2, double y2) {
      return x1 * x2 + y1 * y2;
    }

    // (x1, y1) -> (x2, y2) -> (x3, y3) と進む道のりが半時計回りの場合は正の値、
    // 時計回りの場合は負の値、一直線上の場合はゼロを返す
    static double ccw(double x1, double y1, double x2, double y2,
                      double x3, double y3) {
      return cross(x2 - x1, y2 - y1, x3 - x2, y3 - y2);
    }

    static double ccw(Point2D p1, Point2D p2, Point2D p3) {
      return ccw(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
    }

    // ベクトルの長さ
    static double abs(double x, double y) {
      return Math.sqrt(x * x + y * y);
    }

    // 多角形の内外判定
    // http://www.nttpc.co.jp/technology/number_algorithm.html
    // 模擬国内2017EでWAになった
    // 凸多角形 -> 右周りでccwが全部負
    // 凹多角形含む単純な多角形 -> 点から無限に右に伸ばした線分との交点が1つ
    static boolean isIn(ArrayList<LineSegment> list, double x, double y) {
      int wn = 0;
      for (LineSegment l : list) {
        if (l.y1 <= y && l.y2 > y) {
          double vt = (y - l.y1) / (l.y2 - l.y1);
          if (x < l.x1 + (vt * (l.x2 - l.x1))) {
            ++wn;
          }
        }
        if (l.y1 > y && l.y2 <= y) {
          double vt = (y - l.y1) / (l.y2 - l.y1);
          if (x < (l.x1 + (vt * (l.x2 - l.x1)))) {
            --wn;
          }
        }
      }
      return wn > 0;
    }
  }

  /**
   * http://qiita.com/p_shiki37/items/65c18f88f4d24b2c528b
   */
  static class FastScanner {
    private final InputStream in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    public FastScanner(InputStream in) {
      this.in = in;
    }

    private static boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

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

  static class Pair<F extends Comparable<F>, S extends Comparable<S>> implements Comparable<Pair<F, S>> {
    F f;
    S s;

    Pair() {
    }

    Pair(F f, S s) {
      this.f = f;
      this.s = s;
    }

    Pair(Pair<F, S> p) {
      f = p.f;
      s = p.s;
    }

    @Override
    public int compareTo(Pair<F, S> p) {
      if (f.compareTo(p.f) != 0) {
        return f.compareTo(p.f);
      }
      return s.compareTo(p.s);
    }

    @Override
    public int hashCode() {
      return f.hashCode() ^ s.hashCode();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || this.f == null || this.s == null) {
        return false;
      }
      if (this.getClass() != o.getClass()) {
        return false;
      }
      Pair p = (Pair) o;
      return this.f.equals(p.f) && this.s.equals(p.s);
    }

    @Override
    public String toString() {
      return "{" + f.toString() + ", " + s.toString() + "}";
    }
  }

  class BIT<T> {
    int n;
    ArrayList<T> bit;
    BiFunction<T, T, T> bif;

    /**
     * 1-indexed なBinary Indexed Treeを構築する
     *
     * @param n   容量
     * @param bif 適用させる関数
     * @param sup 初期値
     */
    BIT(int n, BiFunction<T, T, T> bif, Supplier<T> sup) {
      this.n = n;
      bit = new ArrayList<>(n + 1);
      for (int i = 0; i < n + 1; ++i) {
        bit.add(sup.get());
      }
      this.bif = bif;
    }

    /**
     * iの位置の値をvで更新する
     *
     * @param i index
     * @param v 新しい値
     */
    void set(int i, T v) {
      for (int x = i; x <= n; x += x & -x) {
        bit.set(x, bif.apply(bit.get(x), v));
      }
    }

    /**
     * クエリー
     *
     * @param defaultValue 初期値
     * @param i            index
     * @return [1, i]までfを適用した結果
     */
    T reduce(T defaultValue, int i) {
      T ret = defaultValue;
      for (int x = i; x > 0; x -= x & -x) {
        ret = bif.apply(ret, bit.get(x));
      }
      return ret;
    }
  }

  class SegmentTree<T> {
    int n;
    ArrayList<T> dat;
    BiFunction<T, T, T> bif;
    Supplier<T> sup;

    /**
     * 0-indexed なSegment Treeを構築する
     *
     * @param n_  要求容量
     * @param bif 適用させる関数
     * @param sup 初期値
     */
    SegmentTree(int n_, BiFunction<T, T, T> bif, Supplier<T> sup) {
      n = 1;
      while (n < n_) n *= 2;

      dat = new ArrayList<>(2 * n - 1);
      for (int i = 0; i < 2 * n - 1; ++i) {
        dat.add(sup.get());
      }
      this.bif = bif;
      this.sup = sup;
    }

    /**
     * kの位置の値をvで更新する
     *
     * @param k index
     * @param v 新しい値
     */
    void set(int k, T v) {
      k += n - 1;
      dat.set(k, v);
      while (k > 0) {
        k = (k - 1) / 2;
        dat.set(k, bif.apply(dat.get(k * 2 + 1), dat.get(k * 2 + 2)));
      }
    }

    /**
     * クエリー
     *
     * @param l はじめ
     * @param r おわり
     * @return [l, r)での演算bifを適用した結果を返す
     */
    T reduce(int l, int r) {
      return _reduce(l, r, 0, 0, n);
    }

    T _reduce(int a, int b, int k, int l, int r) {
      if (r <= a || b <= l) return sup.get();
      if (a <= l && r <= b) return dat.get(k);
      T vl = _reduce(a, b, k * 2 + 1, l, (l + r) / 2);
      T vr = _reduce(a, b, k * 2 + 2, (l + r) / 2, r);
      return bif.apply(vl, vr);
    }
  }

  class UnionFind {
    int[] par;

    UnionFind(int n) {
      par = new int[n];
      for (int i = 0; i < n; ++i) {
        par[i] = i;
      }
    }

    int find(int x) {
      if (par[x] == x) {
        return x;
      }
      return par[x] = find(par[x]);
    }

    boolean same(int x, int y) {
      return find(x) == find(y);
    }

    void union(int x, int y) {
      x = find(x);
      y = find(y);
      if (x == y) {
        return;
      }
      par[x] = y;
    }
  }
}

