import java.util.*;

public class Main{      

    static char[][] A = new char[10][10];
    static boolean[][] used = new boolean[10][10];

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 10; i++) {
            A[i] = sc.next().toCharArray();
        }

        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (A[i][j] == 'o') {
                    cnt++;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (A[i][j] == 'o') {
                    continue;
                }
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        used[k][l] = false;
                    }
                }
                A[i][j] = 'o';
                if (dfs(i, j) == cnt + 1) {
                    System.out.println("YES");
                    return;
                }
                A[i][j] = 'x';
            }
        }

        System.out.println("NO");
    }

    static int dfs(int x, int y) {
        if (x < 0 || x >= 10 || y < 0 || y >= 10) return 0;
        if (A[x][y] == 'x') return 0;
        if (used[x][y]) return 0;
        used[x][y] = true;
        return dfs(x + 1, y) + dfs(x, y + 1) + dfs(x - 1, y) + dfs(x, y - 1) + 1;
    }
    
                         
}
