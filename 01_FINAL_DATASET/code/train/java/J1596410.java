import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 整数の入力                                                                                                                              
        int N = sc.nextInt();
        int K = sc.nextInt();
        int xi;
        int Sum = 0;
	int i;
        for(i=0;i<N;i++){
            xi = sc.nextInt();
            if(K-xi < xi){
                Sum += K-xi;
            }else{
                Sum += xi;
            }
        }
        System.out.println(2*Sum);
    }
}


