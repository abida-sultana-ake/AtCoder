import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        int[] cards = new int[6];

        for (int i = 0; i < 6; i++) {
            cards[i] = i + 1;
        }

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next()) % 30;

        for (int i = 0; i < n; i++) {
            int m = i % 5;
            swap(cards, m);
        }

        for (int j = 0; j < 5; j++) {
            System.out.print(cards[j]);
        }
        System.out.println(cards[5]);
    }

    private static void swap(int[] cards, int m) {
        int temp = cards[m];
        cards[m] = cards[m + 1];
        cards[m + 1] = temp;
    }
}
