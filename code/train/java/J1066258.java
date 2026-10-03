import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long A = sc.nextInt();//walk
        long B = sc.nextInt();//teleport
        //the best way: ascending order
        long[] town = new long[N];
        for(int i=0;i<N;i++)town[i]= sc.nextInt();
        long tired = 0;
        for(int i=0;i<N-1;i++){
        	long distance = town[i+1] - town[i];
        	tired += Math.min(distance*A,B);
        }
        System.out.println(tired);
    }
}