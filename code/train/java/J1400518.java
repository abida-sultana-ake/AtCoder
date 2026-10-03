import java.util.Scanner;
public class Main {
  static char field[][]=new char[8][8];
  public static boolean dfs(int i, int j) {
            for (int k=0;k<8;k++) {
                if (k==i) continue;
                if (field[k][j]=='Q') return false;
            }
            for (int k = 0; k < 8; k++) {
                if (k==j) continue;
                if (field[i][k]=='Q') return false;
            }
            for (int k=1;k<=i;k++) {
                if (j-k>=0) {
                    if (field[i-k][j-k]=='Q') return false;
                }
                if (j+k<8) {
                    if (field[i-k][j+k]=='Q') return false;
                }
            }
            for (int k=1;k<(8-i);k++) {
                if (j-k>=0) {
                    if (field[i+k][j-k]=='Q') return false;
                }
                if (j+k<8) {
                    if (field[i+k][j+k]=='Q') return false;
                }
            }
            return true;
        }

  public static boolean dfs(int i) {
    if (i == 8) return true;
      for (int j=0;j<8;j++) if (field[i][j]=='Q') return dfs(i+1);
        for (int j=0;j<8;j++) {
          if (!dfs(i,j)) continue;
          field[i][j] = 'Q';
          if (dfs(i+1)) return true;
          field[i][j] = '.';
        }
    return false;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    for (int i=0;i<8;i++) field[i] = in.next().toCharArray();
      for (int i=0;i<8;i++) for (int j=0;j<8;j++) {
        if (field[i][j] != 'Q') continue;
        if (!dfs(i,j)) {
          System.out.println("No Answer");
          return;
        }
      }
      if (!dfs(0)) System.out.println("No Answer");
      else {
        for (int i=0;i<8;i++) {
          for (int j=0;j<8;j++) {
            System.out.print(field[i][j]);
          }
          System.out.println();
        }
      }
  }
}
