import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
            long K = in.nextLong();

            int N = 50;
            long[] a = new long[N];
            for (int i = 0; i < a.length; i++) {
                a[i] = i;
            }

            long n = K / N;
            for (int i = 0; i < a.length; i++) {
                a[i] += n;
            }

            K %= N;
            for (int i = 0; i < K; i++) {
                a[i] += N;
                for (int j = 0; j < a.length; j++) {
                    if (j == i) {
                        continue;
                    }
                    a[j]--;
                }
            }

            // Utils.debug(calculateSum(Arrays.copyOf(a, a.length)));

            print(N, a);
        }
    }

    // private static long calculateSum(long[] a) {
    // Utils.debug("a", a);
    // long sum = 0;
    // for (;;) {
    // long before = sum;
    // for (int i = 0; i < a.length; i++) {
    // long l = a[i] / a.length;
    // sum += l;
    //
    // // long ll = l / N;
    // // sum += ll * (N - 1);
    // //
    // // long lll = l % N;
    //
    // a[i] %= a.length;
    //
    // for (int j = 0; j < a.length; j++) {
    // if (j == i) {
    // continue;
    // }
    // a[j] += l;
    // }
    // // print(N, a);
    // // Utils.debug(i, sum, l, a);
    // }
    // if (sum == before) {
    // break;
    // }
    // }
    // // Utils.debug("i", index, "sum", sum);
    // Utils.debug("sum", sum);
    // return sum;
    // }

    private static void print(int N, long[] a) {
        System.out.println(N);
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
