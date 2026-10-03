
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jaga on 9/6/16.
 * dpで解けるかな?
 * 入力の数字を -Aしておき、組み合わせで0が何通り作れるかを考える
 * dp[j][k] = j番目(0-indexed)までの文字をつかってkが何回作れるか  j < N , - N*50 < k < N*50 + 1
 * kの値は k + N*50　としておく(負の値の処理のため)
 * dp[j][k] = dp[j - 1][k] + dp[j-1][k - x[j]]
 * j-1番目までの数で作ってj番目は使わない + j - 1番目までの数でk-x[j]をつくってjを使う
 * これに+してx[j]がkのときはdp[j-1][k] = 0でも1足すことになる（コーナーケース）
 */
public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String text[] = line.split(" ");

        int N,A;
        N = Integer.parseInt(text[0]);
        A = Integer.parseInt(text[1]);

        line = br.readLine();
        text = line.split(" ");

        int [] x = new int[N];

        for(int i = 0; i < N ; i++){
            x[i]  = Integer.parseInt(text[i]) - A;
//            System.out.println(x[i]);
        }

        long dp[][] = new long [N][N * 50 * 2 + 1];
        int dpl = 50 * N;

        dp[0][x[0] + dpl] = 1;

        for(int j = 1; j < N; j++){

            for(int k  = -1 * N * 50; k < N * 50 + 1; k++){
//                System.out.println(k + dpl - x[j]);
                if(k + dpl - x[j] >= 0 && k + dpl - x[j] <= 50*N*2){
//                if(k + dpl - x[j] >= 0 ){
                    dp[j][k + dpl] = dp[j-1][k + dpl] + dp[j-1][k + dpl - x[j]];
                }else {
                    dp[j][k + dpl] = dp[j - 1][k + dpl];
                }
                if(x[j] == k) dp[j][k + dpl] ++;

//                System.out.println("dp[" + j + "][" + k + "] = " + dp[j][k + dpl]);
            }
        }


        System.out.println(dp[N - 1 ][dpl]);
    }
}
