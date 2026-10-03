import java.util.Scanner;

/**
 * http://abc042.contest.atcoder.jp/tasks/arc058_b
 * 
 * @author Cummin
 */
public class Main {
    
    public static void main(String[] args) {
        int H, W, A, B ;
         // データの読み込み
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        
        routes5(H, W, A, B) ;
        
    }
    static void routes5(int H, int W, int A, int B){
        
        // 逆数の表を作成する
        int inv[] = new int[H] ;
        for (int i=1 ; i<=H ; i++) {
            inv[i-1] = Fermat_Inverse(1000000007, i) ;
        }
        
        // Grid (Cell(B,1),..., Cell(B,(H-A)) を求める　(差分を計算していく)
        int Cell1[] = new int [H-A] ;
        Cell1[0] = 1 ;
        for (int i = 2 ; i <= (H-A); i++) {
            Cell1[i-1] = (int) ((long)Cell1[i-2] * (B+i-2) % 1000000007 * inv[(i-1)-1] % 1000000007) ; 
            // 注: 途中に、" % 1000000007 " を入れないとオーバーフローする
       }
        // 同様に　Grid (Cell((W-B),H-A),..., Cell((W-B),1) を求める
        int Cell2[] = new int[H] ;
        Cell2[0] = 1 ;
        for (int i= 2 ; i <= H ; i++) {
            Cell2[i-1] = (int) ((long)Cell2[i-2] * ((W-B)+i-2) % 1000000007 * inv[(i-1)-1] % 1000000007) ;
        }
        // 最後に、隣通しのCell1とCell2を掛けて、総和を出す
        long ans = 0 ;
        for (int i= 1; i <= (H-A); i++) {
            ans = (ans +((long) Cell1[i-1] * Cell2[H-i])% 1000000007) % 1000000007 ;
    }
        System.out.println(ans) ;
    }
    static int Fermat_Inverse(int m, int x) { // 法 mにおける xの逆元
        return Exponential(x, m-2, m) ;
    }
    static int Exponential(int x, int y, int m) { // x^y % m
        long ans = 1 ;
        int  bit = 0x040000000 ;
        while (bit > 0) {
            if ((y & bit)!=0){
                ans = (ans * x) % m ;
            }
            if (bit > 1 ) {
                bit = bit >>1 ;
                ans = (ans * ans) % m ;
            } else {
                bit = bit >> 1 ;
            }
        }
        return (int) ans ;
    }
}
//////////////////////////////////////////////////////////////////////////////////    
        // 座標 (1,1)から(M,N)へのルートは、(M+N-2)!/((M-1)!(N-1)!)
        // a, b, c,..,xまでの数を求めて、各々からゴールGまでのルート数を計算する
        /*    1 2 3 4 5 6 ... B-B+1......W
            1 *               a-a'
            2                 b-b'
            3                 c-c'
            .
            .
          H-A                 x-x'
            .------------------
            .------------------
            H------------------          G
        */
//////////////////////////////////////////////////////////////////////////////////    
