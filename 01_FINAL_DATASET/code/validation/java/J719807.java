import java.util.Scanner;

 
public class Main {
    void solveA(Scanner sc) throws Throwable {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int min = Math.min(a, b);

        System.out.println(c / min);
    }

    void solveB(Scanner sc) throws Throwable {
        int[] n = new int[sc.nextInt()];
        int q = sc.nextInt();
        for(int i = 0 ; i < q; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int t = sc.nextInt();
            for(; s <= e; s++) {
                n[s-1] = t;
            }
        }
        for(int i : n) {
            System.out.println(i);
        }
        
    }
    
    void solveC(Scanner sc) throws Throwable {
        int n = sc.nextInt();
        int k = sc.nextInt();
        double sum = 0;

        for(int i = 0; i < n; i++) {
            int keisu = Math.min(k, Math.min(i + 1, n - i));
            sum += keisu * sc.nextLong();
        }
        
        System.out.println(sum);

    }

    int div = (int) Math.pow(10, 9) + 7;
    int[][] map;
    int[][] dp;
    void solveD(Scanner sc) throws Throwable {
        int h = sc.nextInt();
        int w = sc.nextInt();

        map = new int[h+2][w+2];
        for(int i = 1; i <=h; i++) {
            for(int j = 1; j <=w; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        dp = new int[h][w];
        
        for(int i = 1; i <=h; i++) {
            for(int j = 1; j <=w; j++) {
                
            }
        }
    }

    int[] dx = new int[] {0, 0, 1, -1};
    int[] dy = new int[] {1,-1, 0,  0};
    
    int search(int y, int x) {
        
        if(dp[y][x] != 0) {
            return dp[y][x];
        }
        
        int total = 0;
        int now = map[y][x];
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(map[ny][nx] <= now) continue;
            
            total += Math.max(search(ny, nx), 1) % div;
        }
        dp[y][x] = total;
        return total;
    }

    static int gcd(int n1, int n2) {
        return (n2 == 0)?n1:gcd(n2, n1%n2);
    }

    /**
     * 最小公倍数を求める公式
     * @param a
     * @param b
     * @return
     */
    static int lcm(int a, int b){
        return a * b / gcd(a, b);
    }


    public static void main(String[] args) throws Throwable {
        try (Scanner sc = new Scanner(System.in)) {
            new Main().solveB(sc);
        }
    }

}
