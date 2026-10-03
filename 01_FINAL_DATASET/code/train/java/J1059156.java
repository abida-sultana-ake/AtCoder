import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int ans = K*pow(K-1,N-1);
        System.out.println(ans);
        
    }
    static int pow(int a, int x){
        if(a==1||x==0)return 1;
        if(x%2==0){
            return pow(a*a,x/2);
        }else{
            return a*pow(a,x-1);
        }
    }
}