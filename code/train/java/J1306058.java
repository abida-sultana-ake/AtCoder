import java.util.*;

public class Main {
    public static void main(String args[]) {
        FastScanner cin = new FastScanner();
        String s = cin.next();

        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                System.out.printf("%d %d\n", i + 1, i + 2);
                return;
            }

            if (i < s.length() - 2 && s.charAt(i) == s.charAt(i + 2)) {
                System.out.printf("%d %d\n", i + 1, i + 3);
                return;
            }
        }

        System.out.println("-1 -1");
    }

    static class FastScanner {
        StringTokenizer tokenizer;
        Scanner scanner;

        FastScanner() {
            tokenizer = null;
            scanner = new Scanner(System.in);
        }

        int nextInt() {
            while (tokenizer == null || !tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(scanner.nextLine());

            return Integer.parseInt(tokenizer.nextToken());
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(scanner.nextLine());

            return tokenizer.nextToken();
        }
    }
}
