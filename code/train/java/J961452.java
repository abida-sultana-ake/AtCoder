import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Here your code !
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int length = S.length();
        long sum = 0;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length+1;j++){
                int sum1 = 0;
                int sum2 = 0;
                if(j==length){
                    sum1=1;
                }else{
                    for(int k=0;k<length-j;k++){
                        sum1 += Kumi(length-j-1,k);
                    }
                }
                if(i==0){
                    sum2=1;
                }else{
                    for(int k=0;k<i;k++){
                        sum2 += Kumi(i-1,k);
                    }
                }
                sum += Long.parseLong(S.substring(i,j))*(sum1*sum2);
            }
        }
        
        System.out.println(sum);
    }
    static int Kumi(int n,int m){
        if(n==-1||n==0||m==0){
            return 1;
        }else{
            return factorial(n)/factorial(n-m)/factorial(m);
        }
    }
    
    
    static int factorial(int n){
        int fact = 1;
        if (n == 0)
            return  fact;
        else { // in case of n > 0
            for (int i = n; i > 0; i--)
                fact *= i;
            return fact;
        }
    }
}
