import java.util.*;
import java.util.function.BiFunction;

public class Main {
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    new Main().run();
  }

  class Node {
    ArrayList<Node> list = new ArrayList<>();
    ArrayList<Node> adj = new ArrayList<>();
    int id;
    int depth;

    Node(int i) {
      id = i;
    }
  }

  long MOD = 1_000_000_007;

  long[] memoF;

  long f(Node node) {
    if (memoF[node.id] != 0) {
      return memoF[node.id];
    }
    long white = g(node);
    long black = 1;
    for (Node c : node.list) {
      black *= g(c);
      black %= MOD;
    }
    long sum = white + black;
    sum %= MOD;
    memoF[node.id] = sum;
//    debug("f", node.id, sum);
    return sum;
  }

  long[] memoG;

  long g(Node node) {
    if (memoG[node.id] != 0) {
      return memoG[node.id];
    }
    long white = 1;
    for (Node c : node.list) {
      white *= f(c);
      white %= MOD;
    }
//    debug("g", node.id, white);
    memoG[node.id] = white;
    return white;
  }

  void make(Node node, int n) {
    boolean[] done = new boolean[n + 1];

    done[node.id] = true;
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    node.depth = 0;
    while (queue.size() > 0) {
      Node atom = queue.poll();
      for (Node next : atom.adj) {
        if (done[next.id]) {
          continue;
        }
        done[next.id] = true;
        atom.list.add(next);
        queue.add(next);
        next.depth = atom.depth + 1;
      }
    }
  }

  void run() {
    int n = ni();
    ArrayList<Node> list = new ArrayList<>();
    for (int i = 0; i < n + 1; ++i) {
      list.add(new Node(i));
    }
    for (int i = 0; i < n - 1; ++i) {
      int u = ni();
      int v = ni();
      list.get(u).adj.add(list.get(v));
      list.get(v).adj.add(list.get(u));
    }
    make(list.get(1), n);

    memoF = new long[n + 1];
    memoG = new long[n + 1];
    PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.depth - a.depth);
    for (int i = 1; i <= n; ++i) {
      queue.add(list.get(i));
    }
    while (queue.size() > 0) {
      Node node = queue.poll();
      f(node);
    }
    System.out.println(memoF[1]);
  }

  int ni() {
    return Integer.parseInt(sc.next());
  }

  void debug(Object... os) {
    System.err.println(Arrays.deepToString(os));
  }

  class BIT<T> {
    int n;
    ArrayList<T> bit;
    BiFunction<T, T, T> bif;

    BIT(int n, BiFunction<T, T, T> bif, T defaultValue) {
      this.n = n;
      bit = new ArrayList<>(n + 1);
      for (int i = 0; i < n + 1; ++i) {
        bit.add(defaultValue);
      }
      this.bif = bif;
    }

    void update(int i, T v) {
      for (int x = i; x <= n; x += x & -x) {
        bit.set(x, bif.apply(bit.get(x), v));
      }
    }

    T reduce(int i, T defaultValue) {
      T ret = defaultValue;
      for (int x = i; x > 0; x -= x & -x) {
        ret = bif.apply(ret, bit.get(x));
      }
      return ret;
    }
  }

}