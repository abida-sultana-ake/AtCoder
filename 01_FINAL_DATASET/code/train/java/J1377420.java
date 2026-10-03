import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        String [] S = {"delicious","safe","dangerous"};
        System.out.println(S[judge(X,A,B)]);
    }
    static int judge(int X, int A, int B){
        if(A>=B)return 0;
        if(X>=B-A)return 1;
        return 2;
    }
}