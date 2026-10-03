import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
//            while (true)
                solve(in);
        }
    }

    private static void solve(Scanner in) {
        String s = in.next();
        System.out.println(s.replace(",", " "));
    }
}