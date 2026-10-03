
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long answer =1;
        int modulo = 1000000007;

      //  HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=2;i<=n;i++){
            if(isPrime(i)){
                answer *= (calFactors(n,i)+1);
                if(answer>modulo){
                    answer = answer%modulo;
                }
            }
        }


        System.out.print(answer);

        sc.close();
    }

    private static boolean isPrime(int x){
        for(int i=2;i<x;i++){
            if(x%i==0) return false;
        }
        return true;
    }

    private static int calFactors(int n,int base){
        int ret = 0;
        int tmp = base;
        while(tmp<=n) {
            ret +=  Math.floor( n / tmp);
            tmp *=base;
        }

        return ret;
    }

}