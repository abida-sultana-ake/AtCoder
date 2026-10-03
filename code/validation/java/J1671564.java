
import javax.xml.crypto.Data;
import java.util.*;
import java.io.*;

public class Main {
    static int C = 1000000007;

    public static void main(String[] args) throws IOException{

        //入力
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();


        // 出力
        long ans = (factorial(N) * factorial(M)) % C;

        if(N == M){
            System.out.println((2 * ans) % C);
        }
        else if(M == N + 1 || N == M + 1){
            System.out.println(ans);
        }
        else{
            System.out.println(0);
        }

    }

    static long factiter(int n, long product) {
        if (n == 1) return product;
        return factiter(n - 1, n * product % C);
    }
    static long factorial(int n){
        long product = 1;
        for(int i = 1; i <= n; i++){
            product = product * i % C;
        }
        return product;
    }
}