import java.util.*;
/**
 * Created by 卢嘉昊 on 2017/8/12.
 */
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long clock[] = new long[N];
        for(int i=0;i<N;i++){
            clock[i] = scan.nextLong();
        }
        long res = 1;
        for(int i=0;i<N;i++){
            res = nextRes(res,clock[i]);
        }
        System.out.println(res);
    }

    public static long nextRes(long res,long num){
        if(res%num==0) return res;
        long g = gcd(num,res);
        return res*(num/g);
    }

    public static long gcd(long s,long b){
        if(s == 1) return 1;
        if(b%s == 0) return s;
        return gcd(b%s,s);
    }

}