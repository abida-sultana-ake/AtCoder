import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
//            while (true)// MAKE SURE TO REMOVE THIS
                solve(in);
        }
    }

    private static void solve(Scanner in) {
        int N = in.nextInt();
        String S = in.next();
        int x = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            x += S.charAt(i) == 'I' ? 1 : (-1);
            max = max > x ? max : x;
        }
        System.out.println(max);
    }
}