import java.util.Scanner;

public class Main {
    static char board[][] = new char[8][8];

    public static boolean canPut(int i, int j) {
        for (int k = 0; k < 8; k++) {
            if (k == i) continue;
            if (board[k][j] == 'Q') return false;
        }

        for (int k = 0; k < 8; k++) {
            if (k == j) continue;
            if (board[i][k] == 'Q') return false;
        }

        for (int k = 1; k <= i; k++) {
            if (j - k >= 0) {
                if (board[i - k][j - k] == 'Q') return false;
            }
            if (j + k < 8) {
                if (board[i - k][j + k] == 'Q') return false;
            }
        }

        for (int k = 1; k < (8 - i); k++) {
            if (j - k >= 0) {
                if (board[i + k][j - k] == 'Q') return false;
            }
            if (j + k < 8) {
                if (board[i + k][j + k] == 'Q') return false;
            }
        }

        return true;
    }

    public static boolean dfs(int i) {
        if (i == 8) return true;
        for (int j = 0; j < 8; j++) if (board[i][j] == 'Q') return dfs(i + 1);
        for (int j = 0; j < 8; j++) {
            if (!canPut(i, j)) continue;
            board[i][j] = 'Q';
            if (dfs(i + 1)) return true;
            board[i][j] = '.';
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 8; i++) board[i] = sc.next().toCharArray();

        for (int i = 0; i < 8; i++) for (int j = 0; j < 8; j++) {
            if (board[i][j] != 'Q') continue;
            if (!canPut(i, j)) {
                System.out.println("No Answer");
                return;
            }
        }

        if (!dfs(0)) System.out.println("No Answer");
        else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }
}