import java.util.Scanner;

public class Main {
    public static Scanner sc;
    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        
        int h = sc.nextInt();
        int w = sc.nextInt();
        
        char[][] org = new char[h+2][w+2];
        char[][] make = new char[h+2][w+2];
        char[][] out = new char[h+2][w+2];
        
        init(make, h, w);
        init(out, h, w);
        
        // show(make, h, w);
        // show(out, h, w);
        for (int i = 0; i < h+2; i++) {
            if (i == 0 || i == h+1) {
                for (int j = 0; j < w+2; j++) {
                    org[i][j] = '#';
                }
            } else {
                String s = sc.next();
                for (int j = 0; j < w+2; j++) {
                    if (j == 0 || j == w+1) {
                        org[i][j] = '#';
                    } else {
                        org[i][j] = s.charAt(j-1);
                    }
                }
            }
        }
        
        for (int i = 0; i < h+2; i++) {
            if (i == 0 || i == h+1) {
                continue;
            }
            for (int j = 0; j < w+2; j++) {
                if (j == 0 || j == w+1) {
                    continue;
                }
                if (isBlack(i, j, org)) {
                    make[i-1][j-1] = '#';
                    make[i-1][j] = '#';
                    make[i-1][j+1] = '#';
                    make[i][j-1] = '#';
                    make[i][j] = '#';
                    make[i][j+1] = '#';
                    make[i+1][j-1] = '#';
                    make[i+1][j] = '#';
                    make[i+1][j+1] = '#';
                    out[i][j] = '#';
                }
            }
        }
        
        // show(org, h, w);
        // show(make, h, w);
        // show(out, h, w);
        
        if (compare(org, make, h, w)) {
            System.out.println("possible");
            show(out, h, w);
        } else {
            System.out.println("impossible");
        }
    }
    
    public static boolean isBlack(int i, int j, char[][] ary) {
        boolean res = true;
        res &= ary[i-1][j-1] == '#';
        res &= ary[i-1][j] == '#';
        res &= ary[i-1][j+1] == '#';
        res &= ary[i][j-1] == '#';
        res &= ary[i][j] == '#';
        res &= ary[i][j+1] == '#';
        res &= ary[i+1][j-1] == '#';
        res &= ary[i+1][j] == '#';
        res &= ary[i+1][j+1] == '#';
        return res;
    }
    
    public static void init(char[][] ary, int h, int w) {
        for (int i = 0; i < h+2; i++) {
            if (i == 0 || i == h+1) {
                for (int j = 0; j < w+2; j++) {
                    ary[i][j] = '#';
                }
            } else {
                for (int j = 0; j < w+2; j++) {
                    if (j == 0 || j == w+1) {
                        ary[i][j] = '#';
                    } else {
                        ary[i][j] = '.';
                    }
                }
            }
        }
    }
    
    public static boolean compare(char[][] o, char[][] m, int h, int w) {
        for (int i = 0; i < h+2; i++) {
            if (i == 0 || i == h+1) {
                continue;
            }
            for (int j = 0; j < w+2; j++) {
                if (j == 0 || j == w+1) {
                    continue;
                }
                if (o[i][j] != m[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void show(char[][] ary, int h, int w) {
        for (int i = 1; i < h+1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < w+1; j++) {
                sb.append(ary[i][j]);
            }
            System.out.println(sb.toString());
            sb.delete(0,sb.length());
        }
   }
}