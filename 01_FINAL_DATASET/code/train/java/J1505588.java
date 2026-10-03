import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long ans = 1;
        for(int i=0; i<N; i++){
            long T = sc.nextLong();
            ans = lcm(T,ans);
        }
        System.out.println(ans);
    }
    static long gcd(long A, long B){
        while(true){
            long tmp = A%B;
            if(tmp==0){
                break;
            }
            A = B;
            B = tmp;
        }
        return B;
    }
    static long lcm(long A, long B){
        return A/gcd(A,B)*B;
    }
}