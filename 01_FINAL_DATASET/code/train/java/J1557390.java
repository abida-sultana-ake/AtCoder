import java.util.Scanner;
import java.util.stream.IntStream;

public class Main{
	static IntStream REPS(int v){return IntStream.range(0,v);}
	static IntStream REPS(int l,int r){return IntStream.rangeClosed(l,r);}
	static IntStream INS(int n) {return REPS(n).map(i->getInt());}
	static Scanner s=new Scanner(System.in);
	static int getInt(){return Integer.parseInt(s.next());}

	public static void main(String[]$){
		int[]c=new int[114514];
		INS(getInt()).forEach(i->++c[i]);
		
		System.out.println(
				REPS(1,100000).map(i->c[i-1]+c[i]+c[i+1]).max().getAsInt()
				);
	}
}