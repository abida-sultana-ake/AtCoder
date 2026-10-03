import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        solve(X);
    }
    static void solve(int X){
        int L = 0;
        int R = 1000000000;
        while(true){
            int M = (L+R)/2;
            if(L==M)break;
            if(check(M,X)){
                R=M;
            }else{
                L=M;
            }
        }
        if(!check(L,X))L++;
        System.out.println(L);
    }
    static boolean check(int N, int X){
        long P = (long)(N)*(N+1)/2;
        if(P>=X){
            return true;
        }else{
            return false;
        }
    }
}
