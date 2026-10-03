import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    int H, W;
    int N;
    Color[] cs;
    int[][] ans;

    public static void main(String[] args) {
        Main m = new Main();
        m.read();
        m.solve();
    }

    private void read() {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
        cs = new Color[N];
        for (int i = 0; i < N; i++) {
            cs[i] = new Color(i+1, sc.nextInt());
        }
        ans = new int[H][W];
    }

    private void solve() {
        PriorityQueue<Color> queue =
                new PriorityQueue<>((c1, c2) -> Integer.compare(c2.num, c1.num));
        for (Color c: cs)
            queue.add(c);
        boolean flip = false;
        Color c = queue.poll();
        for (int i = 0; i < H; i++) {
            if (flip) {
                for (int j = W - 1; j >= 0; j--) {
                    if (c.num == 0)
                        c = queue.poll();
                    ans[i][j] = c.color;
                    c.num--;
                }
                flip = false;
            }
            else {
                for (int j = 0; j < W; j++) {
                    if (c.num == 0)
                        c = queue.poll();
                    ans[i][j] = c.color;
                    c.num--;
                }
                flip = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W-1; j++) {
                sb.append(ans[i][j]);
                sb.append(" ");
            }
            sb.append(ans[i][W-1]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private class Color {
        int color;
        int num;
        Color(int c, int n) {
            color = c;
            num = n;
        }
    }
}
