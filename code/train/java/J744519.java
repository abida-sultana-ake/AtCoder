import java.util.Scanner;

public class Main {

    public Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
	    new Main().solveB();
    }

    public void solveC() {
        int N = in.nextInt();
        int a[] = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = in.nextInt();
        }
        int res = N;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                boolean b = true;
                if (i == j) continue;
                for (int k = i + 1; k <= j; k++) {
                    if (a[k-1] >= a[k]) {
                        b = false;
                        break;
                    }
                }
                if (b) res++;
            }
        }
        System.out.println(res);
    }

    public void solveA() {
        String str = in.next();
        if (str.charAt(str.length() - 1) == 'T')
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public void solveB() {
        int[] disp1 = new int[2];
        int[] disp2 = new int[2];
        disp1[0] = in.nextInt();
        disp1[1] = in.nextInt();
        disp2[0] = in.nextInt();
        disp2[1] = in.nextInt();
        boolean res = false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (disp1[i] == disp2[j]) {
                    res = true;
                }
            }
        }
        if (res) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
