import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    void run() {
        int N = sc.nextInt();
        int T = sc.nextInt();
        int[] t = new int[N];
        for (int i = 0; i < N; i++) t[i] = sc.nextInt();
        int res = T;
        for (int i = 0; i < N - 1; i++) res += (t[i + 1] - t[i] >= T) ? T : t[i + 1] - t[i];
        System.out.println(res);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}