import java.util.*;
import java.io.*;

public class Main {
	static int  N;
	static long A,B;
	static long[] HP;
	public static long binary(int low, int high){//answer is low, low+1,... high
		if(low>=high) return low;
		int center = low + (high-low)/2;
		//analyze the magic
		//1."attack all enemies, damage 'B'"
		//2."attack one enemy, damage 'A'-'B'"
		//the magicians can use both magics for 'center' times. Can I defeat all enemies?
		
		//use magic1 for c times, and then use magic2 as many times as I need
		long need =0;
		//
		for(int n=0;n<N;n++){
			need += Math.max(0, ((HP[n]-B*center)+A-B-1)/(A-B));
		}
		if(need<=center){//you can defeat enemies in 'center' times
			return binary(low, center);
		}else{
			return binary(center+1,high);
		}
	}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	A = sc.nextLong();
    	B = sc.nextLong();
    	HP = new long[N];
    	for(int n=0;n<N;n++){
    		HP[n]=sc.nextLong();
    	}
    	System.out.println(binary(1,1_000_000_000));
    }
}