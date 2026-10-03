import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().solve();
    }

    void solve() {
        try (Scanner in = new Scanner(System.in)) {
            long x = in.nextLong();
            long a = 0, b = 0;
            while (b < x) {
                b += ++a;
            }
            // if ((b - x) % 2 == 1) ++a;
            System.out.println(a);
        }
    }

    void tr(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }
}
