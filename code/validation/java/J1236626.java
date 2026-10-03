import java.util.*;

public class Main {

    public static final void main(String args[]) throws Exception {
        new Main().solve();
    }

    void solve() {
        try (Scanner in = new Scanner(System.in)) {
            long x = in.nextLong();
            long y = in.nextLong();
            if (x < y) {
                long t = x;
                x = y;
                y = t;
            }
            System.out.println(x > y + 1 ? "Alice" : "Brown");
        }
    }

    boolean dfs(long i, long j) {
        if (i < 2 && j < 2) return false;
        boolean win = false;
        for (long k = 1; k * 2 <= i; ++k) {
            win |= dfs_opp(i - k * 2, j + k);
        }
        for (long k = 1; k * 2 <= j; ++k) {
            win |= dfs_opp(i + k, j - k * 2);
        }
        return win;
    }

    boolean dfs_opp(long i, long j) {
        if (i < 2 && j < 2) return true;
        boolean win = true;
        for (long k = 1; k * 2 <= i; ++k) {
            win &= dfs(i - k * 2, j + k);
        }
        for (long k = 1; k * 2 <= j; ++k) {
            win &= dfs(i + k, j - k * 2);
        }
        return win;
    }

    void tr(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }
}