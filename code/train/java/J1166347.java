import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] b = new int[2][3];
    int[][] c = new int[3][2];
    int sum = 0;
    for(int i = 0; i < 2; i++) {
      for(int j = 0; j < 3; j++) {
        b[i][j] = sc.nextInt();
        sum += b[i][j];
      }
    }
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 2; j++) {
        c[i][j] = sc.nextInt();
        sum += c[i][j];
      }
    }
    char[][] board = new char[3][3];
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        board[i][j] = '.';
      }
    }
    int score = dfs(1, board, b, c);
    System.out.println((sum + score) / 2);
    System.out.println((sum - score) / 2);
  }

  // 盤面が与えられた時、n手目を打つとして最適なscore(先手の得点-後手の得点)を返す
  public static int dfs(int n, char[][] board, int[][] b, int[][] c) {
    if(n == 10) {
      int sente = 0;
      int koute = 0;
      for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 3; j++) {
          if(board[i][j] == board[i + 1][j]) {
            sente += b[i][j];
          } else {
            koute += b[i][j];
          }
        }
      }
      for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 2; j++) {
          if(board[i][j] == board[i][j + 1]) {
            sente += c[i][j];
          } else {
            koute += c[i][j];
          }
        }
      }
      return sente - koute;
    } else {
      if(n % 2 == 1) {
        int max = -10000;
        for(int i = 0; i < 3; i++) {
          for(int j = 0; j < 3; j++) {
            if(board[i][j] == '.') {
              board[i][j] = 'o';
              max = Math.max(max, dfs(n + 1, board, b, c));
              board[i][j] = '.';
            }
          }
        }
        return max;
      } else {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
          for(int j = 0; j < 3; j++) {
            if(board[i][j] == '.') { 
              board[i][j] = 'x';
              min = Math.min(min, dfs(n + 1, board, b, c));
              board[i][j] = '.';
            }
          }
        }
        return min;
      }
    }
  }
}