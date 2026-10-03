import java.util.Scanner;
import java.util.function.LongSupplier;
import java.util.stream.IntStream;

public class Main{
	static final Scanner s=new Scanner(System.in);
	static final long[] fal_rnd(long[] ar,LongSupplier sp){
		int l=-1,r=ar.length;
		while(l+1!=r)
			ar[Math.random()<0.5?++l:--r]=sp.getAsLong();
		return ar;
	}
	static final IntStream REPS(int v){
		return IntStream.range(0,v);
	};
	public static void main(String[] __){
		int a=s.nextInt(),b=s.nextInt(),c=s.nextInt();
		if(a==b) {
			System.out.println(c);
			return;
		}
		if(b==c)
			System.out.println(a);
		if(a==c)
			System.out.println(b);
	}
}
