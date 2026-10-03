import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] s = new int [N];
        int sum = 0;
        for(int i=0; i<N; i++){
            s[i] = sc.nextInt();
            sum+=s[i];
        }
        System.out.println(function(N,s,sum));
    }
    static int function(int N, int [] s, int sum){
        if(sum%10!=0) return sum;
        boolean [] boo = new boolean [sum+1];
        boo[0] = true;
        for(int i=0; i<N; i++){
            for(int j=sum; j>=0; j--){
                if(boo[j]){
                    boo[j+s[i]] = true;
                }
            }
        }
        for(int j=sum; j>=0; j--){
            if(boo[j]&&j%10!=0){
                return j;
            }
        }
        return 0;
    }
}